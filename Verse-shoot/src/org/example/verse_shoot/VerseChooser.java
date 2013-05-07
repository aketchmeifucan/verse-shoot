package org.example.verse_shoot;

import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import static android.provider.BaseColumns._ID;
import static org.example.verse_shoot.Constants.TABLE_NAME;
import static org.example.verse_shoot.Constants.VERSE;
import static org.example.verse_shoot.Constants.VERSE_TEXT;
import android.app.ListActivity;
// ...
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
// ...
import android.widget.TextView;

public class VerseChooser extends ListActivity implements OnItemClickListener{
	
   private static String[] FROM = { _ID, VERSE, };
   private static int[] TO = { R.id.rowid, R.id.verse };
   private EventsData events;
   
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.versechooser);
	    events = new EventsData(this);
	    try {
	        	events.createDataBase();
	 	} catch (IOException ioe) {
	 		throw new Error("Unable to create database");
	 	}
	 	try {
	 		events.openDataBase();
	 	}catch(SQLException sqle){
	 		throw sqle;
	 	}
         //addEvent("tester");
    	 events.close();
         Cursor cursor = getEvents();
         showEvents(cursor);
	}

	   @SuppressLint("NewApi")
	private Cursor getEvents() {
	      // Perform a managed query. The Activity will handle closing
	      // and re-querying the cursor when needed.
	      SQLiteDatabase db = events.getReadableDatabase();
//	      Cursor cursor = db.query(TABLE_NAME, FROM, null, null, null,
//	            null, ORDER_BY);
	      Cursor cursor = db.rawQuery("select * from testverses", null);
	      startManagingCursor(cursor);
	      return cursor;
	   }

	   private void showEvents(Cursor cursor) {
	      // Set up data binding
	      SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
	            R.layout.item, cursor, FROM, TO);
	      setListAdapter(adapter);
	      final ListView lv = getListView();
	      lv.setOnItemClickListener(new OnItemClickListener() {
	    		@Override
	    		public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	    			// TODO Auto-generated method stub
	    			//getextra and putextra http://stackoverflow.com/questions/5219788/putextra-in-android
	    			Intent myIntent = new Intent(lv.getContext(), VerseShootHome.class);
	    			Cursor c = (Cursor) lv.getItemAtPosition(position);
	    			String listVerse=c.getString(1);
	    			String listVerseText=c.getString(2);
	    			
	    			myIntent.putExtra("VERSE", listVerse);
	    			myIntent.putExtra("VERSE_TEXT", listVerseText);
	    			
	                startActivityForResult(myIntent, 0);
	    		}
	      }); 
	   }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
}