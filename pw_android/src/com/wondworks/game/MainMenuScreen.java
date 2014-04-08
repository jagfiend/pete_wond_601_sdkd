package com.wondworks.game;

import java.util.List;

import com.wondworks.game.framework.Game;
import com.wondworks.game.framework.Graphics;
import com.wondworks.game.framework.Input.TouchEvent;
import com.wondworks.game.framework.Screen;

public class MainMenuScreen extends Screen {

	public MainMenuScreen(Game game) {
		super(game);
	}
	
	@Override
	public void present(float deltaTime) { 
		// load graphics....
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, 0, 0); 
		g.drawPixmap(Assets.logo, 20, 20); 
		g.drawPixmap(Assets.mainMenu, 20, 290);
	}
	
	public void update(float deltaTime) {
		// update function listens for touch events on each frame...
		List < TouchEvent > touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		
		int len = touchEvents.size(); 
		for(int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i); 
			if(event.type == TouchEvent.TOUCH_UP) {
				
				// what to do if game screen button pressed...
				if( inBounds(event, 20, 290, 270, 50) ) { 
					game.setScreen(new GameScreen(game));
					if(Settings.soundEnabled) Assets.click.play(1); 
					return;
				}
				
				// what to do if game screen button pressed...
				// note addition to y coordinate to factor in button and margin above...
				if( inBounds(event, 20, 290 + 60, 270, 50) ) {
					game.setScreen(new HighscoreScreen(game));
					if(Settings.soundEnabled) Assets.click.play(1); 
					return;
				}
				
				// what to do if game screen button pressed...
				// note addition to y coordinate to factor in 2x button and margin above...
				if( inBounds(event, 20, 290 + 120, 270, 50) ) {
					game.setScreen(new InstructionsScreen(game)); 
					if(Settings.soundEnabled) Assets.click.play(1); 
					return;
				} 
			} // end of TOUCH_UP if....
		} // end of for...
	} // end of function...
	
	private boolean inBounds(TouchEvent event, int x, int y, int width, int height) { 
		// function checks whether touch event occurred with the specified region...
		if(event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1) 
			return true;
		else 
			return false;
	}

	// rest of class methods are empty stubs...
	@Override
	public void pause() { }
	
	@Override
	public void resume() { }

	@Override
	public void dispose() { 
		
	}
} // end of class