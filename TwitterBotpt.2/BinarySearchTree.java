import java.util.LinkedList;
import java.util.Quere;

/**
   Implements a BinarySearchTree (BST).  Given a node r, all nodes in
   the left subtree of r are less than r.  All nodes in the right
   subtree of r are greater than or equal to r.

   Only KeyedObjects can be stored in the tree.

   @author: S. Anderson  */


public class BinarySearchTree extends LinkedBinaryTree {
    
    public BinarySearchTree() { super(); root = null; }

    /**
       Adds an element to the tree.

       @param o an element that can be compared to others in the tree.
    */
    public void addElement(KeyedObject o) {
	if (root == null) root = new BTNode(o,null,null);
	else addElement(root,o);
    }

    /* 
       Helper method for adding element
       @param t root node of tree to which o is added.  Must NOT be null.
       @param o object to be inserted
     */
        private void addElement(BTNode t,KeyedObject o) {
        	BTNode newNode = new BTNode(o, null, null); 
	    // o less than t.element
        	BTNode curr = t; 
	    	//creates a loop that checks if the current node had a null slot where the added element wants to go, if not
	    	// the current node gets changed to either curr.left or curr.right depending 
	    	//on the value of it's element in comparison to the Keyed Object o. 
	    	while(true){ 
	    		if (o.key().compareTo(((KeyedObject) curr.element).key()) < 0) {
	    			if (curr.left == null) { 
	    				curr = curr.left;}
	    		
	    			else {
	    				curr.left = newNode; 
	    				break;
	    			}	
	    		}
	    			
	    		if (o.key().compareTo(((KeyedObject) curr.element).key()) >= 0) {
	    			if (curr.left.element == null) { 
	    				curr = curr.right;}
	    		
	    			else {
	    				curr.right = newNode;
	    				break;  
	    			}	
	    		}




	    	}
	    }

/*
	    if (o.key().compareTo(((KeyedObject) t.element).key()) < 0) {
		// add to left subtree
		if (t.left == null) t.left = new BTNode(o,null,null);
		else //addElement(t.left,o);
			{while (t.left!=null){ 
			    if (o.key().compareTo(((KeyedObject) t.element).key()) < 0){ t = t.left;}
			    else { t = t.right;}
		}
		}
	    }
	    else {
		// if o >= t, add to right subtree
		if (t.right == null) t.right = new BTNode(o,null,null);
		else 
			{while(t.right != null) { 
				if (o.key().compareTo(((KeyedObject) t.element).key()) < 0){ t = t.left;}
			 	else { t = t.right;}
			}

	    }
	    
    }
}

    /**
       Return element that matches
    */

    public KeyedObject  getElement(KeyedObject o) {
	if (o == null) return null;
	else return getElement(root,o);
    }

    private KeyedObject getElement(BTNode t, KeyedObject o) {
	if (t == null ) return null;
	BTNode curr = t; 
	while (true){


		if ( ((KeyedObject)t.element).key().compareTo(o.key()) == 0)
	    	return (KeyedObject) t.element;
		//if the object is found, return the object


		else if ( o.key().compareTo( ((KeyedObject)t.element).key()) < 0)
	    	curr = curr.left; 
	//if the object is less than the current node, move to the left
		else
	    	return getElement(t.right,o);	    
	    		curr= curr.right; 
	 //if the object is greater than the current node, move left
    }


    /**
       Remove element with matching key and return it.
       @returns First object in tree with matching key.  Returns null
       if no match found.
    */
    public KeyedObject  removeElement(KeyedObject o) {
	if (root == null || o == null) return null;
	else return removeElement(root,o);
    }
 	

    //there is no real recursion in the following code

    private KeyedObject removeElement(BTNode t, KeyedObject o) {
	// nothing to remove from empty tree
	if (t == null) return null;
	
	// Find the node that is to be removed.
	//	BTNode remnode = findmatch(BTNode t, o.key());

	BTNode parentofp = null;
	BTNode p = t;
	
	while (p != null) {
	    int comp = o.key().compareTo( ((KeyedObject) p.element).key());
	    if (comp == 0) break;
	    // move to child of p
	    parentofp = p;

	    if (comp < 0) 
		p = p.left;
	    else 
		p = p.right;
	}
	// INVARIANT: p is the node to delete.  parentofp is its parent
	if (p == null) return null; // no match found
	/*
	  3 cases
	  1. p is a leaf
	  2. p has one child
	  e. p has two children
	*/
	System.out.println("found " + p.element);
	//swap code 
	if (p.left == null && p.right == null) // p is leaf
	    if (p == root) { 
	    	root = null; 
		}
		else {
	   	 	if (p == parentofp.left) parentofp.left = null;
	    	else parentofp.right = null;
		}
	else if (p.left == null || p.right == null)  // p has one subtree
	    BTNode c; // child node to save
	    if (p.left == null) c = p.right;
	    else c = p.left;
	    
	    if (p == root) {
		root = c;
	    }
	    else {
		if (p == parentofp.left) parentofp.left = c;
		else parentofp.right = c;
	    }
	else
	    removeTwoSubtrees(p,parentofp);
	return (KeyedObject) p.element;
    }

    /*
      Remove a leaf.  The node p must be a leaf
      and pp must be its parent node.
      If p is root, then root is set to null.
    */
    private void removeLeaf(BTNode p, BTNode pp) {
	if (p == root) { 
	    root = null; 
	}
	else {
	    if (p == pp.left) pp.left = null;
	    else pp.right = null;
	}
    }	

    /**
       Remove p when it has only one subtree.
    */
    private void removeOneSubtree(BTNode p, BTNode pp) {
 	    BTNode c; // child node to save
	    if (p.left == null) c = p.right;
	    else c = p.left;
	    
	    if (p == root) {
		root = c;
	    }
	    else {
		if (p == pp.left) pp.left = c;
		else pp.right = c;
	    }
    } 


    /**
       Remove p when it has two subtrees.  In this
       case we replace material in p with greatest element in 
       p's left subtree (maxnode).
    */
    private void removeTwoSubtrees(BTNode p, BTNode pp) {

	// find maxnode
	BTNode maxnode = p.left;
	BTNode pmaxnode = p;

	while (maxnode.right != null) {
	    pmaxnode = maxnode;
	    maxnode = maxnode.right;
	}
	// INVARIANT: maxnode is biggest node in left subtree of p
	// maxnode's parent is pmaxnode
	// maxnode cannot have a right child

	p.element = maxnode.element;
	removeOneSubtree(maxnode,pmaxnode);
    } 

    /**
       Return node that contains match to the key.
       Returns null if no match found.
    */
    private BTNode findmatch(BTNode t, Comparable key) {
	BTNode parentofp = null;
	BTNode p = t;
	
	while (p != null) {
	    int comp = key.compareTo( ((KeyedObject) p.element).key());

	    // move to child of p
	    parentofp = p;

	    if (comp == 0) break;
	    else if (comp < 0) 
		p = p.left;
	    else 
		p = p.right;
	}	    
	return p;
    }
    
    /* 
       Returns height of tree.  Returns -1 if tree has no node. 
       sets heights in all encountered nodes.
    */
    private int height(BTNode t) {
	if (t == null) return -1;
	//this is the base case 
	
	Queue<BTNode> q = new LinkedList();
	//creates an empty queue to traverse levels
	q.add(t); 
	//add root onto que
	int treeheight = 0; 
	//initiualizes height of tree
	while (true){ 
		//nodeCount is the number of nodes in the queue at the current level
		int nodeCount = q.size();
		if (nodeCount == 0)
			return treeheight; 
		treeheight++; 
		//tree height increments 
		while (nodeCount>0)
			//removes(dequeues) all nodes current level nodes while adding all nodes of the next level
		{
			Node newnode = q.peek(); 
			q.remove(); 
			if (newnode.left != null){
				q.add(newnode.right); 
			nodeCount--; 	
			}
		}
	}
    }


    /**
       Find heights of all nodes in tree.
    */
    public void computeNodeHeights() {
	height(root);
    }



    /******************************************************************/
    /* Graphics and display methods. */
    /******************************************************************/


    /**
       Return map containing keys.  Map is used
       to generate graphical representation of tree.
    */
    public KeyedObject[][] getMap() {
	int maxsize = 50;
	int maxrow = height(root)+1; // maximum height + 1
	int maxcol = (int) Math.pow(2.0,maxrow); //max cols in binary tree
	

	KeyedObject[][] map = new KeyedObject[20][20];
	// fill array with keys from tree nodes.
	maxcol = drawTree(root,map,0,0,maxrow);

	KeyedObject[][] newmap = new KeyedObject[maxrow][maxcol];
	for (int i = 0; i < newmap.length; i++) {
	    for (int j = 0; j < newmap[i].length; j++)
		newmap[i][j] = map[i][j];
	}
	return newmap;
    }


    /**
       Draw a binary search tree to stdout. (text)
    */
    public void showTree() {
	// map holds pointers to all objects in the tree
	// cannot handle more than 400 nodes on a page.
	KeyedObject[][] map = new KeyedObject[20][20];
	int maxcol = 0;
	int maxrow = height(root)+1;
	// fixed field width for each node and for each blank
	final String padding = "   "; 

	System.out.println("Tree height is " + (maxrow-1));

	// fill array with keys from tree nodes.
	maxcol = drawTree(root,map,0,maxcol,maxrow);

	// use keys in map to place 
	for (int row = 0; row < maxrow; row++) {
	    for (int col = 0; col < maxcol; col++) {
		// if no node, print padding
		if (map[row][col] == null) System.out.print(padding);
		// if there is a node print it in a field of 
		//length padding.length
		else padPrint(map[row][col],padding.length());
	    }
	    System.out.println();
	}
    }

    /* print padding around strings */
    private void padPrint(KeyedObject o, int padlen) {
	String s = o.key().toString();
	System.out.print(s);
	int len = s.length();
	while (len++ < padlen) {
	    System.out.print(' ');
	}

    }


    /*
      Position tree nodes in a 2D array by first position left subtree,
      then node, then right subtree.
      @returns col, the maximum column used.
     */
    private int drawTree(BTNode root, KeyedObject[][] map,
				 int row, int col, int maxrow) {
	// stop if leaf node or if map dimensions exceeded
	if (root == null) return col;
	if ((maxrow+1) >= map.length || 
	    (col+1) >= map[0].length) {
	    System.out.println("WARNING. Tree could not be completely printed.");
	    return col; 
	}
	// maximum row (level) containing a node
	if (row > maxrow) maxrow = row; 
	
	col = drawTree(root.left,map,row+1,col,maxrow);
	map[row][col] = ((KeyedObject) root.element);
	col++;
	col = drawTree(root.right,map,row+1,col,maxrow);	
	return col;
    }

    /**
       Update drawing positions in tree prior to draw.
    */
    public void updatePositions() {
	positionNodes(root,0,0);
    }

    /**
       Update x,y in each node.
       y is the row = node depth.
       x is the col = #preceding nodes in left subtree + 1
    */
    private int positionNodes(BTNode r, int row, int col) {
	// stop if leaf node
	if (r == null) return col;
	
	// set position left subtree nodes
	col = positionNodes(r.left,row+1,col); 

	// set position of this node
	r.y = row;  // 
	r.x = col;
	col++;
	// set pos of right subtree nodes
	col = positionNodes(r.right,row+1,col); 
	return col;
    }





}
