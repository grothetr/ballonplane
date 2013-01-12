package com.grothetr.androidgame.ballonplane;

import com.grothetr.androidgame.framework.Screen;
import com.grothetr.androidgame.framework.impl.AndroidGame;

public class BallGame extends AndroidGame{

	public Screen getStartScreen() {
		return new LoadingScreen(this);
	}
	
}
