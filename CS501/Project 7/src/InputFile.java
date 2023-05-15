/**Author: Sijie Yu
 * Course: CS-501 WS4
 * Description: The InputFile Class process all operations about the data
 */

import java.io.*;
import java.util.*;


public class InputFile {
	//initialize the file instance
    public File file = new File("MovieListing.txt");
    //a string array to store director and composer's name
    String[] s1 = new String[2];
	Scanner theFile;
	theMovie mmovie;
	
	//ArrayList to store different genres of movies
	List<theMovie> SciFiList = new ArrayList<theMovie>();
	List<theMovie> adventureList = new ArrayList<theMovie>();
	List<theMovie> dramaList = new ArrayList<theMovie>();
	List<theMovie> warList = new ArrayList<theMovie>();
	List<theMovie> romanceList = new ArrayList<theMovie>();
	List<theMovie> thrillerList = new ArrayList<theMovie>();
	List<theMovie> fantasyList = new ArrayList<theMovie>();
	
	
    //Default constructor
	public InputFile() {
			
	}
		
	//accessor method, but not needed
	public void getData() {
			
	}
		
	//overloaded constructor to set the data from the file
	//also a mutator method
	//the first time to scan the file and read the director and composer's name
	public void setData1() throws IOException{
		//initialize the file instance
		theFile = new Scanner(file);
		int i = 0;
		
        //scan the file
		while (theFile.hasNextLine()) {
			String lineOfText = theFile.nextLine();
			if (lineOfText.length() > 17) {
				continue;	
			}
			if (i < 2) {
				s1[i] = lineOfText;
				i++;
			}
		}
		
		
	}
	
	//overloaded constructor to set the data from the file
	//also a mutator method
	//the second time to scan the file and read rest data 
	public void setData2() throws IOException{
		theFile = new Scanner(file);
		while (theFile.hasNextLine()) {
			//skip the first two lines in file
			String lineOfText = theFile.nextLine();
			if (lineOfText.length() < 17) {
				continue;	
			}
		    String[] s2 = lineOfText.split(", ");
		    
		    //classify the movie by its genre
		    if (s2[2].equals("Sci Fi")) {
				theMovie movie = new theMovie(s1, s2);
				SciFiList.add(movie);
			}
			if (s2[2].equals("Adventure")) {
				theMovie movie = new theMovie(s1, s2);
				adventureList.add(movie);
			}
			if (s2[2].equals("War")) {
				theMovie movie = new theMovie(s1, s2);
				warList.add(movie);
			}
			if (s2[2].equals("Drama")) {
				theMovie movie = new theMovie(s1, s2);
				dramaList.add(movie);
			}
			if (s2[2].equals("Romance")) {
				theMovie movie = new theMovie(s1, s2);
				romanceList.add(movie);
			}
			if (s2[2].equals("Thriller")) {
				theMovie movie = new theMovie(s1, s2);
				thrillerList.add(movie);
			}
			if (s2[2].equals("Fantasy")) {
				theMovie movie = new theMovie(s1, s2);
				fantasyList.add(movie);
			}

	    }
		
	}
	
	
	//method to sort the movie with same genre by its released year
	public List<theMovie> sortByYear(List<theMovie> list){
		//selection sort
		for (int i = 0; i < list.size() - 1; i++) {
			int min = i;
			//at the same time sort the data in same category by name
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j).year == list.get(min).year) {
					if (list.get(j).title.charAt(0) == list.get(min).title.charAt(0)) {
						if (list.get(j).title.charAt(1) == list.get(min).title.charAt(1)) {
							if (list.get(j).title.charAt(2) ==  list.get(min).title.charAt(2)) {
								if (list.get(j).title.charAt(3) < list.get(min).title.charAt(3)) {
									min = j;
								}
							}
							if (list.get(j).title.charAt(2) < list.get(min).title.charAt(2)) {
								min = j;
							}
						}
						if (list.get(j).title.charAt(1) < list.get(min).title.charAt(1)) {
							min = j;
						}
					}
					if (list.get(j).title.charAt(0) < list.get(min).title.charAt(0))
						min = j;
				}
				if (Integer.parseInt(list.get(j).year) < Integer.parseInt(list.get(min).year))
					min = j;
			}
			Collections.swap(list, i, min);
		}
		return list;
	}
	
	//close the file properly
	public void closeFile() {
		//close file
		theFile.close();
	}
}
		
	


