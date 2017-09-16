package mystuff;

public class ExtendedPoint extends Point {

	public ExtendedPoint (double x, double y) {
		setValue(x,y);
	}
	public ExtendedPoint(){
		setValue(1,1);
	}
	public String toString(){
		return "Point: " + "(" + this.xcoord + "," + this.ycoord + ")";
	}
		
}

