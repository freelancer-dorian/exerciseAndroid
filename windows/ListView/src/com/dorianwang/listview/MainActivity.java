package com.dorianwang.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	private String[] names = new String[]{
		"Tiger","nongyu","Qingzhao","Bai"	
	};
	private String[] descs = new String[]{
		"Lovely boy","music fan","cai nv yoo","achohal"	
	};
	private int[] imageIds = new int[]{
		R.drawable.tiger,R.drawable.nongyu,R.drawable.qingzhao,R.drawable.libai	
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		
		for (int i = 0; i < names.length; i++){
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("header", imageIds[i]);
			listItem.put("personName",names[i]);
			listItem.put("desc",descs[i]);
			
			listItems.add(listItem);
		}
		
		SimpleAdapter sa = new SimpleAdapter(this, listItems,R.layout.simle_item,
				new String[] {"header","personName","desc"},
				new int[] {R.id.header,R.id.name,R.id.desc}
				);
		
		ListView list = (ListView)findViewById(R.id.list1);
		
		list.setAdapter(sa);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
