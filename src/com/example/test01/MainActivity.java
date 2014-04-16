package com.example.test01;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity {

	MediaPlayer logoMusic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		logoMusic = MediaPlayer.create(MainActivity.this, R.raw.testintro);
		float splashVolume = (float) 0.02;
		logoMusic.setVolume(splashVolume , splashVolume);
		logoMusic.start();
		
		Thread logoTimer = new Thread(){
			public void run(){
				try {
					sleep(1000);
					Intent menuIntent = new Intent("android.intent.action.MENU");
					startActivity(menuIntent);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					finish();
				}
			}
		};
		logoTimer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		logoMusic.release();
	}

}
