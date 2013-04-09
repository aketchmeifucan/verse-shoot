package edu.taylor.cse.sbrandle.biblemem.v001;

import android.app.Activity;

import android.os.Bundle;

import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;


 
public class WordSearchActivity extends Activity {
	static final String[] numbers = new String[] { 
		"A", "B", "C", "D", "E",
		"F", "G", "H", "I", "J",
		"K", "L", "M", "N", "O",
		"P", "Q", "R", "S", "T",
		"U", "V", "W", "X", "Y", "Z"};
	 SearchGrid mGrid;
	    private  OnTouchListener l;
		  @Override
		  public void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.search_grid_layout);
		     mGrid = (SearchGrid) findViewById(R.id.my_custom_grid_view);
		   
		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, numbers);
	 
		    mGrid.setAdapter(adapter);
	
		   // mGrid.setPersonalizedOnTouchListener(l);
		  }
		  
		  
	
		 

		 
		}	
	
	
	
	

	
 
