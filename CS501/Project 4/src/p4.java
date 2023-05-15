/**Author:Sijie Yu
 * Course:CS-501 WS4
 * Description: write a program that prompt users to choose a shape and calculate its dimension
 */


import javax.swing.*;
import java.awt.event.*;

public class p4 {

	public static void main(String[] args){
		
		//set up the user interface
	    JFrame title = new JFrame("Shape Dimension Calculator");
		title.setSize(350, 200);
		title.setLocationRelativeTo(null);
		title.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//create a label to prompt the user to make a choice
		JLabel label = new JLabel();
		label.setText("Choose a type of shape you want to calculate.");
		
		//set a new panel
		JPanel panel = new JPanel();
		
		//create a button for the Circle shape
		final JButton C = new JButton("Circle");
		
		//set up the button ActionListener
		C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//set up a title for the Circle calculator interface
				JFrame title2 = new JFrame("Circle Dimension Calculator");
				title2.setSize(200, 200);
				title2.setLocationRelativeTo(null);
				
				//instantiate the circle with default constructor
				Circle cir = new Circle();
				
				//this loop is meant to give user another if they input invalid value
				while(true) {
				  try
				  {
					  //prompt the user to input and read the input
				      String r = JOptionPane.showInputDialog("Please enter the raduim(cm): ");	
				      double radius = Double.parseDouble(r);
				
				      //set data to the circle with specific constructor
				      cir = new Circle(radius);
				      
				      //call the static method to calculate the dimension
				      double D = cir.dimension();
				      
				      //set the output value to 2 decimal places
				      String str = String.format("%.2f", D);
				      double cirDimension = Double.parseDouble(str);
				
				      //show the output result
				      JOptionPane.showMessageDialog(null, "The dimension of the circle is " + cirDimension + " cm^2");
				      break;
				   }
				      //if user input any invalid values, remind him to input again
				      catch(NumberFormatException exception) {
				    	  //	   
				    	  JOptionPane.showMessageDialog(null, "Invalid input! Please try again!");	
					   
				   }
				}
			}
			
		});
		
		//the Rectangle and Triangle part is same as Circle
        final JButton R = new JButton("Rectangle");
		
		R.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame title3 = new JFrame("Rectangle Dimension Calculator");
				title3.setSize(200, 200);
				title3.setLocationRelativeTo(null);
				
				Rectangle rec = new Rectangle();
				
				while(true) {
					
				  try
				  {
					
				       String l = JOptionPane.showInputDialog("Please enter the length(cm): ");	
				       double length = Double.parseDouble(l);
				        
				       String w = JOptionPane.showInputDialog("Please enter the width(cm): ");	
				       double width = Double.parseDouble(w);
				       
				   
				       rec = new Rectangle(length, width);
				
				       double D = rec.dimension();
				       String str = String.format("%.2f", D);
				       double recDimension = Double.parseDouble(str);
				
				       JOptionPane.showMessageDialog(null, "The dimension of the rectangle is " + recDimension + " cm^2");
				       break;
				   }
				       catch(NumberFormatException exception) {
				    	   
				    	   JOptionPane.showMessageDialog(null, "Invalid input! Please try again!");	
					   
				   }
				}
			}
			
		});
		
        final JButton T = new JButton("Triangle");
		
		T.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame title3 = new JFrame("Triangle Dimension Calculator");
				title3.setSize(200, 200);
				title3.setLocationRelativeTo(null);
				
				Triangle tri = new Triangle();
				
				while(true) {
					
				  try
				  {
					
				       String b = JOptionPane.showInputDialog("Please enter the base(cm): ");	
				       double base = Double.parseDouble(b);
				        
				       String h = JOptionPane.showInputDialog("Please enter the height(cm): ");	
				       double height = Double.parseDouble(h);
				       
				   
				       tri = new Triangle(base, height);
				
				       double D = tri.dimension();
				       String str = String.format("%.2f", D);
				       double triDimension = Double.parseDouble(str);
				
				       JOptionPane.showMessageDialog(null, "The dimension of the triangle is " + triDimension + " cm^2");
				       break;
				   }
				       catch(NumberFormatException exception) {
				    	   
				    	   JOptionPane.showMessageDialog(null, "Invalid input! Please try again!");	
					   
				   }
				}
			}
			
		});
		
		//add the label and three buttons into the content
		panel.add(label);
		panel.add(C);
		panel.add(R);
		panel.add(T);
		title.setContentPane(panel);
		title.setVisible(true);
		
	
		}

	}


