package mystuff; 
/* 
 PART 1:
 1. 
 By changing the line	
Point pt = new Point(2,3);
to:	
Point pt = new Point();
we	are	initializing	the	Point	pt	to	(0,0)	instead	of	(2,3).	First	we	get	the	initial	
coordinates	printed	giving us (0.0,	0.0) in the	console. We also get the distance from the origin(0,0) of the point: 0. 
This is calculated using the distanceFromOrigin method in the Point class. Then	the	code shifts	Point	pt	
to	the	right	by	calling	on	the	shiftRight(double)	method	in	the	Point	class	by	.7,	then	
prints	the	coordinates	giving	us	(0.7,	0.0). We also calculate the distance from the origin of the new coordinantes which equals 0.7. Then,	using shiftUp(double) also found in	
the	Point	class,	it	shifts	the	point	up	by	2.5	and	prints	the	current	information	giving	
us	(.07,	2.5)	in	the	console.	Directly	after	this,	we	get	the	result	of	the	method		
distanceFromOrigin()	which	calculates	the	distance	of	a point	from	the	origin	(0,0).	
This	result	Is	2.596150997149434	which	is	printed	in	the	console.	After,	using	the	
shiftLeft(double) method in	the	Point class, we shift the point	left by 10.2. The we	
print	the	point after it	has	been shifted: (-9.5,	2.5). Finally, we calculate the distance	
from	the	origin again and print	it onto	the	console. This distance form the origin is	
now	9.82344135219425.


2. NewPointFun and Point fun have the print the exact same values because the class NewPoint uses the constructer Point()
from the Point class. In NewPoint, instead of using "this"(which is used in Point) it uses base which is a reference to a Point
from the Point Class. 

3. When the constructor in the Point class Point() changes the values of int x and int y to 1 instead of 0, that means that 
whenever the constructor Point() is called, it creates a Point object at the coordinates (1.0,1.0) instead of (0.0, 0.0) 
This changes the values printed by the class NewPointFun. Now, since the initial value of the NewPoint Object in NewPointFun 
changed to (1.0,1.0) instead of (0.0, 0.0), the first thing printed is (1.0, 1.0) which has a distance from the origin of 1.4142.
Then, since the code in NewPointFun is still the same, the initial NewPoint gets shifted right by .7, just as it did when the constructor
Point() gave a coordinate of (0,0) instead of (1,1). NewPointFun prints the coordinate  (1.7, 1.0) which has a distance from the
origin of 1.9723. the NewPoint object in NewPointFun gets shifted up by 2.5 which NewPointFun then prints giving (1.7,3.5) which 
has a distance of 3.8910 from the origin. Lastly, NewPointFun shifts NewPoint left by 10.2. NewPointFun prints (-8.5, 3.5) which 
has a distance of 9.19238 from the origin. 

4.When you update the default constructor for NewPoint : .
   
  public NewPoint() {
    base = new Point();
    to: 
    
  public NewPoint() {
    base = new Point(0, 0);
it changed the output of NewPointFun to have the same output from the first question. This is because whenever NewPoint() is 
called, it creates a NewPoint object at the coordinates of (0,0) not matter what coordinates the default Point constructor is
set to. 

PART 2:
1. Done
2. Done
3. The output gave the same results that it would have gotten if it used the Point() constructor which means that the constructor
of the Point class was used. 
4. Since there hasn't been a default constructor in ExtendedPoint, PointFun cannot create an ExtendedPoint object without a 
constructor
5. When you create a default constructor for ExtendedPoint and use setValue() to set the coordinate to (1,1), the code works 
because now PointFun has a constructor to call from ExtendedPoint.
6. (4.0,1.0)
  distance from origin: 4.123105625617661
Shifting right by 0.7
(4.7,1.0)
  distance from origin: 4.805205510693586
Shifting up by 2.5
(4.7,3.5)
  distance from origin: 5.860034129593445
Shifting left by 10.2
(-5.499999999999999,3.5)
  distance from origin: 6.519202405202647

PART 3: 
1. My results are what I expected because PointFun printed out the coordinates just at it normally would. 
In other words my code worked! 
2. Done
3. The latter type of access is preffered(using protected fields of a class) when you want subclasses of a class to be 
able to access information form the superclass, but you still don't want users to have access to it. 

PART 4: 
1. Done
2.


*/
public class Test{
	
	
	public static void main(String args[]){
		//creates a circle object
		Circle cir = new Circle(1.0,2.0,3.0);
		System.out.println(cir.toString());
		//tests circle Area method
		System.out.println(cir.Area());
		//creates circle object with negative radius
		cir = new Circle(1.0,2.0, -3.0);
		//tests to see if the Circle class sets negative radii to 0
		System.out.println(cir.toString());
		//new cylinder object
		Cylinder cyl = new Cylinder(2.0,1.0,2.5,2.3);
		//makes sure all the values are porperly assigned 
		System.out.println(cyl.toString());
		//tests to see if cylinder's Area method works
		System.out.println(cyl.Area());
		// test to see if cylinder's Volume method works
		System.out.println(cyl.Volume());
		
		cir = new Circle(1.0, 2.0, 3.0);
		Point pt = new Point(1,1);
		//creates an array
		Point[] arraytest = new Point[3]; 
		arraytest[0] = pt;
		arraytest[1] = cir;
		arraytest[2] = cyl;
		
		for(int i = 0; i <3; i++){
			System.out.println(arraytest[i].Area());
		}
		
		
	
}
	
}
