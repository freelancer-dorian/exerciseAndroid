package dorian.notify;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				Notification notify = new Notification(android.R.drawable.stat_notify_more,	
						"Greetings", System.currentTimeMillis());
				Context context = MainActivity.this;
				CharSequence title = "Greeting from Dorian";
				CharSequence detail = "You still the person i adore!";
				Intent intent = new Intent(context,MainActivity.class);
				PendingIntent pending = PendingIntent.getActivity(context, 0, intent, 0);
				notify.setLatestEventInfo(context, title, detail, pending);
				notify.sound = Uri.parse("android.resource://dorian.notify/" + R.raw.beep);
				nm.notify(0,notify	);
			}
		});
		
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(MainActivity.this, "Hello ? Yy", 2000);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
