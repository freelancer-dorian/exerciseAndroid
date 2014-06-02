package com.dorian.activitytest;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static Intent intent = new Intent();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        
        final String ACT_SERVICE = "com.dorian.service_WEATHER";
        intent.setAction(ACT_SERVICE);

    }
    
        
    @Override
    protected void onStart() {
    	super.onStart();
    	
    	Log.d("dw","onStart excuted!");
    	
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	
    	Log.d("dw","onPause excuted!");
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	
    	Log.d("dw","onResume excuted!");
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	
    	Log.d("dw","onDestroy excuted!");
    }

    @Override
    protected void onStop() {
    	super.onStop();

    	Log.d("dw","onStop excuted!");
    }

    @Override
    protected void onRestart() {
    	super.onRestart();
    	
    	Log.d("dw","onRestart excuted!");
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if ((requestCode == 9 ) && (resultCode == 9)) {
    		Bundle s = data.getExtras();
    		String log = s.getString("dorian");
    		Log.d("dw",log);
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onStartClicked(View v) {
    	startService(intent);
    }
    
//    public void onStopClicked(View v) {
//    	stopService(intent);
//    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

    	
    	
    	//////////////////////////////////////////////////////////
    	// fragment communicate with activity using interface
    	// In activity, implement the I/F defined in interface 
//    	
//    	public interface myInter {
//    		public String updateString();
//    		public void saveString(String s);
//    	}
//    	
//    	public myInter myListener;
//    	
//    	@Override
//    	public void onAttach(Activity activity) {
//    		super.onAttach(activity);
//    		
//    		myListener = (myInter)activity;
//    	}
//    	
    	//////////////////////////////////////////////////////////
    	
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            Button b1 = (Button) rootView.findViewById(R.id.button2);
            b1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent it = new Intent();
					it.setClass(getActivity(), secondActivity.class);
					getActivity().startActivityForResult(it, 9);
				}
			});
            
  
            return rootView;
        }
        

    }

}
