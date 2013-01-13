package com.grothetr.androidgame.ballonplane;

import android.os.SystemClock;
import android.util.Log;

public class Ball {
	float x;
	float y;
	
	float vx = 0;
	float vy = 0;

	final int VELOCITY_MULTIPLIER = 200; //so the ball actually moves at a reasonable speed
	public Ball(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public void update(float deltaTime, float[] accel){
		
		for (int i = 0; i < accel.length; i++){
			accel[i] = accel[i] * Settings.gravity;
		}
		
		
		
		
		vx += accel[0]*deltaTime*VELOCITY_MULTIPLIER;
		vy += accel[1]*deltaTime*VELOCITY_MULTIPLIER;
		
		if (x-vx/VELOCITY_MULTIPLIER > 480-96 || x-vx/VELOCITY_MULTIPLIER < 0){
			
			vx = -1*vx*Settings.nrgSaved;
			
		}
		
		if (y+vy/VELOCITY_MULTIPLIER> 800-96 || y+vy/VELOCITY_MULTIPLIER < 0){
			vy = -1*vy*Settings.nrgSaved;
			
		}
		
		x += -1 * vx * deltaTime;
		y += vy * deltaTime;
		
	}
	
}
