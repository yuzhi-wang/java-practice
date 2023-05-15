/**Author: Sijie Yu
 * Course: CS-501 WS4
 * Description: The InputFile Class process all operations about the data
 */
import java.io.*;
import java.util.*;

public class InputFile {
	//initialize the file instance
	public File file = new File("NamedFloridaHurricanes.txt");
	//Object array to store the data
	public stormData[] storm = new stormData[39];
	Scanner theFile;
	
	//ArrayList to store the most active years 
	public List<Integer> mostActiveYearList = new ArrayList<Integer>();
	//count the storm count and everyyear's max count
	int stormCounts ;
	int stormMax ;
	
	//count by every category from 1 to 5
	public int[] countForHurricanes = new int[5];
	public int counts = 0;
	
	//store every year and distinct year
	int[] countForYear = new int[23];
	List<Integer> distinctYear = new ArrayList<Integer>();
	
	//Default constructor
	public InputFile() {
		
	}
	
	//accessor method, but not needed
	public void getData() {
		
	}
	
	//overloaded constructor to set the data from the file
	//also a mutator method
	public void setData() throws IOException{
		theFile = new Scanner(file);
		int j = 0;
		while (theFile.hasNextLine()) {
			String line = theFile.nextLine();
			//delete all punctuation and add every element to a string array
			StringTokenizer st = new StringTokenizer(line, ":,/");
			String[] s = new String[5];
			int i = 0;
			while (st.hasMoreTokens()) {
				s[i] = st.nextToken();
				i++;
			}
			if (j < storm.length) {
				//add data to storm object array
				storm[j] = new stormData(s);
			}
			j++;
        }
    }
	
	//method to sort data by name in ascending order
	public stormData[] as_sortbyName(stormData[] storm) {
		//base case
		if (storm == null || storm.length == 0)
			return storm;
		
		//scan or traverse the data
		for (int i = 0; i < storm.length - 1; i++) {
			int min = i;
			//sort by every letter in ascending order
			for (int j = i + 1; j < storm.length; j++) {
				if (storm[j].name.charAt(0) == storm[min].name.charAt(0)) {
					if (storm[j].name.charAt(1) == storm[min].name.charAt(1)) {
						if (storm[j].name.charAt(2) ==  storm[min].name.charAt(2)) {
							if (storm[j].name.charAt(3) < storm[min].name.charAt(3)) {
								min = j;
							}
						}
						if (storm[j].name.charAt(2) <  storm[min].name.charAt(2)) {
							min = j;
						}
					}
					if (storm[j].name.charAt(1) < storm[min].name.charAt(1)) {
						min = j;
					}
				}
				if (storm[j].name.charAt(0) < storm[min].name.charAt(0))
					min = j;
			}
			swap(storm, i ,min);
		}
		return storm;
	}
	
	//sort data by name in descending order
	public stormData[] des_sortbyName(stormData[] storm) {
		if (storm == null || storm.length == 0)
			return storm;
		
		for (int i = 0; i < storm.length - 1; i++) {
			int max = i;
			for (int j = i + 1; j < storm.length; j++) {
				if (storm[j].name.charAt(0) == storm[max].name.charAt(0)) {
					if (storm[j].name.charAt(1) == storm[max].name.charAt(1)) {
						if (storm[j].name.charAt(2) ==  storm[max].name.charAt(2)) {
							if (storm[j].name.charAt(3) > storm[max].name.charAt(3)) {
								max = j;
							}
						}
						if (storm[j].name.charAt(2) >  storm[max].name.charAt(2)) {
							max = j;
						}
					}
					if (storm[j].name.charAt(1) > storm[max].name.charAt(1)) {
						max = j;
					}
				}
				if (storm[j].name.charAt(0) > storm[max].name.charAt(0))
					max = j;
			}
			swap(storm, i ,max);
		}
		return storm;
	}
	
	//sort data by category in descending order
	public stormData[] as_sortbyCategory(stormData[] storm) {
		//base case
		if (storm == null || storm.length == 0)
			return storm;
		
		for (int i = 0; i < storm.length - 1; i++) {
			int min = i;
			//at the same time sort the data in same category by name
			for (int j = i + 1; j < storm.length; j++) {
				if (storm[j].category == storm[min].category) {
					if (storm[j].name.charAt(0) == storm[min].name.charAt(0)) {
						if (storm[j].name.charAt(1) == storm[min].name.charAt(1)) {
							if (storm[j].name.charAt(2) ==  storm[min].name.charAt(2)) {
								if (storm[j].name.charAt(3) < storm[min].name.charAt(3)) {
									min = j;
								}
							}
							if (storm[j].name.charAt(2) <  storm[min].name.charAt(2)) {
								min = j;
							}
						}
						if (storm[j].name.charAt(1) < storm[min].name.charAt(1)) {
							min = j;
						}
					}
					if (storm[j].name.charAt(0) < storm[min].name.charAt(0))
						min = j;
				}
				if (storm[j].category < storm[min].category)
					min = j;
			}
			swap(storm, i, min);
		}
		return storm;
	}
	
	//sort the data by category in descending order
	public stormData[] des_sortbyCategory(stormData[] storm) {
		if (storm == null || storm.length == 0)
			return storm;
		
		for (int i = 0; i < storm.length - 1; i++) {
			int max = i;
			for (int j = i + 1; j < storm.length; j++) {
				if (storm[j].category == storm[max].category) {
					if (storm[j].name.charAt(0) == storm[max].name.charAt(0)) {
						if (storm[j].name.charAt(1) == storm[max].name.charAt(1)) {
							if (storm[j].name.charAt(2) ==  storm[max].name.charAt(2)) {
								if (storm[j].name.charAt(3) < storm[max].name.charAt(3)) {
									max = j;
								}
							}
							if (storm[j].name.charAt(2) <  storm[max].name.charAt(2)) {
								max = j;
							}
						}
						if (storm[j].name.charAt(1) < storm[max].name.charAt(1)) {
							max = j;
						}
					}
					if (storm[j].name.charAt(0) < storm[max].name.charAt(0))
						max = j;
				}
				if (storm[j].category > storm[max].category)
					max = j;
			}
			swap(storm, i, max);
		}
		return storm;
	}
		
	//sort the data by year in ascending order
	public stormData[] as_sortbyYear(stormData[] storm) {
		//base case
		if (storm == null || storm.length == 0)
			return storm;
		
		for (int i = 0; i < storm.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < storm.length; j++) {
				if (storm[j].year == storm[min].year) {
					if (storm[j].name.charAt(0) == storm[min].name.charAt(0)) {
						if (storm[j].name.charAt(1) == storm[min].name.charAt(1)) {
							if (storm[j].name.charAt(2) ==  storm[min].name.charAt(2)) {
								if (storm[j].name.charAt(3) < storm[min].name.charAt(3)) {
									min = j;
								}
							}
							if (storm[j].name.charAt(2) <  storm[min].name.charAt(2)) {
								min = j;
							}
						}
						if (storm[j].name.charAt(1) < storm[min].name.charAt(1)) {
							min = j;
						}
					}
					if (storm[j].name.charAt(0) < storm[min].name.charAt(0))
						min = j;
				}
					
				if (storm[j].year < storm[min].year)
					min = j;
			}
			swap(storm, i, min);
		}
		return storm;
	}

	
	//sort the data by year in descending order
	public stormData[] des_sortbyYear(stormData[] storm) {
		if (storm == null || storm.length == 0)
			return storm;
		
		for (int i = 0; i < storm.length - 1; i++) {
			int max = i;
			for (int j = i + 1; j < storm.length; j++) {
				if (storm[j].year == storm[max].year) {
					if (storm[j].name.charAt(0) == storm[max].name.charAt(0)) {
						if (storm[j].name.charAt(1) == storm[max].name.charAt(1)) {
							if (storm[j].name.charAt(2) ==  storm[max].name.charAt(2)) {
								if (storm[j].name.charAt(3) < storm[max].name.charAt(3)) {
									max = j;
								}
							}
							if (storm[j].name.charAt(2) <  storm[max].name.charAt(2)) {
								max = j;
							}
						}
						if (storm[j].name.charAt(1) < storm[max].name.charAt(1)) {
							max = j;
						}
					}
					if (storm[j].name.charAt(0) < storm[max].name.charAt(0))
						max = j;
				}
				if (storm[j].year > storm[max].year)
					max = j;
			}
			swap(storm, i, max);
		}
		return storm;
	}
	
	//sort by month in ascending order
	public stormData[] as_sortbyMonth(stormData[] storm) {
		if (storm == null || storm.length == 0)
			return storm;
		
		for (int i = 0; i < storm.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < storm.length; j++) {
				if (storm[j].month == storm[min].month) {
					if (storm[j].name.charAt(0) == storm[min].name.charAt(0)) {
						if (storm[j].name.charAt(1) == storm[min].name.charAt(1)) {
							if (storm[j].name.charAt(2) ==  storm[min].name.charAt(2)) {
								if (storm[j].name.charAt(3) < storm[min].name.charAt(3)) {
									min = j;
								}
							}
							if (storm[j].name.charAt(2) <  storm[min].name.charAt(2)) {
								min = j;
							}
						}
						if (storm[j].name.charAt(1) < storm[min].name.charAt(1)) {
							min = j;
						}
					}
					if (storm[j].name.charAt(0) < storm[min].name.charAt(0))
						min = j;
				}
					
				if (storm[j].month < storm[min].month)
					min = j;
			}
			swap(storm, i, min);
		}
		return storm;
	}
	
	//sort by month in descending order
	public stormData[] des_sortbyMonth(stormData[] storm) {
		if (storm == null || storm.length == 0)
			return storm;
		
		for (int i = 0; i < storm.length - 1; i++) {
			int max = i;
			for (int j = i + 1; j < storm.length; j++) {
				if (storm[j].month == storm[max].month) {
					if (storm[j].name.charAt(0) == storm[max].name.charAt(0)) {
						if (storm[j].name.charAt(1) == storm[max].name.charAt(1)) {
							if (storm[j].name.charAt(2) ==  storm[max].name.charAt(2)) {
								if (storm[j].name.charAt(3) < storm[max].name.charAt(3)) {
									max = j;
								}
							}
							if (storm[j].name.charAt(2) <  storm[max].name.charAt(2)) {
								max = j;
							}
						}
						if (storm[j].name.charAt(1) < storm[max].name.charAt(1)) {
							max = j;
						}
					}
					if (storm[j].name.charAt(0) < storm[max].name.charAt(0))
						max = j;
				}
				if (storm[j].month > storm[max].month)
					max = j;
			}
			swap(storm, i, max);
		}
		return storm;
	}
	
	//swap method
	private void swap(stormData[] storm, int left, int right) {
		stormData temp = new stormData();
		temp = storm[left];
		storm[left] = storm[right];
		storm[right] = temp;
	}
	
	//calculate average category
	public float averageCategory(stormData[] storm) {
		float sum = 0;
		float count = 39;
		//calculate the sum of all categories
		for (stormData s : storm) {
			sum += s.category;
		}
		float average = sum / count;
		
		return average;
	}
	
	
	//the most active year
	public void mostActiveYear(stormData[] storm) {
		//traverse data
		for(stormData i : storm) {
			stormCounts = 0;
			for(stormData j : storm) {
				if (i.year == j.year) {
					//count the same year
					stormCounts += 1;
				}
		    }
			if (stormCounts >= stormMax) {
				//update the max year count
				stormMax = stormCounts;
			}
	    }
		
		//traverse data again
		for(stormData i : storm) {
			stormCounts = 0;
			for(stormData j : storm) {
				if (i.year == j.year) {
					stormCounts += 1;
				}
		    }
			if (stormCounts == stormMax && !mostActiveYearList.contains(i.year)) {
				//get the final result
				mostActiveYearList.add(i.year);
			}
	    }
		//sort the list by year
		Collections.sort(mostActiveYearList);
    }
	
	//count by every category
	public void countByCategory(stormData[] storm) {
		for (stormData s : storm) {
			if (s.category == 1)
				countForHurricanes[0] += 1;
			if (s.category == 2)
				countForHurricanes[1] += 1;
			if (s.category == 3)
				countForHurricanes[2] += 1;
			if (s.category == 4)
				countForHurricanes[3] += 1;
			if (s.category == 5)
				countForHurricanes[4] += 1;
			counts += 1;
		}
	}
	
	//count the frequency of every year
	public void countByYear(stormData[] storm) {
		storm = as_sortbyYear(storm);
		for (stormData s : storm) {
			if (!distinctYear.contains(s.year)) {
				distinctYear.add(s.year);
			}
		}
		for (int i = 0; i < distinctYear.size(); i++) {
			for (stormData s : storm) {
				if (distinctYear.get(i).equals(s.year)) {
					countForYear[i] += 1;
				}
			}
		}
	}
	
	//close the file properly
	public void closeFile() {
		//close file
		theFile.close();
	}
}