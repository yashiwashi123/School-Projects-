/**
   Operations necessary for a Stack ADT.
   Operations: Size, isEmpty, top, push, pop

   An interface list services provided by classes that
   choose to implement the interface.

   @author ?
*/
public interface Stack {
    /**
       Number of elements in stack.
       @return number of elements in stack
    */
    public abstract int size();

    /**
       @return true if stack is empty
    */
    public abstract boolean isEmpty();

    /**
       View top element in stack without removing it.
       Throws StackEmptyException if stack is empty.
       @return top of stack
    */
    public abstract Object top();

    /**
       Push item onto stack
       @param item Object to be pushed onto top of stack
    */
    public abstract void push (Object item);


    /**
       Remove top element in stack.
       Throws StackEmptyException if stack is empty.
       @return top element of stack
    */
    public abstract Object pop();
}
