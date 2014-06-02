package com.dorian.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class WeatherService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		Toast.makeText(this, R.string.service_bound,
                Toast.LENGTH_SHORT).show();
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this, R.string.service_start,
                Toast.LENGTH_SHORT).show();
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, R.string.service_destroy,
                Toast.LENGTH_SHORT).show();
		
	}
}
