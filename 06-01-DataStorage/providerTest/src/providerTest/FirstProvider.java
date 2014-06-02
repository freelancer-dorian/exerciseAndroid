package providerTest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class FirstProvider extends ContentProvider {

	@Override
	public boolean onCreate() {
		System.out.println("[DW]ContentProvider Created");
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		System.out.println("[DW]query executed, where is : " + selection);
		
		
		return null;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {

		System.out.println("[DW]insert executed, content values is : " + values);
		
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		System.out.println("[DW]delete executed, where is : " + selection);
		
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {

		System.out.println("[DW]update executed, where is : " + selection + " and values is : " + values);
		
		return 0;
	}

}
