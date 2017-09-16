/**
   Classes that implement this interface must provide some means
   for extracting a key of the java.lang.Comparable class.
   
   The Comparable interface requires an implementation of
   public int compareTo(Object o)
   
   Compares this object with the specified object for order. Returns a
   negative integer, zero, or a positive integer as this object is less
   than, equal to, or greater than the specified object.  
*/
public interface KeyedObject {

    public Comparable key();
}
