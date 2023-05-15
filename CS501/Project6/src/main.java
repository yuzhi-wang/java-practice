/**Author: Sijie Yu
 * Course: CS-501 WS4
 * Description: Read the file NamedFloridaHurricanes.txt 
 *              and display the result as the user prefer.
 */

import java.io.IOException;
public class main {

	public static void main(String[] args) throws IOException{
		//initialize the menu instance
		menu m = new menu();
		
		//call the driver method to run the program
		m.driver();
	}
}
