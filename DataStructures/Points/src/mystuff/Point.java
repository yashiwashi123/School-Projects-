package mystuff; 
/**
 * A point on the plane.  Intended as a simple example of classes
 * in Java.
 *
 * @version 1.2 of September 1999
 * @author Samuel A. Rebelsky, modified by SEA
 */
public class Point {

  // +--------+--------------------------------------------------
  // | Fields |
  // +--------+

  /** The x coordinate of the point (distance from the X axis).  */
  protected double xcoord;

  /** The y coordinate of the point (distance from the Y axis).  */
  protected double ycoord;


  // +--------------+--------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build the point (x,y).
   */
  public Point(double x, double y) {
    this.xcoord = x;
    this.ycoord = y;
  } 

  /**
   * Build the point (0,0).
   */
  public Point() {
    this.xcoord = 0;
    this.ycoord = 0;
  } 
  
  
  // +------------+----------------------------------------------
  // | Extractors |
  // +------------+
  
  /**
   * Get the X coordinate of a point.
   */
  public double getX() {
    return this.xcoord;
  } 

  /**
   * Get the Y coordinate of a point.
   */
  public double getY() {
    return this.ycoord;
  } 

  /**
   * Get the distance of a point from the origin.
   */
  public double distanceFromOrigin() {
    return Math.sqrt(this.xcoord*this.xcoord + 
                     this.ycoord*this.ycoord);
  } 


  // +-----------+-----------------------------------------------
  // | Modifiers |
  // +-----------+

  /**
   * Set the point to (x,y).
   */
  public void set(double x, double y) {
    this.xcoord = x;
    this.ycoord = y;
  } 
 
  /**
   * Set the point to (x,y).
   */
  public void setValue(double x, double y) {
    this.xcoord = x;
    this.ycoord = y;
  } 
 
  /**
   * Set the x coordinate of the point.
   */
  public void setX(double x) {
    this.xcoord = x;
  } 
  
  /**
   * Set the y coordinate of the point.
   */
  public void setY(double y) {
    this.ycoord = y;
  } 
  
  /**
   * Shift the point left by a particular amount.
   */
  public void shiftLeft(double amt) {
    this.xcoord = this.xcoord - amt;
  } 

  /**
   * Shift the point right by a particular amount.
   */
  public void shiftRight(double amt) {
    this.xcoord = this.xcoord + amt;
  } 

  /**
   * Shift the point up by a particular amount.
   */
  public void shiftUp(double amt) {
    this.ycoord = this.ycoord + amt;
  } 

  /**
   * Shift the point down by a particular amount.
   */
  public void shiftDown(double amt) {
    this.ycoord = this.ycoord - amt;
  } 
  public String toString(){
		return "Point: " + "(" + this.xcoord + "," + this.ycoord + ")";
	}
  public double Area(){
	  return 0.0;
  }

} // class Point