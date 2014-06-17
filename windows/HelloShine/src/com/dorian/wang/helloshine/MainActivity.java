package com.dorian.wang.helloshine;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText eText = (EditText) findViewById(R.id.editText1);
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				intent.putExtra("sayhi", eText.getText().toString());
				
				startActivity(intent);
//				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//				builder.setMessage("Say Hi?");
//				builder.setCancelable(false);
//				builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
//					
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						// TODO Auto-generated method stub
//						MainActivity.this.finish();						
//					}
//				});
//				
//				builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
//					
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						// TODO Auto-generated method stub
//						dialog.cancel();
//					}
//				});
//				
//				AlertDialog alert = builder.create();
//				alert.show();
				
				
			}
		});
		
		ImageView iView = (ImageView)findViewById(R.id.imageView1);
		iView.setImageURI((Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
