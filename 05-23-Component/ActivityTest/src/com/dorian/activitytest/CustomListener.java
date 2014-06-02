package com.dorian.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class CustomListener implements View.OnClickListener {

	private Activity mAct;
	private Intent intent;
	
	public CustomListener(Activity act, Intent intent, String s) {
		Log.d("dw",s);
		this.mAct = act;
		this.intent = intent;
	}
	
	@Override
	public void onClick(View v) {
		Intent i = new Intent();
		i.setClass(this.mAct, secondActivity.class);
		this.mAct.startActivity(i);
	}

}
