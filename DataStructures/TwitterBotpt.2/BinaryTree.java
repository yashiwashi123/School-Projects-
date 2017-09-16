/**
   ADT for Binary Trees.  

   How will we determine what visit() method is applied during
   traversals?  Users will want to do different things for each
   traversal, so visit() needs to be a parameter that the user
   selects.
 */

public interface BinaryTree {
    public boolean isEmpty();
    public Object root();

    public void preOrder();
    public void inOrder();
    public void postOrder();

    public void addElement(Object o); // insert object into tree
}
