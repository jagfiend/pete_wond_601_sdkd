package com.wondworks.game;

import java.util.List;

import com.wondworks.game.framework.Game;
import com.wondworks.game.framework.Graphics;
import com.wondworks.game.framework.Screen;
import com.wondworks.game.framework.Input.TouchEvent;

public class GameScreen extends Screen {

	public GameScreen(Game game) {
		super(game);
	}

	@Override
	public void present(float deltaTime) { 
	
		// load graphics....
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, 0, 0); 
		g.drawPixmap(Assets.gameHUD, 15, 10);
		g.drawPixmap(Assets.gameBoard, 11, 70);
		g.drawPixmap(Assets.gameButtons, 38, 395, 0, 0, 65, 65);
		g.drawPixmap(Assets.gameButtons, 128, 395, 128, 0, 65, 65);
		g.drawPixmap(Assets.gameButtons, 216, 395, 256, 0, 65, 65);
	
	}
	
	public void update(float deltaTime) {
		
		// update function listens for touch events on each frame...
		Graphics g = game.getGraphics();
		
		List < TouchEvent > touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		
		int len = touchEvents.size(); 
		for(int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i); 
			if(event.type == TouchEvent.TOUCH_UP) {
				
				
				// what to do if mute/unmute button pressed...
				if( inBounds(event, 38, 395, 64, 64) ) { 
					
					// update sound enabled boolean...
					
					// update button image...
					
					Assets.click.play(1); 
					return;
				}
				
				// what to do if pause/resume button pressed...
				if( inBounds(event, 128, 395, 64, 64) ) { 
					
					// update game state...
					
					// update button image...
					
					
					Assets.click.play(1); 
					return;
				}
				
				// what to do if quit game button pressed...
				if( inBounds(event, 216, 395, 64, 64) ) { 
					game.setScreen(new MainMenuScreen(game));
					Assets.click.play(1); 
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

	@Override
	public void pause() { }
	
	@Override
	public void resume() { }

	@Override
	public void dispose() { }

} // end of class...
