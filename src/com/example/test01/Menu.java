package com.example.test01;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final MediaPlayer buttonSound = MediaPlayer.create(Menu.this,
				R.raw.button17);
		buttonSound.setVolume((float) 0.02, (float) 0.02);

		// Button reference setup
		Button tut1 = (Button) findViewById(R.id.button1);
		Button tut2 = (Button) findViewById(R.id.button2);
		Button tut3 = (Button) findViewById(R.id.button3);
		Button tut4 = (Button) findViewById(R.id.button4);
		Button ani2 = (Button) findViewById(R.id.button5);

		tut1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonSound.start();
				startActivity(new Intent("android.intent.action.TUTORIAL01"));
			}
		});

		tut2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonSound.start();
				startActivity(new Intent("android.intent.action.TUTORIAL02"));
			}

		});

		tut3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonSound.start();
				startActivity(new Intent("android.intent.action.TUTORIAL03"));
			}
		});

		tut4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonSound.start();
				startActivity(new Intent("android.intent.action.TUTORIAL04"));
			}
		});

		ani2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonSound.start();
				startActivity(new Intent("android.intent.action.ANIMATION2"));
			}
		});
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater awesome = getMenuInflater();
		awesome.inflate(R.menu.main_menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menuSweet:
			startActivity(new Intent("android.intent.action.SWEET"));
			return true;
		case R.id.menuToast:
			Toast andEggs = Toast.makeText(Menu.this, "This is a toast",
					Toast.LENGTH_LONG);
			andEggs.show();
			return true;
		}
		return false;
	}
}
