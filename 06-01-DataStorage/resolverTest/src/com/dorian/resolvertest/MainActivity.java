package com.dorian.resolvertest;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {
	
	static ContentResolver resolver;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        resolver = getContentResolver();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

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

    	
    	Uri uri = Uri.parse("content://providerTest.firstprovider/");
    	
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            
            Button query = (Button) rootView.findViewById(R.id.query);
            Button insert = (Button) rootView.findViewById(R.id.insert);
            Button update = (Button) rootView.findViewById(R.id.update);
            Button delete = (Button) rootView.findViewById(R.id.delete);
            
            
            query.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Cursor c = resolver.query(uri, null, "query_where", null, null);
					Toast.makeText(getActivity(), "the text returned is : " + c, Toast.LENGTH_LONG).show();
				}
			});
            
            insert.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					ContentValues values = new ContentValues();
					values.put("name", "shine");
					
					Uri newUri = resolver.insert(uri, values);
					Toast.makeText(getActivity(), "interted uri is : " + newUri, Toast.LENGTH_LONG).show();

				}
			});

            update.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					ContentValues values = new ContentValues();
					values.put("name", "shine");
					int count = resolver.update(uri, values, "update_where", null);
					Toast.makeText(getActivity(), "updated index is : " + count, Toast.LENGTH_LONG).show();
				}
			});			
            
            delete.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					int count = resolver.delete(uri, "delete_where", null);
					Toast.makeText(getActivity(), "delete index is : " + count, Toast.LENGTH_LONG).show();
				}
			});
            
            
            
            
            
            
            
            return rootView;
        }
    }

}
