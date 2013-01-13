package com.grothetr.androidgame.ballonplane;

import java.util.List;

import android.graphics.Color;
import android.util.Log;

import com.grothetr.androidgame.framework.Game;
import com.grothetr.androidgame.framework.Graphics;
import com.grothetr.androidgame.framework.Input;
import com.grothetr.androidgame.framework.Input.TouchEvent;
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
		
		List<TouchEvent> touchEvents = in.getTouchEvents();
		for (int i = 0; i < touchEvents.size(); i++){
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP){
				if (event.x > 0 && event.x < 100
						&& event.y > 750 && event.y < 800)
					game.setScreen(new MenuScreen(game));
			}
		}
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
		
		g.drawPixmap(Assets.back, 0, 750);
		
		//show motion info
		
		Input in = game.getInput();
		g.drawText("x acceleration: " + Float.toString(-1 * in.getAccelX()), 10, 50, Color.BLACK, Assets.font, 20);
		g.drawText("y acceleration: " + Float.toString(in.getAccelY()), 10, 100, Color.BLACK, Assets.font, 20);
		g.drawText("x velocity: " + Float.toString(-1*ball.vx), 10, 150, Color.BLACK, Assets.font, 20);
		g.drawText("y velocity: " + Float.toString(ball.vy), 10, 200, Color.BLACK, Assets.font, 20);
		g.drawText("x pos: " + Float.toString(ball.x), 10, 250, Color.BLACK, Assets.font, 20);
		g.drawText("y pos: " + Float.toString(ball.y), 10, 300, Color.BLACK, Assets.font, 20);
		g.drawText("acceleration of gravity: " + Float.toString(Settings.gravity), 10, 350, Color.BLACK, Assets.font, 15);
		
		
	}

}
