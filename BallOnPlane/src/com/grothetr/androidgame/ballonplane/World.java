package com.grothetr.androidgame.ballonplane;

public class World {
	public Ball ball;
	
	public World(){
		ball = new Ball();
	}
	
	public void update(float deltaTime, float[] accel){
		ball.update(deltaTime, accel);
	}
}
