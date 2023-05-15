/**Author: Sijie Yu
 * Course: CS501-WS4
 * Description:Analysis class add words from a file to an ArrayList,
 *             update the frequency of the words and
 *             discover if the word is a palindrome
 */

import java.util.*;

public class Analysis {
    //a private member to store the word read from the file
	private ArrayList<String> wordList;
	
	//a private member to store the unique word from wordList
	private ArrayList<String> newWordList = new ArrayList<String>();
	
	//a private number to store the frequency of each word in the newWordList
	private int[] count = new int[20];
	
	//Default constructor
	public Analysis() {
		
		
	}
	
	//mutator methods to an Analysis instance
	public void setArrayList(Scanner S) {
		wordList = new ArrayList<String>();
		while (S.hasNext()) {
			//discard all punctuation
			String word = S.next().replaceAll("\\p{Punct}","");
			
			//add every word in the file to the wordList
			wordList.add(word);
			
			//sort it by ascending order
			Collections.sort(wordList);
		}
	}
	
	//a function to make a new list
	public void makeNewList() {
		for (String word : wordList) {
			//remove all duplicated words
			if (!newWordList.contains(word)) {
				newWordList.add(word);
			}
		}
	}
	
	//count the frequency
	public void updateFrequency() {
		//compare the newWordList to the wordList
		for (int i = 0; i < newWordList.size(); i++) {
			for (int j = 0; j < wordList.size(); j++) {
				if (newWordList.get(i).equals(wordList.get(j))) {
					//count the frequency
					count[i] += 1;
				}
			}
		}
	}
	
	//a function to show the result
	public void showResults() {
		//print the title
		System.out.println("Word" + "      " + "Frenquency" + "      " + "Palindrome");
		System.out.println("————————————————————————————————————");
		int i = 0;
		//traverse the AaaryList
		for (String word : newWordList) {
			System.out.printf(" " + "%-15s", word);
			System.out.printf("%-15s", count[i]);
			System.out.printf("%-15s", isPalindrome(word));
			System.out.println();
			i++;
		}
	}
		
	//a function to decide if the word is Palindrome
	public boolean isPalindrome(String s) {
		//initialize a StreingBuffer and reverse it
		StringBuffer sb = new StringBuffer(s);
		sb.reverse();
		
		//compare a string to its reverse
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == sb.charAt(i)) {
				count++;
			}
		}
		if (count == s.length()) {
			return true;
		}
		return false;	
	}

	//accessor methods, but not needed
	public ArrayList<String> getArrayList(){
		return wordList;
	}
	
}
