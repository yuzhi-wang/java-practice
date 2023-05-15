/**Author: Sijie Yu
 * Course: SSW-540A
 * Description: Encrypt the letters in the input file and output a desired result to the output file
 */

import java.io.*;
import java.util.*;

public class encryptionLetter {
	
	//variables
	private Scanner inF;
	private PrintWriter outF;
	
	//constructor
	public encryptionLetter(Scanner iF, PrintWriter oF) {
		inF = iF;        //input file
		outF = oF;       //output file
	}
	
	//build a function to execute the encryption
	public void start() {
		while (inF.hasNext()) {
			String str = inF.nextLine();
			str = convert(str);
			write(str);
		}
	}
	
	//the process of encryption
	private static String convert(String str) {
		char[] array = str.toCharArray();
		for(int i = 0; i < array.length; i++) {
			char ch = array[i];
			if (ch <= 'z' && ch >= 'a') {
				int offset = (ch - 'a' + 3) % 26;
				ch = (char) ('a' + offset);
				array[i] = (char) (ch - 32);
			}
			if (ch <= 'Z' && ch >= 'A') {
				int offset = (ch - 'A' + 3) % 26;
				ch = (char) ('A' + offset);
				array[i] = (char) (ch + 32);
			}
		}
		return new String(array);
	}
	
	//write the new data to the outfile
	public void write(String str) {
		char chr;
		for (int i = 0; i < str.length(); i ++) {
			chr = str.charAt(i);
			outF.print(chr);
		}
	}
	
	//when the encryption end, close the file
	public static void closeFile(Scanner scan, Scanner in, PrintWriter out) throws IOException{
		scan.close();
		in.close();
		out.close();
	}
	
	
	public static void main(String[] args) throws IOException {
		//variables
		String inFileName = "Oct1.txt";
		String outFileName = "encryptedOct1.txt";
		
		Scanner scan = new Scanner(System.in);     //instantiate Scanner object
		
		//open files and create object streams to read from and write to
		FileInputStream in = new FileInputStream(inFileName);
		Scanner inReader = new Scanner(in);
		
		FileOutputStream out = new FileOutputStream(outFileName);
		PrintWriter outWriter = new PrintWriter(out);
		
		//print the program title
		System.out.println("Encryption Level 1");
		
		//create an instance
		encryptionLetter a = new encryptionLetter(inReader, outWriter);
		System.out.println("Openning input file...");
		//execute the encryption
		a.start();
		
		System.out.println("Encrypting...");
		
		//close the file
		closeFile(scan, inReader, outWriter);
		
		//The end
		System.out.println("Encryption complete");
        }
}


