package com.dorian.sqltest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper{

	private static String m_sDBName = "test.db";
	private static int m_iVersion = 1;
	private DatabaseHelper m_dbHelper = null;
	private SQLiteDatabase m_DB;
	private Context m_Ctx;
	
	MyDBHelper(Context ctx) {
		this.m_Ctx = ctx;
	}
	
	public void open() {
		m_dbHelper = new DatabaseHelper(m_Ctx);
		m_DB = m_dbHelper.getWritableDatabase();
	}
	
	public void addString(String s) {
		m_DB.execSQL("insert into person values (null, ?)",new Object[]{s});
	}
	
	public Cursor queryAll() {
		Cursor c = m_DB.rawQuery("select * from person",null);
		
		return c;
	}
	
	public void closeDB() {
		m_DB.close();
	}
	
	private static class DatabaseHelper extends SQLiteOpenHelper {

		public DatabaseHelper(Context context) {
			super(context, m_sDBName, null, m_iVersion);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// create tables and define each colume
			db.execSQL("create table if not exists person (_id integer primary key autoincrement, name varchar)");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
