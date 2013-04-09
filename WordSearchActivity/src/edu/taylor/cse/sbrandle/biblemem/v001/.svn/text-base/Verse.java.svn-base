/**
 * Basic Verse class.
 */
package edu.taylor.cse.sbrandle.biblemem.v001;

public class Verse {
    private String reference;
    private String text;
    
	public Verse() {
		// TODO Auto-generated constructor stub
	}
	
	public Verse(String reference, String text) {
		this.reference = new String(reference);
		this.text = new String(text);
	}
	
	public String getReference() {
		return reference;
	}
	
	public String getText() {
		return text;
	}
	
	public String toString() {
		final int PEEK_LEN = 15;
		int len = text.length();
		if(len < 10) {
			return new String(reference + " " + text.substring(0, len) + " ...");
		} else {
			return new String(reference + " " + text.substring(0, PEEK_LEN) + " ...");
		}
	}
}
