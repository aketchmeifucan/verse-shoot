/** DatabaseManager is responsible for executing the queries to the database. 
 * This file access the created database file by the DatabaseCreator class. To maintain each activity modular, 
 * SQL statments should be placed here and access via an instance of this class inside the corresponding activity.  
 * @author Eliezer Rodriguez
 * @version 1.0 Febuary 11, 2013
 */
package edu.taylor.cse.sbrandle.biblemem.v001;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseManager extends SQLiteOpenHelper {
	static SQLiteDatabase    db;
	private static final String DATABASE_NAME = "versememorizer.db";
	private static final String DATABASE_PATH_INT = "/Databases";
	private static String TAG = "DatabaseManager";


	/** This sets up an instance of LocalSQLiteHelper.
	 * @param context Give the context of this application so that we call and create the database for this application.
	 * @throws IOException 
	 */
	public DatabaseManager(Context context) throws IOException {
		super(context, getDatabaseAbsoluteFileName(context), null, 1);
		File database =  DatabaseManager.getDatabaseFile(context);
		if (database.exists()) {
			db	= this.getWritableDatabase();
		}else{

			Log.i(TAG, "Database File not Found");
		}
	}


	/** This function returns the path where database  files should be saved.
	 * @param context Give the context of this application so that we call and create the database for this application.
	 * @return This will return the path where database files should be saved.
	 */
	public static String getDatabasePath(Context context) {
		return context.getFilesDir().getPath()+ DATABASE_PATH_INT;			
	}


	public static File getDatabaseFile(Context context){

		return new File(getDatabasePath(context), DATABASE_NAME);


	}

	/** This function returns the absolute path where the database file should be saved.
	 * @param context Give the context of this application so that we call and create the database for this application.
	 * @return This will return the absolute path where the database file should be saved.
	 */
	public static String getDatabaseAbsoluteFileName(Context context){
		return getDatabaseFile(context).getAbsolutePath();
	}



/**
 * getBookInfo returns two arrays, one containing the book names on the database, and the other one containing the total number
 * of chapter found in each book.
 * @return
 */
	public  ArrayList<ArrayList<String>>  getBookInfo(){

		String sql = "SELECT B.book_id, B.testament, B.name, B.alternate_name, chp.total_chapter "
				+                         "FROM Book B,(SELECT DISTINCT VC.book_id, COUNT(VC.chapter_id) AS total_chapter "
				+                          "FROM VerseCount VC "
				+                          "GROUP BY VC.book_id) AS chp "
				+ " WHERE chp.book_id = B.book_id "
				+ " ORDER BY B.book_id;";
		db	= this.getWritableDatabase();
		Cursor row = db.rawQuery(sql, null);

		ArrayList<ArrayList<String>> names_and_chaptotal = new ArrayList<ArrayList<String>>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> book_total = new ArrayList<String>();

		if ((row.getCount() > 0) && (!row.isClosed())) {
			row.moveToFirst();
			do {


				names.add(row.getString(2));
				book_total.add(row.getString(4));
			} while(row.moveToNext());
		} 
		row.close();
		names_and_chaptotal.add(names);
		names_and_chaptotal.add(book_total);
		return names_and_chaptotal;
	}

	/**
	 * getVerseTotalFomBookIDANDChapterID returns an integer representing the total number of Verses found in a chapter
	 * @param bid this is the book ID 
	 * @param chpid this is the chapter ID
	 * @return
	 */
	public  int  getVerseTotalFomBookIDANDChapterID(int bid, int chpid){

		String sql = " Select verse_count FROM VerseCount VC WHERE  VC.chapter_id =" +  String.valueOf(chpid) + " AND VC.book_id = " +  String.valueOf(bid);
		db	= this.getWritableDatabase();
		Cursor row = db.rawQuery(sql, null);
		int verseTotal = 0;
		if ((row.getCount() > 0) && (!row.isClosed())) {
			row.moveToFirst();
			do {


				verseTotal = row.getInt(0);

			} while(row.moveToNext());
		} 
		row.close();
		return verseTotal;
	}

	public void closeDatabase(){
		db.close();
	}

	/**
	 * getVerseWithReference returns two strings, one containing the the reference for a verse, and the other the actual text for the verse
	 * @param bid Book ID
	 * @param chpid Chapter Number
	 * @param vnum Verse Number
	 * @return
	 */
	public  Verse  getVerseWithReference(int bid, int chpid, int vnum){

		String sql = "SELECT DISTINCT  B.name, V.chapter_id, V.verse_num, V.text FROM Book B, Verse V WHERE B.book_id =" +  String.valueOf(bid) + " AND V.book_id =" +  String.valueOf(bid) + " AND  V.chapter_id =" +  String.valueOf(chpid) + "  AND V.verse_num =" +  String.valueOf(vnum);
		db	= this.getWritableDatabase();
		Cursor row = db.rawQuery(sql, null);


		String ref ="";
		String text ="";
		if ((row.getCount() > 0) && (!row.isClosed())) {
			row.moveToFirst();
			do {
				ref = row.getString(0) + " " + row.getString(1) +  ":" + row.getString(2);
				text = row.getString(3);
			} while(row.moveToNext());
		} 
		row.close();
		return new Verse(ref, text);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}



}