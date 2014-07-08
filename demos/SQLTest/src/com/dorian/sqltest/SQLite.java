package com.dorian.sqltest;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;


public class SQLite extends Activity{
	class Person {
		String name;
		int age;
		
		Person() {
			name = "";
			age = 1;
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		MyDBHelper helper = new MyDBHelper(this);
		helper.open();
		helper.addString("john");
		helper.addString("jack");
		
		Cursor c = helper.queryAll();
		while(c.moveToNext()) {
			String name = c.getString(c.getColumnIndex("name"));
			Log.d("shine", "the info get from DB is :" + name);
		}
		
		helper.closeDB();
	}
}
