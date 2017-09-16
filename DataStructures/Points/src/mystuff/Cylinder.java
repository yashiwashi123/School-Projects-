package mystuff;

public class Cylinder extends Circle{
	protected double height;
	 
	protected Circle cir;
	
	
	
	
	
	public Cylinder(){
		
		height = 1.0;
		cir = new Circle(); 
				
	}
	public Cylinder(double x, double y, double r, double h){
		//cylinder just assigns values to the circle object and includes the height of the cylinder
		height = h;
		cir = new Circle(x, y, r);
		
	
				
	}
	public double Area(){
		return (2 * Math.PI * cir.radius * height) + (2 * Math.PI * (cir.radius*cir.radius));
		
	
	}
	public double Volume(){
		//the volume for a cylinder is (pi*r^2)*h which is just the area of a circle * height of cylinder 
		return cir.Area()*height; 
	}
	public String toString(){
		//this is code to test whether the proper values are being assigned to the cylinder
		return "Cylinder: " + this.height + cir.xcoord + cir.ycoord + cir.radius; 
	}
}