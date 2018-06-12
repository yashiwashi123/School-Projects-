import javax.swing.JFrame;
import java.awt.event.*;

/*
  Main user interface with an editor.
  This class responds to key events.
  It maintains two modes: insert and command mode.
  During insertion, text chars are inserted.
  During command mode, some characters have special
  meanings.

 */
public class Edit implements KeyListener {
    private JFrame frame;
    public static int WIDTH = 420; // frame width/height
    public static int HEIGHT = 100;
    private EditPanel editpanel; // editing panel
    public static boolean DEBUG = true;
    public editBuffer editbuffer; 
    public editBuffer[] lines; 
    //creates an array of editbuffers which act as the lines in the text editor
    // false = command mode; true = insert mode
    private boolean insertmode = false; 
    private String filename; // filename for all read/write cmds

    /*
      Create a line editing frame.
    */
    public Edit(String fname) {
	filename = fname;
	frame = new JFrame("Line Editor");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	editpanel = new EditPanel();
	frame.add(editpanel);
	frame.addKeyListener(this);
	
	editbuffer = new editBuffer();

	frame.setSize(WIDTH,HEIGHT);
	frame.setVisible(true);
    }

    /** Must be provided due to interface. */
    public void keyReleased(KeyEvent e) {
	/// does nothing
    }
    /** Must be provided due to interface. */
    public void keyTyped(KeyEvent e) {
	/// does nothing
    }

    /*
      Action to perform when a key is pressed.
    */
    public void keyPressed(KeyEvent e) {
	int id = e.getID();
        String keyString;
	int keyCode = e.getKeyCode();    

	if (DEBUG) {
	    String keyText = KeyEvent.getKeyText(keyCode);
	    keyString = "key code = " + keyCode + " (" + keyText + ")";

	    System.out.println(keyString);
	}

	if (insertmode) { // inserting text
	    if (keyCode == KeyEvent.VK_ESCAPE) { // stop insertmode
		insertmode = false;
	    } else {
		insertChar(e);
	    }
	}
	else { // Edit mode keys cause functions to fire
	    switch (keyCode) {
	    case KeyEvent.VK_UP: //uparrow go up one line
	    case KeyEvent.VK_K:
		upLine();
		break;
	    case KeyEvent.VK_DOWN: //down go down one line
	    case KeyEvent.VK_J: //
		downLine();
		break;
	    case KeyEvent.VK_RIGHT: // rightarrow, one char right
	    case KeyEvent.VK_L: // l  
		
		editpanel.moveCursor(+1);
		
		editbuffer.moveCursorRight();
		

		break;
	    case KeyEvent.VK_LEFT: // leftarrow, one char left
	    case KeyEvent.VK_H: // h
		editpanel.moveCursor(-1);
		editbuffer.moveCursorLeft();
		break;
	    case KeyEvent.VK_Q: // quit the application
		frame.setVisible(false);
		frame.dispose();
		break;
	    case KeyEvent.VK_I: // insert text at cursor
		insertmode = true;
		break;
	    case KeyEvent.VK_D: // delete line
		editpanel.setText("");
		break;
	    case KeyEvent.VK_R: // read file
		readFile();
		break;
	    case KeyEvent.VK_W: // write file
		//saveFile();
		break;
		case KeyEvent.VK_DELETE: 
		editbuffer.backspace();

		editpanel.setText(editbuffer.toString());
		break;
	    }	    
	    
	}
	
    }

    /* 
       Return true iff c is a printable character.
       This set is restricted to common chars.
     */
    private boolean legal(char c) {
	if (c >= 'A' && c <= 'Z') return true;
	if (c >= 'a' && c <= 'z') return true;
	if (c >= '0' && c <= '9') return true; 
	if (c == ' ' || c == '\t' || c == '\n') return true;
	if (c == '.' || c == '?' || c == '!' ||
	    c == ';' || c == ':'|| c == '-') return true;

	return false;
    }
    //public char[] stuff; 

    /** 
	TODO
	Insert char at point of cursor.

	Currently this just appends text.
	This is not adequate!

    */
    private void insertChar(KeyEvent e) {
	char c = e.getKeyChar();
	if (legal(c)) { 
		
		editbuffer.append(c);
		
	    //editbuffer.insert(c);
	    editpanel.setText(editbuffer.toString());
	    }

    }	


    /**
	TODO
       Comment!!!
     */
    private void upLine() {
    	

    }

    /**
	TODO
       Comment!!!
     */
    private void downLine() {

    }

    /**
	TODO
       Comment!!!
     */
    private void readFile() {

    }

    /**
	TODO
       Comment!!!
     */
   // private void saveFile(String fileName, String content) {

  //  }


    /**
       Run the edit application.
    */
    public static void main(String args[]) {
	String filename = "foo.txt"; // default filename to output
	if (args.length == 1) filename = args[0];
	System.out.println("Read/write from file: " + filename);
	Edit edit = new Edit(filename);
    }

}
