/**Author: Sijie Yu
 * Course: CS-501 WS4
 * Description: The InputFile Class process all operations about the data
 */

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

public class InputFile {
	//initialize the file instance
	public File file = new File("PlanetInfo.txt");
	
	//create a arraylist to store all planet data
    List<planetData> planetList = new ArrayList<planetData>();
    
    //scanner
	Scanner theFile; 
	
    public void setData() throws IOException, FileNotFoundException{
    	theFile = new Scanner(file);
    	
    	//Scan the file
		while (theFile.hasNextLine()) {
			//skip the first two lines in file
			String lineOfText = theFile.nextLine();
		    String[] s = lineOfText.split(", ");
		    
		    //classify the movie by its genre
		    
			planetData planet = new planetData(s);
			planetList.add(planet);
		}
	}
}