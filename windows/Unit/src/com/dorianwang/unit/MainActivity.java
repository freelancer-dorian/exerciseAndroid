package com.dorianwang.unit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EditText etEditText = (EditText) findViewById(R.id.editText1);
		
		Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(this);
		
		Button b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v){
		if(v.getId() == R.id.button2){
			Log.d("SH", "button2 clicked");
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
