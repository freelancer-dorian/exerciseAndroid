package com.dorian.pointlist;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PointList extends Activity {
	
	private static int mType = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.point_list);
		mType = getIntent().getIntExtra("ListType", CommonDefinitions.TYPE_INVALID);
		showTitle();
		
		// TODO
		ListView lv = (ListView) findViewById(R.id.pointList);
		List<String> listData = new ArrayList<String>();
        listData.add(getResources().getString(R.string.query_type_list));
        listData.add(getResources().getString(R.string.query_type_map));
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listData);
        lv.setAdapter(adapter);
        
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (mType) {
					case CommonDefinitions.TYPE_QUERY:
						queryPOI(position);
						break;
					case CommonDefinitions.TYPE_MODIFY:
						modifyPOI(position);
						break;
					case CommonDefinitions.TYPE_DELETE:
						deletePOI(position);
						break;
					default:
						break;
				}
			}
		});


	}
	
	private void queryPOI(int index) {
		// TODO
	}
	
	private void modifyPOI(int index) {
		// TODO		
	}
	
	private void deletePOI(int index) {
		// TODO
	}

	private void showTitle() {

		TextView tv = (TextView) findViewById(R.id.title);
		// set title according to mType
		String title = "";
		switch (mType) {
			case CommonDefinitions.TYPE_INVALID:
				title = "invalid type";
				break;
			case CommonDefinitions.TYPE_QUERY:
				title = getResources().getString(R.string.point_list_title_query);
				break;
			case CommonDefinitions.TYPE_MODIFY:
				title = getResources().getString(R.string.point_list_title_modify);
				break;
			case CommonDefinitions.TYPE_DELETE:
				title = getResources().getString(R.string.point_list_title_delete);
				break;
			default:
				break;
		}
		tv.setText(title);
	}
}
