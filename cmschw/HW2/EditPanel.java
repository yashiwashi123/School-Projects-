import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

/**
  JPanel for representing a single
  line of text that can be modified.
  @author S. Anderson

  You should not need to change this file.
*/
public class EditPanel extends JPanel {
    private int cursorx; // cursor position on x-axis
    private int cursory; // cursor position on y-axis
    private int basey;  // base of text
    private int basex; // min X position
    private int maxx; // maximum X position
    private int charW;  // width of one char
    private int charH; // height of one char
    private String text = "Text shows here."; // text to display
    
    public EditPanel() {
	super();
	// set up font and font specs
	Font font = new Font(Font.MONOSPACED,Font.BOLD,16);
	setFont(font);
	FontMetrics fm = getFontMetrics(font);
	charW = fm.charWidth('x');
	charH = fm.getHeight();
	// set text position
	basex = 5;
	maxx = Edit.WIDTH - 2 * basex;
	basey = (int)(Edit.HEIGHT * 0.6);
	// set cursor position
	cursorx = basex;
	cursory = (int)(basey + 0.6*charH);
	System.out.println("Max" + maxChars());
    }

    /**
       Sets visible text in window.
       Only sets up to maximum displayed characters.
       Causes redraw of panel.
    */
    public void setText(String s) {
	if (s.length() > maxChars()) {
	    text = s.substring(0,maxChars());
	} else {
	    text = s;
	}
	repaint();
    }

    /* 
       Return currently stored text.
    */
    public String getText() {
	return text;
    }

    /* 
       Move cursor n characters to right (>0) or left (<0).
       POST: Cursor moved.  No movement if move would take
       cursor out of panel.  Causes redraw of panel.
    */

    public void moveCursor(int n) {
	if (n < 0) {

	    if (cursorx + n * charW >= basex) {
		cursorx += n * charW;
	    }
	} else {
	    if (cursorx + n * charW < maxx) {
		cursorx += n * charW;
	    }
	}
  System.out.println("i bet you work :((you don't even work)");
	repaint();
    }
    /*
      Return maximum num chars you can display.
    */
    public int maxChars() {
	return (maxx - basex) / charW;
    }

    /*
      Current cursor position (in units of a char).
    */
    public int cursorPos() {
	return (cursorx - basex) / charW;
    }
    
    /**
       Do not call this method directly.
       Call repaint() if you must force a redraw.
    */
    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	g.drawString(this.text,basex,basey);
	g.setColor(Color.RED);
	g.drawString("^",cursorx,cursory);
	g.setColor(Color.BLACK);
    }


}