package dorain.datacontrol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText et = (EditText) findViewById(R.id.editText1);
		final Button b3 = (Button) findViewById(R.id.button2);
		final TextView tv = (TextView) findViewById(R.id.textView1);
		
		
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Preference.class);
				startActivity(intent);
			}
		});
		
//		SQLiteDatabase db = openOrCreateDatabase("myDB", MODE_PRIVATE, null);
////		db.execSQL("CREATE TABLE IF NOT EXIST MyTable(LastName VARCHAR, FirstName VARCHAR, Age INT(3));");
////		db.execSQL("INSERT INTO MyTable VALUES('randy', 'wang','22');");
//		Cursor c = db.rawQuery("SELECT * FROM MyTable", null);
//		c.moveToFirst();
//		Log.d("wang-dd",c.getString(c.getColumnIndex("FirstName")));
//		db.close();
//		
		b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				try {

					URL url = null;
					url = new URL(et.getText().toString());
					URLConnection connection = url.openConnection();

					BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					String line = "";
					while ((line = reader.readLine()) != null) {
						tv.append(line);
					}
					
				} catch (Exception e) {

				}
				
			}
		});
		 
		
		
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
//		
//		SharedPreferences saver = getSharedPreferences("MYPREF", 0);
//		SharedPreferences.Editor editor = saver.edit();
//		editor.putString("MYPREF", et.getText().toString());
//		editor.commit();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
