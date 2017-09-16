package mystuff;

public class Circle extends Point{

	protected double radius; 
	
	protected double xcoord;
	protected double ycoord; 
	
	public Circle(){
	//initializes a circle at point 0,0 with a radius of 0
		 xcoord = 0;
		 ycoord = 0;
		 new Point(xcoord, ycoord);	 
		 radius = 0.0;
	}
	public Circle(double x, double y, double r){
		xcoord = x;
		ycoord = y;
		new Point(xcoord, ycoord);
		
		//if the user inputs a negative radius, it sets the radius to 0
		if ( r > 0.0){
			
			radius = r; 
		}
		else{
			radius = 0;
		}
	}
	public double Area(){
		//formula for the area of a circle is pi*r^2 
		return Math.PI * Math.pow(radius, 2.0);
	}
	public String toString(){
		
		return "Circle: " + "r= " + this.radius +" at " + "(" + this.xcoord+ "," + this.ycoord + ")" ;
	}
	
}
