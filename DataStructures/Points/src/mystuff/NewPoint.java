package mystuff;
/**
 * A point on the plane.  Intended as a simple example of building
 * classes based on other classes.
 *
 * @version 1.2 of September 1999
 * @author Samuel A. Rebelsky, modified by SEA
 */
public class NewPoint {
  // +--------+--------------------------------------------------
  // | Fields |
  // +--------+

  /** The point that this point is based on.  */
  protected Point base;


  // +--------------+--------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build the point (x,y).
   */
  public NewPoint(double x, double y) {
    base = new Point(x,y);
  } 

  /**
   * Build the point (0,0).
   */
  public NewPoint() {
    base = new Point(0, 0);
  } 
  
  
  // +------------+----------------------------------------------
  // | Extractors |
  // +------------+
  
  /**
   * Get the X coordinate of a point.
   */
  public double getX() {
    return base.getX();
  } 

  /**
   * Get the Y coordinate of a point.
   */
  public double getY() {
    return base.getY();
  } 

  /**
   * Get the distance of a point from the origin.
   */
  public double distanceFromOrigin() {
    return base.distanceFromOrigin();
  } 


  // +-----------+-----------------------------------------------
  // | Modifiers |
  // +-----------+

  /**
   * Shift the point left by a particular amount.
   */
  public void shiftLeft(double amt) {
    base.shiftLeft(amt);
  } 

  /**
   * Shift the point right by a particular amount.
   */
  public void shiftRight(double amt) {
    base.shiftRight(amt);
  } 

  /**
   * Shift the point up by a particular amount.
   */
  public void shiftUp(double amt) {
    base.shiftUp(amt);
  } 

  /**
   * Shift the point down by a particular amount.
   */
  public void shiftDown(double amt) {
    base.shiftLeft(amt);
  } 

} // class NewPoint