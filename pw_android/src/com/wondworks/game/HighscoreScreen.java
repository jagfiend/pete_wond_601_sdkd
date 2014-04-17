package com.wondworks.game;

import java.util.List;

import com.wondworks.game.framework.Game;
import com.wondworks.game.framework.Graphics;
import com.wondworks.game.framework.Screen;
import com.wondworks.game.framework.Input.TouchEvent;

public class HighscoreScreen extends Screen {

	
	String lines[] = new String[10];
	
	
	public HighscoreScreen(Game game) {
		super(game);
		
		for ( int i=0; i < 10; i++) {
			lines[i] = "" + (i+1) + " " + Settings.highscores[i] ;
		}
		
	}

	@Override
	public void update(float deltaTime) { 
		// update function listens for touch events on each frame...
		List < TouchEvent > touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		
		int len = touchEvents.size(); 
		for(int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i); 
			if(event.type == TouchEvent.TOUCH_UP) {
				
				// what to do if game screen button pressed...
				if( inBounds(event, 25, 410, 270, 50) ) { 
					game.setScreen(new MainMenuScreen(game));
					if(Settings.soundEnabled) Assets.click.play(1);
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
		
		// function draws the very high scores page...
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, 0, 0); 
		g.drawPixmap(Assets.highscores, 20, 20);
		
		// dynamic text from high scores array....
		int y = 75;
		
		for (int i=0; i<10; i++){
			
			drawText(g, lines[i], 16, y);
			y += 33;
		
		}
		
		g.drawPixmap(Assets.backButton, 25, 410);
	}

	public void drawText(Graphics g, String line, int x, int y) { 
		
		int len = line.length();
		
		for (int i = 0; i < len; i++) {
			
			char character = line.charAt(i);
			
			int srcX = 0;
			int srcWidth = 0;
			
			if (character == ' ') { 
				x += 16;
				continue; 
			} else {
				srcX = (character - '0') * 16;
				srcWidth = 16;
			}
			
			g.drawPixmap(Assets.numbers, x, y, srcX, 0, srcWidth, 30);
		    x += srcWidth;
		    
		} // end of for loop...
	}
	
	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}
}
