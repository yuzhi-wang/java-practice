/**Author: Sijie Yu
 * Course: CS501-WS4
 * Description: Main function to open, read and close the file
 */


import java.io.*;
import java.util.*;

public class main {
	public static void main(String[] args) throws IOException{
		//initialize an InputFile object
		InputFile f = new InputFile();
		
		//open and read the file
		f.openAndReadFile();
		
		//close the file
		f.closeFile();
	}
}
