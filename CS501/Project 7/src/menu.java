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
	
	public void driver() throws IOException {
		//set data
		file.setData1();
		file.setData2();
		
		//show the title and content
		String choice = JOptionPane.showInputDialog("Director/Composer Movies" +"\n\n\n"
		                                           +"Director:  " + file.SciFiList.get(0).directorName + "\n"
		                                           +"Composer:  " + file.SciFiList.get(0).composerName + "\n\n\n"
		                                           +"Which genre would you like:" + "\n\n\n"
		                                           +"1. Adventure\n"
		                                           +"2. Drama\n"
		                                           +"3. Fantasy\n"
		                                           +"4. Romance\n"
		                                           +"5. Sci Fi\n"
		                                           +"6. Thriller\n"
		                                           +"7. War"
		                                           +"\n\n\n"  
		                                           +"Your choice: ");
		
		//make operation by user's order
		if (choice.equals("1")) {
			file.adventureList = file.sortByYear(file.adventureList);
			StringBuilder text = new StringBuilder();
			text.append("Director:  " + file.adventureList.get(0).directorName + "\t\t\t\t\t\t\t\t" +"\n");
			text.append("Composeror:  " + file.adventureList.get(0).composerName + "\t\t\t\t\t\t\t\t" +"\n\n\n");
			text.append("Genre: " + file.adventureList.get(0).genre + "\t\t\t\t\t\t\t\t\t\t\t" +"\n\n\n");
			text.append("Movie Title   " + "                        " + "Year   " + "         " + "Rating" + "\n");
			for (theMovie m : file.adventureList) {
				String message = String.format("%-20s%20s%15s"+ "\n", m.title, m.year, m.rating);
				text.append(message.toString());
			}

			//display the result
			JFrame f = new JFrame();
			JTextArea area = new JTextArea(text.toString());
			area.setBounds(10, 20, 450, 700);
			area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			f.add(area);
			f.setSize(530, 750);
			f.setLayout(null);
			f.setVisible(true);
		}
		
		if (choice.equals("2")) {
			file.dramaList = file.sortByYear(file.dramaList);
			StringBuilder text = new StringBuilder();
			text.append("Director:  " + file.dramaList.get(0).directorName + "\t\t\t\t\t\t\t\t" +"\n");
			text.append("Composeror:  " + file.dramaList.get(0).composerName + "\t\t\t\t\t\t\t\t" +"\n\n\n");
			text.append("Genre: " + file.dramaList.get(0).genre + "\t\t\t\t\t\t\t\t\t\t\t" +"\n\n\n");
			text.append("Movie Title   " + "                        " + "Year   " + "         " + "Rating" + "\n");
			for (theMovie m : file.dramaList) {
				String message = String.format("%-20s%20s%15s"+ "\n", m.title, m.year, m.rating);
				text.append(message.toString());
			}

			//display the result
			JFrame f = new JFrame();
			JTextArea area = new JTextArea(text.toString());
			area.setBounds(10, 20, 450, 700);
			area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			f.add(area);
			f.setSize(530, 750);
			f.setLayout(null);
			f.setVisible(true);
		}
		
		if (choice.equals("3")) {
			file.fantasyList = file.sortByYear(file.fantasyList);
			StringBuilder text = new StringBuilder();
			text.append("Director:  " + file.fantasyList.get(0).directorName + "\t\t\t\t\t\t\t\t" +"\n");
			text.append("Composeror:  " + file.fantasyList.get(0).composerName + "\t\t\t\t\t\t\t\t" +"\n\n\n");
			text.append("Genre: " + file.fantasyList.get(0).genre + "\t\t\t\t\t\t\t\t\t\t\t" +"\n\n\n");
			text.append("Movie Title   " + "                        " + "Year   " + "         " + "Rating" + "\n");
			for (theMovie m : file.fantasyList) {
				String message = String.format("%-20s%20s%15s"+ "\n", m.title, m.year, m.rating);
				text.append(message.toString());
			}

			//display the result
			JFrame f = new JFrame();
			JTextArea area = new JTextArea(text.toString());
			area.setBounds(10, 20, 450, 700);
			area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			f.add(area);
			f.setSize(530, 750);
			f.setLayout(null);
			f.setVisible(true);
		}
		
		if (choice.equals("4")) {
			file.romanceList = file.sortByYear(file.romanceList);
			StringBuilder text = new StringBuilder();
			text.append("Director:  " + file.romanceList.get(0).directorName + "\t\t\t\t\t\t\t\t" +"\n");
			text.append("Composeror:  " + file.romanceList.get(0).composerName + "\t\t\t\t\t\t\t\t" +"\n\n\n");
			text.append("Genre: " + file.romanceList.get(0).genre + "\t\t\t\t\t\t\t\t\t\t\t" +"\n\n\n");
			text.append("Movie Title   " + "                        " + "Year   " + "         " + "Rating" + "\n");
			for (theMovie m : file.romanceList) {
				String message = String.format("%-20s%20s%15s"+ "\n", m.title, m.year, m.rating);
				text.append(message.toString());
			}

			//display the result
			JFrame f = new JFrame();
			JTextArea area = new JTextArea(text.toString());
			area.setBounds(10, 20, 450, 700);
			area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			f.add(area);
			f.setSize(530, 750);
			f.setLayout(null);
			f.setVisible(true);
		}
		
		if (choice.equals("5")) {
			file.SciFiList = file.sortByYear(file.SciFiList);
			StringBuilder text = new StringBuilder();
			text.append("Director:  " + file.SciFiList.get(0).directorName + "\t\t\t\t\t\t\t\t" +"\n");
			text.append("Composeror:  " + file.SciFiList.get(0).composerName + "\t\t\t\t\t\t\t\t" +"\n\n\n");
			text.append("Genre: " + file.SciFiList.get(0).genre + "\t\t\t\t\t\t\t\t\t\t\t" +"\n\n\n");
			text.append("Movie Title   " + "                        " + "Year   " + "         " + "Rating" + "\n");
			for (theMovie m : file.SciFiList) {
				String message = String.format("%-20s%20s%15s"+ "\n", m.title, m.year, m.rating);
				text.append(message.toString());
			}

			//display the result
			JFrame f = new JFrame();
			JTextArea area = new JTextArea(text.toString());
			area.setBounds(10, 20, 450, 700);
			area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			f.add(area);
			f.setSize(530, 750);
			f.setLayout(null);
			f.setVisible(true);
		}
		
		if (choice.equals("6")) {
			file.thrillerList = file.sortByYear(file.thrillerList);
			StringBuilder text = new StringBuilder();
			text.append("Director:  " + file.thrillerList.get(0).directorName + "\t\t\t\t\t\t\t\t" +"\n");
			text.append("Composeror:  " + file.thrillerList.get(0).composerName + "\t\t\t\t\t\t\t\t" +"\n\n\n");
			text.append("Genre: " + file.thrillerList.get(0).genre + "\t\t\t\t\t\t\t\t\t\t\t" +"\n\n\n");
			text.append("Movie Title   " + "                        " + "Year   " + "         " + "Rating" + "\n");
			for (theMovie m : file.thrillerList) {
				String message = String.format("%-20s%20s%15s"+ "\n", m.title, m.year, m.rating);
				text.append(message.toString());
			}

			//display the result
			JFrame f = new JFrame();
			JTextArea area = new JTextArea(text.toString());
			area.setBounds(10, 20, 450, 700);
			area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			f.add(area);
			f.setSize(530, 750);
			f.setLayout(null);
			f.setVisible(true);
		}
		
		if (choice.equals("7")) {
			file.warList = file.sortByYear(file.warList);
			StringBuilder text = new StringBuilder();
			text.append("Director:  " + file.warList.get(0).directorName + "\t\t\t\t\t\t\t\t" +"\n");
			text.append("Composeror:  " + file.warList.get(0).composerName + "\t\t\t\t\t\t\t\t" +"\n\n\n");
			text.append("Genre: " + file.warList.get(0).genre + "\t\t\t\t\t\t\t\t\t\t\t" +"\n\n\n");
			text.append("Movie Title   " + "                        " + "Year   " + "         " + "Rating" + "\n");
			for (theMovie m : file.warList) {
				String message = String.format("%-20s%20s%15s"+ "\n", m.title, m.year, m.rating);
				text.append(message.toString());
			}

			//display the result
			JFrame f = new JFrame();
			JTextArea area = new JTextArea(text.toString());
			area.setBounds(10, 20, 450, 700);
			area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			f.add(area);
			f.setSize(530, 750);
			f.setLayout(null);
			f.setVisible(true);
		}
		
		file.closeFile();
		
	}

}
