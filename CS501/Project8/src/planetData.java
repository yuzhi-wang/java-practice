/**Author: Sijie Yu
 * Course: CS-501 WS4
 * Description: The planetData Class manage the data
 */

public class planetData {

	//all data needed from the input file
	public String name;
	public String radius;
	public String weightRatio;
	public String distanceFS;
	
	//overloaded constructor
	public planetData(String[] s) {
		this.name = s[0];
		this.radius = s[1];
		this.weightRatio = s[2];
		this.distanceFS = s[3];
	}
}
