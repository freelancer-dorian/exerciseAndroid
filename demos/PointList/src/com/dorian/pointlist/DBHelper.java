package com.dorian.pointlist;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper {

	private Context m_ctx;
	private DatabaseOpenHelper m_openHelper = null;
	private SQLiteDatabase m_db;
	private static String m_dbName = "test.db";
	private static int m_version = 1;
	private static DBHelper m_dbHelper = null;
	
	
	DBHelper(Context ctx) {
		m_ctx = ctx;
	}
	
	public static DBHelper getInstance(Context ctx) {
		if (m_dbHelper == null) {
			m_dbHelper = new DBHelper(ctx);
		}
		
		return m_dbHelper;
	}
	
	
	public void openDB() {
		m_openHelper = new DatabaseOpenHelper(m_ctx);
		m_db = m_openHelper.getWritableDatabase();
	}
	
	public void addPoint(POIPoint point) {
		m_db.execSQL("insert into coordinates values (null,?,?,?)", new Object[]{point.lon, point.lat, point.name});
	}
	
	public void closeDB() {
		m_db.close();
	}
	
	public List<POIPoint> query() {
		ArrayList<POIPoint> points = new ArrayList<POIPoint>();
		Cursor c = m_db.rawQuery("select * from coordinates", null);
		while(c.moveToNext()) {
			POIPoint p = new POIPoint();
			p.lon = c.getLong(c.getColumnIndex("lon"));
			p.lat = c.getLong(c.getColumnIndex("lat"));
			p.name = c.getString(c.getColumnIndex("name"));
			
			points.add(p);
		}
		return points;
	}
	
	private static class DatabaseOpenHelper extends SQLiteOpenHelper {

		public DatabaseOpenHelper(Context context) {
			super(context, m_dbName, null, m_version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("create table if not exists coordinates(_id integer primary key autoincrement, lon bigint, lat bigint, name varchar)");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
