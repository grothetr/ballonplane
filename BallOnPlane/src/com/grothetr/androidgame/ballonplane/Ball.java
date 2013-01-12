package com.grothetr.androidgame.ballonplane;

import android.os.SystemClock;
import android.util.Log;

public class Ball {
	float x=240;
	float y=300;
	
	float vx = 0;
	float vy = 0;
	
	
	
	public void update(float deltaTime, float[] accel){
		
		final float NRGSAVED = .65f; // percentage of velocity that will remain when bouncing
		
		
		vx += accel[0]*deltaTime*100;
		vy += accel[1]*deltaTime*100;
		
		if (x-vx*.01 > 480-96 || x-vx*.01 < 0){
			
			vx = -1*vx*NRGSAVED;
			
		}
		
		if (y+vy*.01> 800-96 || y+vy*.01 < 0){
			vy = -1*vy*NRGSAVED;
			
		}
		
		x += -1 * vx * deltaTime;
		y += vy * deltaTime;
		Log.d("vel x y: ", Float.toString(vx) + "   " + Float.toString(vy));
		
		
		
		
		
	}
	
}
