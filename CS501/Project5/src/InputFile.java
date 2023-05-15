/**Author: Sijie Yu
 * Course: CS501-WS4
 * Description: InputFile Class open, read and close the file properly
 */

import java.io.*;
import java.util.*;

public class InputFile {
	//initialize a file object, like a mutator method
	private File file = new File("inPoem.txt");
	
	//the scanner, like a accessor methods
	Scanner theFile;
	
	//initialize an Analysis object
	Analysis a = new Analysis();
	
	//function to open and read the file
	public void openAndReadFile() throws IOException{
		//Title
		System.out.println("Poem Word Analysis");
		//scan the file
		theFile = new Scanner(file);
		System.out.println("Opening input file...\n");
		
		//set the words in file into an ArrayList
		a.setArrayList(theFile);
		
		//make a new list
		a.makeNewList();
		
		//calculate the frequency
		a.updateFrequency();
		
		//show the result
		a.showResults();
		
	}
	
	//Default constructor
	public InputFile() {
		
	}
	
	//a function to clsoe the file
	public void closeFile() {
		//close file
		theFile.close();
		
		//tell the user that file is closed
		System.out.println("\nEnd of results");
		
	}
	
	//default accessor methods, not needed
	public File getfile() {
		return file;
	}
	
	//default mutator method, noe needed
	public void setFile(){
		
	}
	
	
	
}
