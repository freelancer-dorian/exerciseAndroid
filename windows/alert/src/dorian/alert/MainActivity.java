package dorian.alert;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button b3 = (Button) findViewById(R.id.button3);
		b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Dialog d = new Dialog(MainActivity.this);
				d.setContentView(R.layout.dialog);
				d.setTitle("this is important");
				d.show();
			}
		});
		
		
		
		Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setMessage("Say Hi?");				
				
				builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						MainActivity.this.finish();
					}
				});
				builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
				
				AlertDialog alertDialog = builder.create();				
				alertDialog.show();
			}
		});
		
		final ProgressDialog pDialog = new ProgressDialog(this);
		pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pDialog.setMessage("Just Wait...");
		pDialog.setCancelable(true);
		pDialog.setIndeterminate(false);
		
		Button b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				pDialog.show();
				pDialog.setProgress(50);		
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mymenu, menu);
		return true;
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	

}
