package com.example.test01;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Tutorial02 extends ListActivity {
	
	String classNames[] = {"MainActivity", "Menu", "Sweet", "Tutorial01"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classNames));

		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onListItemClick(ListView lv, View v, int position, long id){
		super.onListItemClick(lv, v, position, id);
		String openClass = classNames[position];
		try{
			Class selected = Class.forName("com.example.test01." + openClass);
			Intent selectedIntent = new Intent(this, selected);
			startActivity(selectedIntent);
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	
	
}
