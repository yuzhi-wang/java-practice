public class Circle {
	//radius is private variable 
	private static double r;
	
	//PI is a static final variable
	public static final double PI = 3.14159;
	
	//Default constructor
	public Circle() {
		r = 0;
	}
	
	//another constructor as a mutator method
	public Circle(double r) {
		this.r = r;
	}
	
	//accessor method to get radius
	public static double getRadius(){
		return r;
	}
	
	//write a function to calculate the dimension of circle
	public static double dimension() {
		return PI * r * r;
	}
}
