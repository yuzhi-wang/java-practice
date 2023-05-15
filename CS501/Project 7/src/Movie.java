/**Author: Sijie Yu
 * Course: CS-501 WS4
 * Description: The Movie Class manage the data
 */


//superclass for Movie
public class Movie {
	////all number from the data
	public String directorName;
	public String composerName;
	
	//default constructor
	public Movie() {
		
	}
	
	//overloaded constructor
	public Movie(String[] s) {
		this.directorName = s[0];
		this.composerName = s[1];
	}
	
	//mutator method, but not needed
    public void setData() {
    	
    }
    
    //accessor method, but not needed
    public void getData() {
    	
    }
}

//subclass for the Movie
class theMovie extends Movie{
	public String title;
	public String genre;
	public String year;
	public String rating;
	
	//default constructor
	public theMovie() {
		
	}
	
	//overloaded constructor
	public theMovie(String[] s1, String[] s2) {
		super(s1);
		this.title = s2[0];
		this.year = s2[1];
		this.genre = s2[2];
		this.rating = s2[3];
	}
}


