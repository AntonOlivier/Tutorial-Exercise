package com.example.test01;

import com.example.test01.SurfaceViewExample.OurView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {

	int x, y;
	int xSpeed, ySpeed;
	int height, width;
	int currentFrameX;
	int currentFrameY;
	float direction;
	int frameRate;
	Bitmap b;
	OurView ov;

	//sprite init
	public Sprite(OurView ourView, Bitmap blob) {
		b = blob;
		ov = ourView;
		height = b.getHeight() / 4;
		width = b.getWidth() / 6;
		x = 0;
		y = ov.getHeight() - height - ySpeed;
		xSpeed = 10;
		ySpeed = 0;
		currentFrameX = 0;
		direction = 0;
		frameRate = 25;
	}

	// determine position, direction and speed
	private void update() {
		// going right
		if (y > (ov.getHeight() - height - ySpeed)) {
			xSpeed = 10;
			ySpeed = 0;
			direction = 0;
		}
		// going down
		if (x + xSpeed  < 0) {
			x = (height-width)/2; //rotated canvas correction
			xSpeed = 0;
			ySpeed = 10;
			direction = 1;
		}
		// going left
		if (y + ySpeed < 0) {
			y = 0;
			xSpeed = -10;
			ySpeed = 0;
			direction = 2;
		}
		// going up
		if (x > (ov.getWidth() - width - xSpeed)) {
			x -= (height-width)/2; //rotated canvas correction
			xSpeed = 0;
			ySpeed = -10;
			direction = 3;
		}

		try {
			Thread.sleep(1000/frameRate); // "framerate" of the sprite
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// spritesheet has 6 sprites horizontally and 4 vertically
		// position increments for moving the visible part of the spritesheet
		// only 1 sprite shown at a time
		// position moves 6 times to the right, then resets to left and 1 down
		// rinse repeat 4 times, then resets to left and top
		currentFrameX = ++currentFrameX % 6;
		if (currentFrameX == 0) {
			currentFrameY = ++currentFrameY % 4;
		}
		
		// 
		x += xSpeed;
		y += ySpeed;
	}

	//sprite rendering
	public void onDraw(Canvas c) {
		update();
		int srcX = currentFrameX * width;
		int srcY = currentFrameY * height;

		Rect src = new Rect(srcX, srcY, srcX + width, srcY + height); // part of the spritesheet revealed in the mask
		Rect dst = new Rect(x, y, x + width, y + height); // sprite mask
	
		c.save(); // save absolute position of canvas
		float srcRot = direction * 90;	
		c.rotate(srcRot, x + width/2, y + height/2); // rotate canvas for sprite orientation (relative)	
		c.drawBitmap(b, src, dst, null);
		c.restore(); // load absolute position of canvas
	}

}
