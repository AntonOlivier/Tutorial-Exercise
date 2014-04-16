package com.example.test01;

import android.app.Activity;
import android.os.Bundle;

public class Tutorial04 extends Activity{

	DrawBall v;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		v = new DrawBall(this);
		setContentView(v);
	}

}
