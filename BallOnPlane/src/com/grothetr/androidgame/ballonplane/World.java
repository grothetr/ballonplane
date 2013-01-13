package com.grothetr.androidgame.ballonplane;

public class World {
	public Ball ball;
	public Ball ball2;
	public World(){
		ball = new Ball(200, 300);
		
	}
	
	public void update(float deltaTime, float[] accel){
		ball.update(deltaTime, accel);
		
	}
}
