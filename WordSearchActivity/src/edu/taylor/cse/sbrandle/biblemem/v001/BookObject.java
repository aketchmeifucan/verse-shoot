package edu.taylor.cse.sbrandle.biblemem.v001;

import java.util.ArrayList;

public class BookObject  {
	
	
	
	
	
	private static String testament;;
	private static String name;
	private static String altname;
	private static int book_id;
	private static int totalChapter;
	private ArrayList<String> abbreviations;
	private ArrayList<Integer> verse_counts;
	private ArrayList<String> names;


	public  BookObject(String test, String aname, String alt, ArrayList<String> abbs, ArrayList<Integer> vcount, int abook_id,int chptotal ) {  
		 
		 testament = test;
	     name = aname;
	     altname = alt;
		abbreviations= abbs;
		verse_counts = vcount;
		book_id = abook_id;
		totalChapter  = chptotal;
	 }
	
	
	
	public String getTestament(){
		return testament;
		
	}
	
	public void setnames(ArrayList<String> name){
		names = name;
		
	}
	
	public ArrayList<String> getNames(){
		return names;
		
	}
	public int gettotalChapter(){
		return totalChapter;
		
	}
	public int getBookID (){
		return book_id;
		
	}
	public String getBookName(){
		return name;
		
	}
	public String getAlternateName(){
		return altname;
		
	}
	public ArrayList<String> getAbreviatedNames(){
		return abbreviations;
		
	}
	public ArrayList<Integer> getVerseCount(){
		return verse_counts;
		
	}
	
}
