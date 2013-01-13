package com.grothetr.androidgame.ballonplane;

import java.util.List;

import android.graphics.Color;

import com.grothetr.androidgame.framework.Game;
import com.grothetr.androidgame.framework.Graphics;
import com.grothetr.androidgame.framework.Input.TouchEvent;
import com.grothetr.androidgame.framework.Screen;

public class MenuScreen extends Screen{

	final int START_TEXT_X = 140;
	final int START_TEXT_Y = 100;
	final int PLUSX = 480 - 96;
	final int PLUSY = 800-96;
	final int MINUSX = 0;
	final int MINUSY = 800-96;
	
	
	
	public MenuScreen(Game game) {
		super(game);
		
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		
		int len = touchEvents.size();
		for (int i = 0; i < len; i++){
			TouchEvent event = touchEvents.get(i);
			
			if (event.type == TouchEvent.TOUCH_UP){
				if (inBounds(event, START_TEXT_X, START_TEXT_Y, 200,96 )){
					game.setScreen(new GameScreen(game));
				}
				
				if (inBounds(event, MINUSX, MINUSY, 96, 96)){
					if (Settings.mass > 0)
						Settings.mass = Settings.mass - .1f;
					else Settings.mass = 0;
				}
				if (inBounds(event, PLUSX, PLUSY, 96, 96)){
					Settings.mass = Settings.mass + .1f;
				}
			}
		}
	}

	public boolean inBounds(TouchEvent event, int x, int y, int width, int height){
		if (event.x > x && event.x < x + width -1 &&
				event.y > y && event.y < y + height - 1)
			return true;
		else
			return false;
	}
	
	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.white, 0, 0);
		g.drawPixmap(Assets.start, START_TEXT_X, START_TEXT_Y);
		g.drawPixmap(Assets.minus, MINUSX, MINUSY);
		g.drawPixmap(Assets.plus, PLUSX, PLUSY);
		g.drawText(Float.toString(Settings.mass), 240, 750, Color.BLACK, Assets.font, 40);
		g.drawText("change the mass of the ball", 20, 680, Color.BLACK, Assets.font, 20);
		
		
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

}
