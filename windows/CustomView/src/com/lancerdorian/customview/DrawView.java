package com.lancerdorian.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View{
	public float curX = 40;
	public float curY = 50;
	
	Paint p = new Paint();
	
	public DrawView(Context context){
		super(context);
	}
	public DrawView(Context context, AttributeSet set){
		super(context,set);
	}
	@Override
	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		p.setColor(Color.RED);
		canvas.drawCircle(curX, curY, 15, p);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		curX = event.getX();
		curY = event.getY();
		invalidate();
		return true;
	}
	
}
