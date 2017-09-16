/**
   Class to support nodes in a binary tree.  BTNode's data has package
   access.  Out-of-package classes must use public methods to use the
   tree.  
   @author: S. Anderson
*/

public class BTNode { 

    // Note: these all have package access!
    Object element; // data
    BTNode left; // left subtree
    BTNode right; // right subtree
    int x, y; // x and y coords for drawing
    int height; // height of node

    public BTNode() {
	this(null,null,null);
    }

    public BTNode(Object o) {
	this(o,null,null);
    }

    public BTNode(Object o, BTNode l, BTNode r) {
	left = l;
	right = r;
	element = o;
    }


    public Object element() { return element; }
    public void setElement(Object o) { element = o;}

    public BTNode left() { return left; }
    public BTNode right() { return right; }

    public void setLeft(BTNode v) { left = v; }
    public void setRight(BTNode v) { right = v; }

}
    
