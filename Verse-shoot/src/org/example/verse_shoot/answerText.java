package org.example.verse_shoot;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.example.verse_shoot.textObj;

public class answerText {
	public textObj[] textStrings;// The array of text containing the verse.
	public int iterator = 0;		// Earliest unfilled blank.
	public int[] filledStrings; // Ordered list. Index of filled string. Draw should use to determine what strings answered/filled in.
	
	
	
	public answerText(String ref,String verse ){	// Constructor
		populateTextObj(ref,verse);
		randomizeBlanks();
	}

	// Fill the textObj textStrings array with our verse
	public boolean populateTextObj(String ref, String verse) {	
		// Split the full verse into temp, iterate temp and put into textObjs.
		String[] temp;
		temp = verse.split(" ");
		textStrings[0].set(ref);	//Set the reference as the first word.
		for(int i = 0; i<temp.length;i++){
			textStrings[i+1].set(temp[i]); //i+1 to dodge the ref word.
		}		
		return true;
	}
	
	//Fill the word and move iterator to next unfilled word.
	//Return iterator position
	public int fillWord(){
		List a = Arrays.asList(filledStrings);
		a.add(iterator);
		return nextWord();
	}
	
	//Move the iterator to the next unfilled word
	//Return new iterator position
	public int nextWord(){
		while(Arrays.asList(filledStrings).contains(iterator))	// Can be made more efficient if changed to use list iterator.
		{
			iterator++;
		}		
		return iterator;
	}
	
	//Randomly select filled words. (fill half of the words)
	private void randomizeBlanks(){
		int numToFill = (textStrings.length/2);	// Half of the words
		for(int i = 0; i < numToFill; i++)		// Iterate each blank and fill it with a randomly selected index that does not already exist in filled strings
		{
			Random rand = new Random(); 
			int[] x = new int[1]; 
			x[0] = rand.nextInt(textStrings.length); 
			if(Arrays.asList(filledStrings).contains(x))
				i--;
			else
				Arrays.asList(filledStrings).add(x);
		}
	}
	
	//Function to return the current word
	public String currentWord(){
		return textStrings[iterator].get();
	}
	
	// Tells if we are done with this verse ( be sure to check if last word is not blank)
	public boolean isComplete(){
		if((iterator+1) == textStrings.length){
			return true;
		}
		return false;
	}
	
	// Generate the return string with "_" for blanks and filled words filled in.
	private String genString(){
		String ansVerse = "";
		for(int i = 0; i <textStrings.length; i++){
			if(Arrays.asList(filledStrings).contains(i)){	// Filled in word
				ansVerse = ansVerse + textStrings[i].get();
			} else{
				if(i == iterator){	// Highlighted Blank
					ansVerse = ansVerse + " << _ >> ";
				} else {			// Regular Blank
					ansVerse = ansVerse + "_";
				}				
			}
			
		}
		
		return ansVerse;
	}
	
	
}