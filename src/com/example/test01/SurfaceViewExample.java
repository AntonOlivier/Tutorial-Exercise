package com.example.test01;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class SurfaceViewExample extends Activity implements OnTouchListener {

	OurView v;
	Bitmap ball, blob;
	float x, y;

	Sprite sprite;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		v = new OurView(this);
		v.setOnTouchListener(this);
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
		blob = BitmapFactory.decodeResource(getResources(),
				R.drawable.spritesheet_walking);
		x = y = 0;
		setContentView(v);
	}

	public class OurView extends SurfaceView implements Runnable {

		Thread t = null;
		SurfaceHolder holder;
		boolean isItOK = false;

		public OurView(Context context) {
			super(context);
			holder = getHolder();
		}

		@SuppressLint("WrongCall")
		@Override
		public void run() {
			
			sprite = new Sprite(OurView.this, blob);
			
			while (isItOK == true) {
				if (!holder.getSurface().isValid()) {
					continue;
				}
				Canvas c = holder.lockCanvas();
				onDraw(c);
				holder.unlockCanvasAndPost(c);
			}
		}

		@SuppressLint("WrongCall")
		public void onDraw(Canvas c) {
			c.drawARGB(255, 218, 242, 255);
			c.drawBitmap(ball, x - (ball.getWidth() / 2), y
					- (ball.getHeight() / 2), null);
			sprite.onDraw(c);
		}

		public void pause() {
			isItOK = false;
			while (true) {
				try {
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			t = null;
		}

		public void resume() {
			isItOK = true;
			t = new Thread(this);
			t.start();
		}

	}

	@Override
	protected void onPause() {
		super.onPause();
		v.pause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		v.resume();
	}

	@Override
	public boolean onTouch(View v, MotionEvent me) {

		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		switch (me.getAction()) {
		case MotionEvent.ACTION_DOWN:
			x = me.getX();
			y = me.getY();
			break;
		case MotionEvent.ACTION_UP:
			x = me.getX();
			y = me.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			x = me.getX();
			y = me.getY();
			break;
		}

		return true;
	}

}
