package com.wondworks.game;

import com.wondworks.game.framework.Screen;
import com.wondworks.game.framework.impl.AndroidGame;

public class TheGame extends AndroidGame { 
	
	// this class extends the AndroidGame class from the framework...
	public Screen getStartScreen() {
		return new LoadingScreen(this); 
	}
}