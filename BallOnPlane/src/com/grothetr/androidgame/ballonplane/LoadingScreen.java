package com.grothetr.androidgame.ballonplane;

import android.graphics.Typeface;
import android.content.res.AssetManager;

import com.grothetr.androidgame.framework.FileIO;
import com.grothetr.androidgame.framework.Game;
import com.grothetr.androidgame.framework.Graphics;
import com.grothetr.androidgame.framework.Graphics.PixmapFormat;
import com.grothetr.androidgame.framework.Screen;


public class LoadingScreen extends Screen {

	public LoadingScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		
		Assets.white = g.newPixmap("white.png", PixmapFormat.RGB565);
		Assets.font = Typeface.MONOSPACE;
		Assets.ball = g.newPixmap("ball.png", PixmapFormat.ARGB4444);
		
		game.setScreen(new GameScreen(game));
	}

	@Override
	public void present(float deltaTime) {
		// TODO Auto-generated method stub

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
