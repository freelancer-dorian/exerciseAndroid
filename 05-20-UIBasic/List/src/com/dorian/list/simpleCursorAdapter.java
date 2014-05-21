package com.dorian.list;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.support.v4.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class simpleCursorAdapter extends Activity {
	
	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		listView = new ListView(this);
        
        Cursor cursor = getContentResolver().query(People.CONTENT_URI, null, null, null, null);
        startManagingCursor(cursor);
         
        ListAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_1, 
                cursor,
                new String[]{People.NAME}, 
                new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
         
        listView.setAdapter(listAdapter);
        setContentView(listView);
	}
}
