package lancer.dorian.transitiontest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btn = (Button)findViewById(R.id.button1);
		
		btn.setOnClickListener(listener);
	}
	
	public OnClickListener listener = new OnClickListener(){
		public void onClick(View v){
			Log.i("Appppple", "On Click");
			TextView tv = (TextView)findViewById(R.id.textView1);
			
			tv.setText("Clicked");
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
