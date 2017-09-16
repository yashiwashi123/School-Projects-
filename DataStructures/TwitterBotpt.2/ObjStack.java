/**

 Implements a stack for objects. Stack is implemented as linked elements.
 This class must implement all Stack methods in Stack.java

 @author:  ?
*/

public class ObjStack implements Stack {
    private Node top;
    private int Num;

    // Initialize the stack
    public ObjStack() {
	top = null;
	Num = 0;
    }

    public int size() {           // returns the current stack size
	return Num;
    }

    public boolean isEmpty() {    // Returns true iff the stack is empty
	return (Num == 0);
    }

    // Push a new object on the stack
    public void push(Object obj)
    {
	top = new Node(obj,top);
	Num++;
    }

  
    //
    // Return the top stack element
    //
    public Object top()
    {
	if (isEmpty()) {
	    throw new StackEmptyException("error in top");
	}
	return top.item;
    }


    //
    // Pop off the top stack element
    //
    public Object pop()
    {

	if (isEmpty()) {
	    throw new StackEmptyException("error in top");
	}
	Object tmp = top.item;
	Num--;
	top = top.next;
	return tmp;
    }

    private class Node {
	Object item;
	Node next;

	public Node(Object i, Node n) {
	    item = i;
	    next = n;
	}
    } // end class Node

} // end ObjStack class

