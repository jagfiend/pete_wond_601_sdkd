package com.wondworks.game;

import java.util.List;

import com.wondworks.game.framework.Game;
import com.wondworks.game.framework.Graphics;
import com.wondworks.game.framework.Screen;
import com.wondworks.game.framework.Input.TouchEvent;

public class InstructionsScreen extends Screen {

	public InstructionsScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) { 
		// update function listens for touch events on each frame...
		Graphics g = game.getGraphics();
		
		List < TouchEvent > touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		
		int len = touchEvents.size(); 
		for(int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i); 
			if(event.type == TouchEvent.TOUCH_UP) {
				
				// what to do if game screen button pressed...
				if( inBounds(event, 25, 410, 270, 50) ) { 
					game.setScreen(new MainMenuScreen(game));
					Assets.click.play(1); 
					return;
				}
			}
		}
	}
	
	private boolean inBounds(TouchEvent event, int x, int y, int width, int height) { 
		// function checks whether touch event occurred with the specified region...
		if(event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1) 
			return true;
		else 
			return false;
	}

	@Override
	public void present(float deltaTime) {
		// function draws the very basic instructions page...
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, 0, 0); 
		g.drawPixmap(Assets.instructions, 20, 20);
		g.drawPixmap(Assets.backButton, 25, 410);
	}

	// rest of class methods are empty stubs...
	public void pause() { }
	
	public void resume() { }
		
	public void dispose() { }
	
} // end of class...
