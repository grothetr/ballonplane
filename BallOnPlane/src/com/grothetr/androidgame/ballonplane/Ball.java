package com.grothetr.androidgame.ballonplane;

import android.os.SystemClock;
import android.util.Log;

public class Ball {
	float x;
	float y;
	
	float vx = 0;
	float vy = 0;
	
	public Ball(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public void update(float deltaTime, float[] accel){
		
		for (int i = 0; i < accel.length; i++){
			accel[i] = accel[i] / Settings.mass;
		}
		
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
		
	}
	
}
