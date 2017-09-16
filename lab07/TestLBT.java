
public class TestLBT {


    public static void main(String[] args) {
	
	LinkedBinaryTree tree = new LinkedBinaryTree();

	for (int i=0; i < 20; i++) {
	    tree.addElement(new Integer(i));
	}
	tree.preOrder();
    }

    System.out.println();
}
