public class Triangle {
	//base and height are private variables
	private static double base;
	private static double height;
	
	//Default constructor
	public Triangle() {
		base = 0;
		height = 0;
	}
	
	//another constructor as a mutator method
	public Triangle(double b, double h){
		this.base = b;
		this.height = h; 
	}
	
	//two accessor methods to get private variables from Triangle class
	public static double getBase() {
		return base;
	}
	
	public static double getHeight() {
		return height;
	}
	
	//write a function to calculate the dimension of triangle
	public static double dimension() {
		return base * height / 2;
	}
}
