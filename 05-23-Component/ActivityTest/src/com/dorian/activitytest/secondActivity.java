package com.dorian.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class secondActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);
	
		Intent intent = new Intent();
		intent.putExtra("dorian", "Setting result in Sec");
		
		secondActivity.this.setResult(9, intent);
	
	}
	
}
