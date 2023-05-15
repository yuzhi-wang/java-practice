public class Rectangle {
	//length and width are private variables 
	private static double length;
	private static double width;
	
	//Default constructor
	public Rectangle() {
		length = 0;
		width = 0;
	}
	
	//another constructor as a mutator method
	public Rectangle(double l, double w) {
		this.length = l;
		this.width = w;
	}
	
	//two accessor methods to get private variables from Rectangle class
	public double getLength() {
		return length;
	}
	
	public static double getWidth() {
		return width;
	}
	
	//write a function to calculate the dimension of rectangle
	public static double dimension() {
		return length * width;
	}
}
