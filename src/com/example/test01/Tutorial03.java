package com.example.test01;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Tutorial03 extends Activity implements OnClickListener {

	ImageView display;
	int toPhone;
	int imgView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.wallpaper);

		toPhone = R.drawable.bird;
		imgView = R.id.IVimage1;

		display = (ImageView) findViewById(R.id.IVdisplay);
		ImageView image1 = (ImageView) findViewById(R.id.IVimage1);
		ImageView image2 = (ImageView) findViewById(R.id.IVimage2);
		ImageView image3 = (ImageView) findViewById(R.id.IVimage3);
		ImageView image4 = (ImageView) findViewById(R.id.IVimage4);
		ImageView image5 = (ImageView) findViewById(R.id.IVimage5);
		ImageView image6 = (ImageView) findViewById(R.id.IVimage6);
		ImageView image7 = (ImageView) findViewById(R.id.IVimage7);
		ImageView image8 = (ImageView) findViewById(R.id.IVimage8);
		ImageView image9 = (ImageView) findViewById(R.id.IVimage9);
		ImageView image10 = (ImageView) findViewById(R.id.IVimage10);
		ImageView image11 = (ImageView) findViewById(R.id.IVimage11);

		Button setWall = (Button) findViewById(R.id.BsetWallpaper);

		image1.setOnClickListener(this);
		image2.setOnClickListener(this);
		image3.setOnClickListener(this);
		image4.setOnClickListener(this);
		image5.setOnClickListener(this);
		image6.setOnClickListener(this);
		image7.setOnClickListener(this);
		image8.setOnClickListener(this);
		image9.setOnClickListener(this);
		image10.setOnClickListener(this);
		image11.setOnClickListener(this);
		setWall.setOnClickListener(this);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.IVimage1:
			display.setImageResource(R.drawable.bird);
			toPhone = R.drawable.bird;
			imgView = arg0.getId();
			break;
		case R.id.IVimage2:
			display.setImageResource(R.drawable.butterfly);
			toPhone = R.drawable.butterfly;
			imgView = arg0.getId();
			break;
		case R.id.IVimage3:
			display.setImageResource(R.drawable.cat);
			toPhone = R.drawable.cat;
			imgView = arg0.getId();
			break;
		case R.id.IVimage4:
			display.setImageResource(R.drawable.cow);
			toPhone = R.drawable.cow;
			imgView = arg0.getId();
			break;
		case R.id.IVimage5:
			display.setImageResource(R.drawable.dog);
			toPhone = R.drawable.dog;
			imgView = arg0.getId();
			break;
		case R.id.IVimage6:
			display.setImageResource(R.drawable.flowers);
			toPhone = R.drawable.flowers;
			imgView = arg0.getId();
			break;
		case R.id.IVimage7:
			display.setImageResource(R.drawable.horse);
			toPhone = R.drawable.horse;
			imgView = arg0.getId();
			break;
		case R.id.IVimage8:
			display.setImageResource(R.drawable.ladybug);
			toPhone = R.drawable.ladybug;
			imgView = arg0.getId();
			break;
		case R.id.IVimage9:
			display.setImageResource(R.drawable.pigs);
			toPhone = R.drawable.pigs;
			imgView = arg0.getId();
			break;
		case R.id.IVimage10:
			display.setImageResource(R.drawable.sheep);
			toPhone = R.drawable.sheep;
			imgView = arg0.getId();
			break;
		case R.id.IVimage11:
			display.setImageResource(R.drawable.turtle);
			toPhone = R.drawable.turtle;
			imgView = arg0.getId();
			break;
		case R.id.BsetWallpaper:

			InputStream getRsc = getResources().openRawResource(toPhone);
			Bitmap bg = BitmapFactory.decodeStream(getRsc);
			CharSequence contentDesc = (CharSequence) findViewById(imgView)
					.getContentDescription();
			String content = contentDesc.toString();

			try {
				getApplicationContext().setWallpaper(bg);
				Toast done = Toast.makeText(Tutorial03.this,
						"Wallpaper changed to " + content, Toast.LENGTH_LONG);
				done.show();

			} catch (IOException e) {
				e.printStackTrace();
			}

			break;

		}

	}

}
