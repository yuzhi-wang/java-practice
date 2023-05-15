/**Author: Sijie Yu
 * Course: CS-501 WS4
 * Description: The stormData Class manage the data
 */

public class stormData {
	//all number from the data
	public String name;
	public String date;
	public int category;
	public int day;
	public int month;
	public int year;
	
	//default constructor
    public stormData() {
		
	}
    
    //mutator method, but not needed
    public void setData() {
    	
    }
    
    //accessor method, but not needed
    public void getData() {
    	
    }
	
	//overloaded constructor
	public stormData(String[] s) {
		this.name = s[0];
		this.category = Integer.parseInt(s[1]);
		this.month = Integer.parseInt(s[2]);
		this.day = Integer.parseInt(s[3]);
		this.year = Integer.parseInt(s[4]);
		this.date = s[2] + "/" + s[3] + "/" + s[4];
	}

	
}
