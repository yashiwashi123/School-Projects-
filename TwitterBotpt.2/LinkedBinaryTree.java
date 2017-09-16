/**
   Implementation of binary tree interface.
   Elements are inserted randomly.
   
 */

public class LinkedBinaryTree implements BinaryTree,Visitable {
    protected BTNode root; // root of the tree

    public LinkedBinaryTree() {
	root = null;
    }

    public LinkedBinaryTree(Object o) {
	root = new BTNode(o,null,null);
    }

    public boolean isEmpty() {
	return root == null;
    }

    public Object root() {
	if (root == null) return null;
	else return root.element;
    }

    /**
       Preorder traversal.
    */
    public void preOrder() {
	preOrder(root);
    }

    private void preOrder(BTNode t) {
	if (t == null) return;
	visit(t.element);
	preOrder(t.left);
	preOrder(t.right);
    }

    /**
       Inorder traversal.
    */
    public void inOrder() {
	inOrder(root);
    }

    // recursive inorder traversal
    private void inOrderRec(BTNode t) {
	if (t == null) return;
	inOrder(t.left);
	visit(t.element);
	inOrder(t.right);
    }

    /**
       Non-recursive traversal using a stack.
    */
    private void inOrder(BTNode t) {
	if (t == null) return;
	Stack s = new ObjStack();
	BTNode curr = t;

	while (true) {
	    if (curr != null) {
		s.push(curr);
		curr = curr.left;
	    }
	    else if (!s.isEmpty()) {
		curr = (BTNode) (s.pop());
		visit(curr.element);
		curr = curr.right;
	    }
	    else
		break;
	}
    }



    /**
       Postorder traversal.
    */
    public void postOrder() {
	postOrder(root);
    }

   private void postOrder(BTNode t) {
	if (t == null) return;
	postOrder(t.left);
	postOrder(t.right);
	visit(t.element);
    }
    /**
       Add an element to the tree into a random location.
    */
    public void addElement(Object o) {
	if (root.element == null) root.element = o;
	else addElement(root,o);
    }


    /**
       Perform random insertion of object into tree.  This 
       is silly.
    */
    private void addElement(BTNode t, Object o) {
	if (t.left == null) {
	    if (t.right == null) { // both null
		if (Math.random() < 0.5) t.left = new BTNode(o,null,null);
		else t.right = new BTNode(o,null,null);
	    }
	    else {
		t.left = new BTNode(o,null,null);
	    }
	}
	else if (t.right == null) {
	    t.right = new BTNode(o,null,null);
	}
	else
	    if (Math.random() < 0.5) addElement(t.left,o);
	    else addElement(t.right,o);
    }

    public void visit(Object o) {
	System.out.print(o + " ");
    }



}

