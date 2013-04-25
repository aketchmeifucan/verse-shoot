package org.example.verse_shoot;

import android.app.Activity;
import android.os.Bundle;
import static org.example.verse_shoot.Constants.ID;
import static org.example.verse_shoot.Constants.TABLE_NAME;
import static org.example.verse_shoot.Constants.VERSE;
import static org.example.verse_shoot.Constants.VERSE_TEXT;
import android.app.ListActivity;
// ...
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.SimpleCursorAdapter;
// ...

public class VerseChooser extends ListActivity {
	
   private static String[] FROM = { ID, VERSE, };
   private static String ORDER_BY = VERSE + " ASC";
   private static int[] TO = { R.id.rowid, R.id.verse };
   private EventsData events;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.versechooser);
	      events = new EventsData(this);
	      try {
	         //addEvent("tester");
	         Cursor cursor = getEvents();
	         showEvents(cursor);
	      } finally {
	         events.close();
	      }
	}
	   private void addEvent(String string) {
	      // Insert a new record into the Events data source.
	      // You would do something similar for delete and update.
	      SQLiteDatabase db = events.getWritableDatabase();
	      ContentValues values = new ContentValues();
	      values.put(VERSE, string);
	      values.put(VERSE_TEXT, string);
	      db.insertOrThrow(TABLE_NAME, null, values);
	   }

	   private Cursor getEvents() {
	      // Perform a managed query. The Activity will handle closing
	      // and re-querying the cursor when needed.
	      SQLiteDatabase db = events.getReadableDatabase();
	      Cursor cursor = db.query(TABLE_NAME, FROM, null, null, null,
	            null, ORDER_BY);
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