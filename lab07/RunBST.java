import java.util.*;
import java.io.*;


/**
   This application permits the user to interactively construct, view,
   and destroy a binary search tree.  This BST permits duplicate keys.
   @author: S. Anderson
*/
public class RunBST {

    public static void main(String[] args) {
	Random rand = new Random();
	BinarySearchTree tree = new BinarySearchTree();  // the tree
	BufferedReader stdin = 
	    new BufferedReader(new InputStreamReader(System.in));
	char menuchoice = 'h'; // menu choice character entered by user
	String helpmsg = "Menu: a (add node), f (find node), n (new tree), " +
	    "p (print), d (delete node), h (help)";
	boolean quit = false; // quit the application?

	BTDisplay display = new BTDisplay(tree);

	while (true) {
	    
	    try {
		// get input from user
		System.out.print("Select>> ");
		menuchoice = stdin.readLine().charAt(0);

		// take appropriate action
		switch (menuchoice) {

		case 'a': // add a node
		    System.out.print("Enter integer to add: ");		    
		    int i = Integer.parseInt(stdin.readLine());
		    tree.addElement(new KeyedInt(i));
		    display.repaint();
		    break;
		case 'f': // find an object in a node
		    System.out.print("Enter integer to find: ");
		    int fi = Integer.parseInt(stdin.readLine());

		    if (tree.getElement(new KeyedInt(fi)) == null) 
			System.out.println("Didn't find it.");
		    else
			System.out.println("Found it.");
		    break;
		case 'n': // new tree, new display too
		    tree = new BinarySearchTree();
		    System.out.println("Tree deleted.  New tree!.");
		    display.close();
		    display = new BTDisplay(tree);
		    display.repaint();
		    break;
		case 'p': // print tree
		    tree.inOrder();
		    break;
		case 'd': // remove node from tree
		    System.out.print("Enter integer to delete: ");
		    int ri = Integer.parseInt(stdin.readLine());
		    tree.removeElement(new KeyedInt(ri));
		    display.repaint();
		    break;
		case 'h': // print help message
		    System.out.println(helpmsg);
		    break;
		case 'q': // quit
		    System.out.println("Quitting.");
		    quit = true;
		    display.quit(); // close display
		    break;
		default: 
		    System.out.println("Menu choice not recognized.");
		    System.out.println(helpmsg);
		}	    
		if (quit) break; // quit the app.
	    }
	    catch (IOException e) {
		System.out.println("Read error.  Try again.");
	    }


	}
    }
}
