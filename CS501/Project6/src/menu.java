/**Author: Sijie Yu
 * Course: CS-501 WS4
 * Description: The menu Class manage the user interface
 */

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;


public class menu {
	//initialize the InputFile instance
	InputFile file = new InputFile();
	
	
	public void driver() throws IOException{
		//set the data
		file.setData();
		Scanner keyboard = new Scanner(System.in);
		//show the title and content
		String choice = JOptionPane.showInputDialog("Florida Named Hurricanes 1950 - 2022\n"
		                                           +"\n\n"
				                                   +"Press 1 to Sort by Storm Name\n"
		                                           +"Press 2 tp Sort by Storm Category\n"
				                                   +"Press 3 to Sort by Storm Year\n"
		                                           +"Press 4 to Sort by Storm Month\n"
				                                   +"Press 5 to Display the Average Storm Category\n"
		                                           +"Press 6 to Display the Most Active Hurricane Year\n"
				                                   +"Press 7 to Display the Total Number of Storms by Category\n"
		                                           +"Press 8 to Display the Total Number of Storms by Year\n"
		                                           +"Press 9 to Exit\n\n\n");
		//make operation by user's order
		if (choice.equals("1")) {
			String sortChoice = JOptionPane.showInputDialog("Florida Named Hurricanes 1950 - 2022\n"
					                                       +"\n"
					                                       +"Sort by Hurricane Name\n\n"
					                                       +"Press 1 for Ascending Order\n"
					                                       +"Press 2 for Descending Order\n\n");
			if (sortChoice.equals("1")) {
				file.storm = file.as_sortbyName(file.storm);
				StringBuilder text = new StringBuilder();
				text.append("Florida Named Hurricanes 1950 - 2022\n\n");
				text.append("Sort by Name in Ascending Order\n\n");
				text.append("Name   " + "          " + "Category   " + "           " + "Date" + "\n");
				for (stormData s : file.storm) {
					String message = String.format("%-20s%-10s%15s" + "\n", s.name, s.category, s.date);
					text.append(message.toString());
				}

				//display the result
				JFrame f = new JFrame();
				JTextArea area = new JTextArea(text.toString());
				area.setBounds(10, 20, 270, 700);
				area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				f.add(area);
				f.setSize(300, 750);
				f.setLayout(null);
				f.setVisible(true);
				
				//write data to a new text file
				try (FileOutputStream oS = new FileOutputStream(new File("SortByNameYu.txt"))){
					oS.write(text.toString().getBytes());
					oS.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
				//tell the user that data has been written into a new file
				JOptionPane.showMessageDialog(null, "The Results have been written into the output file!");
			} 
			
			if (sortChoice.equals("2")) {
				file.storm = file.des_sortbyName(file.storm);
				StringBuilder text = new StringBuilder();
				text.append("Florida Named Hurricanes 1950 - 2022\n\n");
				text.append("Sort by Name in Descending Order\n\n");
				text.append("Name   " + "          " + "Category   " + "           " + "Date" + "\n");
				for (stormData s : file.storm) {
					String message = String.format("%-20s%-10s%15s" + "\n", s.name, s.category, s.date);
					text.append(message.toString());
				}

				JFrame f = new JFrame();
				JTextArea area = new JTextArea(text.toString());
				area.setBounds(10, 20, 270, 700);
				area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				f.add(area);
				f.setSize(300, 750);
				f.setLayout(null);
				f.setVisible(true);
				
				try (FileOutputStream oS = new FileOutputStream(new File("SortByNameYu.txt"))){
					oS.write(text.toString().getBytes());
					oS.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
				JOptionPane.showMessageDialog(null, "The Results have been written into the output file!");
			} 
		}
		
		
		if (choice.equals("2")) {
			String sortChoice = JOptionPane.showInputDialog("Florida Named Hurricanes 1950 - 2022\n"
                                                           +"\n"
                                                           +"Sort by Hurricane Category\n\n"
                                                           +"Press 1 for Ascending Order\n"
                                                           +"Press 2 for Descending Order\n\n");
			if (sortChoice.equals("1")) {
				file.storm = file.as_sortbyCategory(file.storm);
				StringBuilder text = new StringBuilder();
				text.append("Florida Named Hurricanes 1950 - 2022\n\n");
				text.append("Sort by Category in Ascending Order\n\n");
				text.append("Name   " + "          " + "Category   " + "           " + "Date" + "\n");
				for (stormData s : file.storm) {
					String message = String.format("%-20s%-10s%15s" + "\n", s.name, s.category, s.date);
					text.append(message.toString());
				}

				JFrame f = new JFrame();
				JTextArea area = new JTextArea(text.toString());
				area.setBounds(10, 20, 270, 700);
				area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				f.add(area);
				f.setSize(300, 750);
				f.setLayout(null);
				f.setVisible(true);
				
				try (FileOutputStream oS = new FileOutputStream(new File("SortByCategoryYu.txt"))){
					oS.write(text.toString().getBytes());
					oS.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
				JOptionPane.showMessageDialog(null, "The Results have been written into the output file!");
			}
			
			if (sortChoice.equals("2")) {
				file.storm = file.des_sortbyCategory(file.storm);
				StringBuilder text = new StringBuilder();
				text.append("Florida Named Hurricanes 1950 - 2022\n\n");
				text.append("Sort by Category in Descending Order\n\n");
				text.append("Name   " + "          " + "Category   " + "           " + "Date" + "\n");
				for (stormData s : file.storm) {
					String message = String.format("%-20s%-10s%15s" + "\n", s.name, s.category, s.date);
					text.append(message.toString());
				}

				JFrame f = new JFrame();
				JTextArea area = new JTextArea(text.toString());
				area.setBounds(10, 20, 270, 700);
				area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				f.add(area);
				f.setSize(300, 750);
				f.setLayout(null);
				f.setVisible(true);
				
				try (FileOutputStream oS = new FileOutputStream(new File("SortByCategoryYu.txt"))){
					oS.write(text.toString().getBytes());
					oS.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
				JOptionPane.showMessageDialog(null, "The Results have been written into the output file!");
			}
		}
		
		if (choice.equals("3")) {
			String sortChoice = JOptionPane.showInputDialog("Florida Named Hurricanes 1950 - 2022\n"
                                                           +"\n"
                                                           +"Sort by Hurricane Year\n\n"
                                                           +"Press 1 for Ascending Order\n"
                                                           +"Press 2 for Descending Order\n\n");
			if (sortChoice.equals("1")) {
				file.storm = file.as_sortbyYear(file.storm);
				StringBuilder text = new StringBuilder();
				text.append("Florida Named Hurricanes 1950 - 2022\n\n");
				text.append("Sort by Year in Ascending Order\n\n");
				text.append("Name   " + "          " + "Category   " + "           " + "Date" + "\n");
				for (stormData s : file.storm) {
					String message = String.format("%-20s%-10s%15s" + "\n", s.name, s.category, s.date);
					text.append(message.toString());
				}

				JFrame f = new JFrame();
				JTextArea area = new JTextArea(text.toString());
				area.setBounds(10, 20, 270, 700);
				area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				f.add(area);
				f.setSize(300, 750);
				f.setLayout(null);
				f.setVisible(true);
				
				try (FileOutputStream oS = new FileOutputStream(new File("SortByYearYu.txt"))){
					oS.write(text.toString().getBytes());
					oS.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
				JOptionPane.showMessageDialog(null, "The Results have been written into the output file!");
			}
			
			if (sortChoice.equals("2")) {
				file.storm = file.des_sortbyYear(file.storm);
				StringBuilder text = new StringBuilder();
				text.append("Florida Named Hurricanes 1950 - 2022\n\n");
				text.append("Sort by Year in Descending Order\n\n");
				text.append("Name   " + "          " + "Category   " + "           " + "Date" + "\n");
				for (stormData s : file.storm) {
					String message = String.format("%-20s%-10s%15s" + "\n", s.name, s.category, s.date);
					text.append(message.toString());
				}

				JFrame f = new JFrame();
				JTextArea area = new JTextArea(text.toString());
				area.setBounds(10, 20, 270, 700);
				area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				f.add(area);
				f.setSize(300, 750);
				f.setLayout(null);
				f.setVisible(true);
				
				try (FileOutputStream oS = new FileOutputStream(new File("SortByCategoryYu.txt"))){
					oS.write(text.toString().getBytes());
					oS.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
				JOptionPane.showMessageDialog(null, "The Results have been written into the output file!");
			}
		}
		
		if (choice.equals("4")) {
			String sortChoice = JOptionPane.showInputDialog("Florida Named Hurricanes 1950 - 2022\n"
                                                           +"\n"
                                                           +"Sort by Hurricane Month\n\n"
                                                           +"Press 1 for Ascending Order\n"
                                                           +"Press 2 for Descending Order\n\n");
			if (sortChoice.equals("1")) {
				file.storm = file.as_sortbyMonth(file.storm);
				StringBuilder text = new StringBuilder();
				text.append("Florida Named Hurricanes 1950 - 2022\n\n");
				text.append("Sort by Month in Ascending Order\n\n");
				text.append("Name   " + "          " + "Category   " + "           " + "Date" + "\n");
				for (stormData s : file.storm) {
					String message = String.format("%-20s%-10s%15s" + "\n", s.name, s.category, s.date);
					text.append(message.toString());
				}

				JFrame f = new JFrame();
				JTextArea area = new JTextArea(text.toString());
				area.setBounds(10, 20, 270, 700);
				area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				f.add(area);
				f.setSize(300, 750);
				f.setLayout(null);
				f.setVisible(true);
				
				try (FileOutputStream oS = new FileOutputStream(new File("SortByMonthYu.txt"))){
					oS.write(text.toString().getBytes());
					oS.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
				JOptionPane.showMessageDialog(null, "The Results have been written into the output file!");
			}
			
			if (sortChoice.equals("2")) {
				file.storm = file.des_sortbyMonth(file.storm);
				StringBuilder text = new StringBuilder();
				text.append("Florida Named Hurricanes 1950 - 2022\n\n");
				text.append("Sort by Month in Descending Order\n\n");
				text.append("Name   " + "          " + "Category   " + "           " + "Date" + "\n");
				for (stormData s : file.storm) {
					String message = String.format("%-20s%-10s%15s" + "\n", s.name, s.category, s.date);
					text.append(message.toString());
				}

				JFrame f = new JFrame();
				JTextArea area = new JTextArea(text.toString());
				area.setBounds(10, 20, 270, 700);
				area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				f.add(area);
				f.setSize(300, 750);
				f.setLayout(null);
				f.setVisible(true);
				
				try (FileOutputStream oS = new FileOutputStream(new File("SortByMonthYu.txt"))){
					oS.write(text.toString().getBytes());
					oS.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
				JOptionPane.showMessageDialog(null, "The Results have been written into the output file!");
			}
		}
		
		if (choice.equals("5")) {
			float test = file.averageCategory(file.storm);
			JOptionPane.showMessageDialog(null, "Florida Named Hurricanes 1950 - 2022\n\n"
					                           +"Average Storm Category by Saffir-Simpson Scale\n\n"
					                           +"Average Storm Category is " + test);   
		}
		
		
		if (choice.equals("6")) {
			file.mostActiveYear(file.storm);
			JOptionPane.showMessageDialog(null, "Florida Named Hurricanes 1950 - 2022\n\n"
					                           +"Most Active Storm Year\n\n"
					                           +"Most actibe storm year is tied with " + file.mostActiveYearList.get(0) + " and " + file.mostActiveYearList.get(1) + " each having " + file.stormMax + " named storms");   
		}
		
		if (choice.equals("7")) {
			file.countByCategory(file.storm);
			JOptionPane.showMessageDialog(null, "Florida Named Hurricanes 1950 - 2022\n\n"
					                           +"Aggregate Totals by Category (Saffir-Simpson scale)\n\n"
					                           +"Total Number of Named Hurricanes = " + file.counts + "\n\n"
					                           +"Total category 5 hurricanes: " + file.countForHurricanes[4] +"\n"
					                           +"Total category 4 hurricanes: " + file.countForHurricanes[3] +"\n"
					                           +"Total category 3 hurricanes: " + file.countForHurricanes[2] +"\n"
					                           +"Total category 2 hurricanes: " + file.countForHurricanes[1] +"\n"
					                           +"Total category 1 hurricanes: " + file.countForHurricanes[0] +"\n");
		}
		
		if (choice.equals("8")) {
			file.countByYear(file.storm);
			StringBuilder text = new StringBuilder();
			text.append("Florida Named Hurricanes 1950 - 2022\n\n");
			text.append("Aggregate Totals by Year\n\n");
			text.append("Year" + "         " + "Number of Storms" + "\n");
			for (int i  = 0; i < file.distinctYear.size(); i++) {
				String message = String.format("%-20s%-15s" + "\n", file.distinctYear.get(i), file.countForYear[i]);
				text.append(message.toString());
			}
			JFrame f = new JFrame();
			JTextArea area = new JTextArea(text.toString());
			area.setBounds(10, 20, 270, 700);
			area.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			f.add(area);
			f.setSize(300, 750);
			f.setLayout(null);
			f.setVisible(true);
		}
		
        //exit the program as the user wishes
		if (choice.equals("9")) {
			System.exit(0);
		}
		
		//close the file at last
		file.closeFile();
	} 


}
