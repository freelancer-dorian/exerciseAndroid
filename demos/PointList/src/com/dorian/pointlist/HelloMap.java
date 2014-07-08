package com.dorian.pointlist;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;

import android.app.Activity;
import android.os.Bundle;

public class HelloMap extends Activity {
	
	MapView mv = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SDKInitializer.initialize(getApplicationContext());
		
		setContentView(R.layout.hello_map);
		mv = (MapView) findViewById(R.id.bmapView);
			
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		mv.onDestroy();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		mv.onResume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		mv.onPause();
	}
	
}
