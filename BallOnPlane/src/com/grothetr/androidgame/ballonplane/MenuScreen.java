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
	final int PLUSX_GRAV = 480 - 96;
	final int PLUSY_GRAV = 800-96;
	final int MINUSX_GRAV = 0;
	final int MINUSY_GRAV = 800-96;
	final int PLUSX_NRGSAVED = 480-96;
	final int PLUSY_NRGSAVED = 650-96;
	final int MINUSX_NRGSAVED = 0;
	final int MINUSY_NRGSAVED = 650-96;
	
	
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
				
				//adding gravity
				if (inBounds(event, MINUSX_GRAV, MINUSY_GRAV, 96, 96)){
					
					Settings.gravity = Settings.gravity - .1f;
					
				}
				if (inBounds(event, PLUSX_GRAV, PLUSY_GRAV, 96, 96)){
					Settings.gravity = Settings.gravity + .1f;
				}
				
				//adding nrg saved when bounce
				if (inBounds(event, MINUSX_NRGSAVED, MINUSY_NRGSAVED, 96, 96)){
					Settings.nrgSaved = Settings.nrgSaved - .05f;
				}
				if (inBounds(event, PLUSX_NRGSAVED, PLUSY_NRGSAVED, 96, 96)){
					Settings.nrgSaved = Settings.nrgSaved + .05f;
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
		
		//accel of grav select
		g.drawPixmap(Assets.minus, MINUSX_GRAV, MINUSY_GRAV);
		g.drawPixmap(Assets.plus, PLUSX_GRAV, PLUSY_GRAV);
		g.drawText(Float.toString(Settings.gravity), 140, 750, Color.BLACK, Assets.font, 40);
		g.drawText("Acceleration of Gravity Multiplier", 20, 700, Color.BLACK, Assets.font, 20);
		
		//nrgloss when bounce select
		g.drawPixmap(Assets.minus, MINUSX_NRGSAVED, MINUSY_NRGSAVED);
		g.drawPixmap(Assets.plus, PLUSX_NRGSAVED, PLUSY_NRGSAVED);
		g.drawText(Float.toString(Settings.nrgSaved), 140, 600, Color.BLACK, Assets.font, 40);
		g.drawText("Percent Velocity Saved When Bouncing Multiplier", 20, 550, Color.BLACK, Assets.font, 15);
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
