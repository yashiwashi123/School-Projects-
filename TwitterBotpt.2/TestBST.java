import java.util.*;

public class TestBST {


    public static void main(String[] args) {
	Random rand = new Random();
	BinarySearchTree tree = new BinarySearchTree();

	int n = 20;
	int[] rnum = new int[n];
	for (int i=0; i < n; i++) {
	    rnum[i] = rand.nextInt(100);
	    tree.addElement(new KeyedInt(rnum[i]));
	}

	// an inorder traversal should list the items 
	// in ascending order
	tree.inOrder();
	System.out.println();

	for (int i=0; i < n; i++) {
	    if ( tree.getElement(new KeyedInt(rnum[i])) == null)
		System.out.println("Failed to find " + rnum[i]);
	}
	    

	tree.showTree();

	tree = new BinarySearchTree();
	tree.addElement(new KeyedInt(2));
	tree.addElement(new KeyedInt(1));
	tree.addElement(new KeyedInt(3));

	
	/*	tree.inOrder(); System.out.println();
	System.out.println("Removed " + 
			   tree.removeElement(new KeyedInt(2)));
	tree.inOrder(); System.out.println();
	System.out.println("Removed " + 
			   tree.removeElement(new KeyedInt(1)));
	tree.inOrder(); System.out.println();

	*/
	tree.showTree();

    }


}


class KeyedInt implements KeyedObject {
    Integer ivalue;

    public KeyedInt() {
	ivalue = new Integer(0);
    }
    public KeyedInt(int i) {
	ivalue = new Integer(i);
    }

    public Comparable key() {
	return ivalue;
    }
    public String toString() {
	return ivalue.toString();
    }
}
