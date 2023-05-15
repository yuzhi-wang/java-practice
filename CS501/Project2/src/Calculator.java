/**Author:Sijie Yu
 * Class:CS501-WS4
 * Description:Build a calculator
**/

import java.util.*;

public class Calculator {
	public static void main(String[] args) {
		//create Scanner object
		Scanner scnr = new Scanner(System.in);
		
		//print the title
		System.out.println("The Calculator Program\n");
		
		//prompt the user for input
		System.out.println("\nEnter the first number: \n");
		double num1 = scnr.nextDouble();
		System.out.println("\nEnter the second number: \n");
		double num2 = scnr.nextDouble();
		
		//create a Calculator object with a default constructor
		Calculator Cal = new Calculator();
		
		//print the initial value
		System.out.println("\n");
		System.out.println(Cal.getValue());
		
		//call add methods and print the result
		Cal.add(num1);
		System.out.println(Cal.getValue());
		
		//call multiply methods and print the result
		Cal.multiply(3);
		System.out.println(Cal.getValue());
		
		////call subtract methods and print the result
		Cal.subtract(num2);
		System.out.println(Cal.getValue());
		
		////call divide methods and print the result
		Cal.divide(2);
		System.out.println(Cal.getValue());
		
		//call clear methods and print the result
		Cal.clear();
		System.out.println(Cal.getValue());
		
		//tell the user that the program ends
		System.out.println("\nEnd of results");

	}

	
	//create one private member field called value
	private double value;

	//constructor
	public Calculator() {
		value = 0.0;
	}
	
	//add methods
	public void add(double val) {
		value = value + val;
	}
	
	//subtract methods
	public void subtract(double val) {
		value = value - val;;
	}
	
	//multiply methods
	public void multiply(double val) {
		value = value * val;
	}
	
	//divide methods
	public void divide(double val) {
		value = value / val;
	}
	
	//clear the value
	public void clear() {
		value = 0.0;
	}
	
	//get the value
	public double getValue() {
		return value;
	}

	
	
}
