package com.dorian.wang.helloshine;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		TextView tView = (TextView) findViewById(R.id.textView1);
		tView.setText(getIntent().getExtras().getString("sayhi"));
		
	}
}
