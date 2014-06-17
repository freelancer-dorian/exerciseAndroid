package dorian.listcontrol;

import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setListAdapter(new MyAdapter(this, 
				android.R.layout.simple_list_item_1, R.id.textView1,
				getResources().getStringArray(R.array.countries)));
	}  

	private class MyAdapter extends ArrayAdapter<String> {

		public MyAdapter(Context context, int resource, int textViewResourceId,
				String[] strings) {
			super(context, resource, textViewResourceId, strings);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row = inflater.inflate(R.layout.list_item, parent, false);
			String[] items = getResources().getStringArray(R.array.countries);
			TextView tvTextView = (TextView) row.findViewById(R.id.textView1);
			ImageView iView = (ImageView) row.findViewById(R.id.imageView1);
			
			tvTextView.setText(items[position]);
			
			if(items[position].equals("United States")) {
				iView.setImageResource(R.drawable.usa);
			} else if(items[position].equals("Brazil")) {
				iView.setImageResource(R.drawable.brazil);				
			} else if(items[position].equals("Russia")) {
				iView.setImageResource(R.drawable.russia);				
			} else if(items[position].equals("Japan")) {
				iView.setImageResource(R.drawable.japan);				
			} else if(items[position].equals("France")) {
				iView.setImageResource(R.drawable.france);				
			}
			
			return row;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
