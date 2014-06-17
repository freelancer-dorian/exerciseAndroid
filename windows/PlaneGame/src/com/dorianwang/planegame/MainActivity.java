package com.dorianwang.planegame;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	private int speed = 10;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		final PlaneView planeView = new PlaneView(this);
		setContentView(planeView);
		planeView.setBackgroundResource(R.drawable.back);
		
		
		WindowManager wM = getWindowManager();
		Display display = wM.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);
		// init the position of the plane
		planeView.curX = metrics.widthPixels / 2;
		planeView.curY = metrics.heightPixels - 40;
		
		planeView.setOnKeyListener(new OnKeyListener(){
			@Override
			public boolean onKey(View source, int keyCode, KeyEvent event){
				switch(event.getKeyCode()){
				case KeyEvent.KEYCODE_A:
					planeView.curX -= speed;
					break;
				case KeyEvent.KEYCODE_W:
					planeView.curY -= speed;
					break;
				case KeyEvent.KEYCODE_D:
					planeView.curX += speed;
					break;
				case KeyEvent.KEYCODE_S:
					planeView.curY += speed;
					break;
				default:
						break;					
				}
				planeView.invalidate();
				return true;
			};
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
