package com.grothetr.androidgame.ballonplane;

import android.graphics.Color;
import android.util.Log;

import com.grothetr.androidgame.framework.Game;
import com.grothetr.androidgame.framework.Graphics;
import com.grothetr.androidgame.framework.Input;
import com.grothetr.androidgame.framework.Pixmap;
import com.grothetr.androidgame.framework.Screen;
import com.grothetr.androidgame.framework.impl.AccelerometerHandler;
import com.grothetr.androidgame.framework.impl.AndroidInput;

public class GameScreen extends Screen{

	World world;
	
	public GameScreen(Game game) {
		super(game);
		world = new World();
	}

	@Override
	public void update(float deltaTime) {
		Input in = game.getInput();
		float[] accel = new float[2];
		accel[0] =  in.getAccelX();
		accel[1] =  in.getAccelY();
		
		world.update(deltaTime, accel);
	}
	
	private void showAccel(float deltaTime) {
		Input in = game.getInput();
		Graphics g = game.getGraphics();	
		
		
		
		
		
	}

	@Override
	public void present(float deltaTime) {
		
		
		
		drawWorld(world);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	private void drawWorld(World world){
		
		
		
		Graphics g = game.getGraphics();
		
		g.drawPixmap(Assets.white, 0, 0);
		Ball ball = world.ball;
		
		Pixmap ballPixmap = Assets.ball;
		g.drawPixmap(ballPixmap, (int)ball.x, (int)ball.y);
		
		
		//show motion info
		
		Input in = game.getInput();
		g.drawText("x acceleration: " + Float.toString(-1 * in.getAccelX()), 10, 50, Color.BLACK, Assets.font);
		g.drawText("y acceleration: " + Float.toString(in.getAccelY()), 10, 100, Color.BLACK, Assets.font);
		g.drawText("x velocity: " + Float.toString(-1*ball.vx), 10, 150, Color.BLACK, Assets.font);
		g.drawText("y velocity: " + Float.toString(ball.vy), 10, 200, Color.BLACK, Assets.font);
		g.drawText("x pos: " + Float.toString(ball.x), 10, 250, Color.BLACK, Assets.font);
		g.drawText("y pos: " + Float.toString(ball.y), 10, 300, Color.BLACK, Assets.font);
		
		
	}

}
