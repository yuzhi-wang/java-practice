//Sijie Yu
//CS501 - WS4
//calculate and display the transaction amounts




import javax.swing.JOptionPane;
import java.util.Scanner;


public class Project1 {

	public static void main(String[] args) {
		//Enter User's name
		Scanner keyboard = new Scanner(System.in);
		String name;
		name = JOptionPane.showInputDialog("Welcome to the Delivery Calculator\n"
		                                  +"Enter your name");
		
		//Enter the subtotal
		double subtotal;
		String str1;
		str1 = JOptionPane.showInputDialog("Hello " + name + "\nEnter the subtotial Amount : $" );
		subtotal = Double.parseDouble(str1);
		
		
		//calculate the tips, DeliveryFee and Tax
		double tip1 = 0.15 * subtotal;
		tip1 = (double) Math.round(tip1 * 100) / 100;
		double tip2 = 0.20 * subtotal;
		tip2 = (double) Math.round(tip2 * 100) / 100;
		double tip3 = 0.25 * subtotal;
		tip3 = (double) Math.round(tip3 * 100) / 100;
		
		double DeliveryFee = 0.1 * subtotal;
		DeliveryFee = (double) Math.round(DeliveryFee * 100) / 100;
		double Tax = 0.065 * subtotal;
		Tax = (double) Math.round(Tax * 100) / 100;
		
		
		//Show the Tip
		double Tip;
		String str2;
		str2 = JOptionPane.showInputDialog("Suggested Tip Amounts: \n"
				                          +"\n15% = $" + tip1
				                          +"\n20% = $" + tip2
				                          +"\n25% = $" + tip3
				                          +"\n Enter the tip %:");
		
		Tip = Double.parseDouble(str2);
		
		
		//Calculate the TipAmount and Total
		double TipAmount = 0.0001 * Tip * subtotal;
		
		double Total = subtotal + Tax + DeliveryFee + Tax + TipAmount;
		
		
		//Display
		JOptionPane.showMessageDialog(null, 
				                      "Your Delivery Cost\n" + "\n"
		                              + String.format("%-15s %5.2f", "Subtotal = $", subtotal) + "\n"
		                              + String.format("%-15s %9.2f", "Tax = ", Tax) + "\n"
		                              + String.format("%-15s %5.2f", "Delivery Fee = ", DeliveryFee) + "\n"
		                              + String.format("%-15s %4.2f", "Tip amount = ", TipAmount)
		                              + "\n-----------------\n"
		                              + String.format("%-15s %4.2f", "Total Due = $", Total));
		
		

	}

}
