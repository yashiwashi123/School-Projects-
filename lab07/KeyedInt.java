
/**
   Keyed integers are simply Integers that support the
   key() method.
 */
public class KeyedInt implements KeyedObject {
    Integer ivalue; // the store integer value

    public KeyedInt() {
	ivalue = new Integer(0);
    }
    public KeyedInt(int i) {
	ivalue = new Integer(i);
    }

    // return the key
    public Comparable key() {
	return ivalue;
    }
    public String toString() {
	return ivalue.toString();
    }
}
