package mystuff;
/**
 * Build a point and move it around.
 *
 * @version 1.1 of September 1998
 * @author Samuel A. Rebelsky, modified by SEA
 */
public class NewPointFun {
  /**
   * Build a point and move it around.
   */
  public static void main(String[] args) {

    // The point we'll be playing with.
    NewPoint pt = new NewPoint();

    // Print some basic information.
    System.out.println("(" + pt.getX() + "," + pt.getY() + ")");
    System.out.println("  distance from origin: " + 
                pt.distanceFromOrigin());

    // Move it right a little bit.
    System.out.println("Shifting right by 0.7");
    pt.shiftRight(0.7);

    // Print current information.
    System.out.println("(" + pt.getX() + "," + pt.getY() + ")");
    System.out.println("  distance from origin: " + 
                pt.distanceFromOrigin());

    // Move it up a little bit.
    System.out.println("Shifting up by 2.5");
    pt.shiftUp(2.5);

    // Print current information.
    System.out.println("(" + pt.getX() + "," + pt.getY() + ")");
    System.out.println("  distance from origin: " + 
                pt.distanceFromOrigin());

    // Move it left a little bit.
    System.out.println("Shifting left by 10.2");
    pt.shiftLeft(10.2);

    // Print current information.
    System.out.println("(" + pt.getX() + "," + pt.getY() + ")");
    System.out.println("  distance from origin: " + 
                pt.distanceFromOrigin());
  } 

} // class NewPointFun