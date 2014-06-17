package com.lancerdorian.hellolover;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	int[] images = new int[]{
			R.drawable.p1,
			R.drawable.p2,
			R.drawable.p3,
			R.drawable.p4,
	};
	int curImage = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        LinearLayout main = (LinearLayout) findViewById(R.id.root);
        final ImageView image = new ImageView(this);
        
        main.addView(image);
        
        image.setImageResource(images[0]);
        image.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		image.setImageResource(images[++curImage % images.length]);
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
