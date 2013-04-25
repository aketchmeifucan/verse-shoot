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
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.SimpleCursorAdapter;
// ...

public class VerseChooser extends ListActivity {
	
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
	      try {
	         //addEvent("tester");
	    	 events.close();
	         Cursor cursor = getEvents();
	         showEvents(cursor);
	      } finally {
	         //events.close();
	      }
	}
	   private void addEvent(String string) {
	      // Insert a new record into the Events data source.
	      // You would do something similar for delete and update.
	      SQLiteDatabase db = events.getReadableDatabase();
	      ContentValues values = new ContentValues();
	      values.put(VERSE, string);
	      values.put(VERSE_TEXT, string);
	      db.insertOrThrow(TABLE_NAME, null, values);
	   }

	   @SuppressLint("NewApi")
	private Cursor getEvents() {
	      // Perform a managed query. The Activity will handle closing
	      // and re-querying the cursor when needed.
	      SQLiteDatabase db = events.getReadableDatabase();
	      System.out.println(events.getDatabaseName());
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
	   }
}