package com.wondworks.game;

import java.util.List;

import com.wondworks.game.framework.Game;
import com.wondworks.game.framework.Graphics;
import com.wondworks.game.framework.Input.TouchEvent;
import com.wondworks.game.framework.Pixmap;
import com.wondworks.game.framework.Screen;

public class GameScreen extends Screen {

	enum GameState {
		Ready, Running, Paused, GameOver
	}
	
	GameState state = GameState.Ready; 
	
	public GameScreen(Game game) {
		super(game);
	}

	@Override
	public void present(float deltaTime) { 
		// load graphics....
		Graphics g = game.getGraphics();
		// draw static elements
		g.drawPixmap(Assets.background, 0, 0); 
		g.drawPixmap(Assets.gameHUD, 15, 10);
		g.drawPixmap(Assets.gameBoard, 11, 70);
		
		if(state == GameState.Ready) drawReadyUI();
		if(state == GameState.Running) drawRunningUI();
		if(state == GameState.Paused) drawPausedUI();
		if(state == GameState.GameOver) drawGameOverUI();
		
		// show appropriate sound button...
		if (Settings.soundEnabled){
			g.drawPixmap(Assets.gameButtons, 38, 395, 0, 0, 65, 65);
		} else {
			g.drawPixmap(Assets.gameButtons, 38, 395, 64, 0, 65, 65);
		}
		
		// draw quit button...
		g.drawPixmap(Assets.gameButtons, 216, 395, 256, 0, 65, 65);
	
	}
	
	private void drawReadyUI() {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.gameReady, 11, 70);
		// show nonfunctional pause button...
		g.drawPixmap(Assets.gameButtons, 128, 395, 128, 0, 65, 65);
	}
	
	private void drawRunningUI() {
		Graphics g = game.getGraphics();
		// show pause button...
		g.drawPixmap(Assets.gameButtons, 128, 395, 128, 0, 65, 65);
	}
	
	private void drawPausedUI() {
		Graphics g = game.getGraphics();
		// show game paused overlay...
		g.drawPixmap(Assets.gamePaused, 11, 70);
		// show resume button...
		g.drawPixmap(Assets.gameButtons, 128, 395, 192, 0, 65, 65);
	}

	private void drawGameOverUI() {
		// TODO Auto-generated method stub
		
	}

	public void update(float deltaTime) {
		// update function listens for touch events on each frame...
		List < TouchEvent > touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        
        // call state dependent functions...
		if(state == GameState.Ready) updateReady(touchEvents);
		if(state == GameState.Running) updateRunning(touchEvents,deltaTime);
		if(state == GameState.Paused) updatePaused(touchEvents);
		if(state == GameState.GameOver) updateGameOver(touchEvents);
		
		int len = touchEvents.size(); 
		for(int i = 0; i < len; i++) {
			
			TouchEvent event = touchEvents.get(i); 
			
			if(event.type == TouchEvent.TOUCH_UP) {
				// what to do if sound button pressed...
				if( inBounds(event, 38, 395, 64, 64) ) { 
					// update sound enabled boolean...
					Settings.soundEnabled = !Settings.soundEnabled;
					// make a noise?
					if (Settings.soundEnabled) Assets.click.play(1); 
					return;
				}
				
				// what to do if quit game button pressed...
				if( inBounds(event, 216, 395, 64, 64) ) {
					// call main menu...
					game.setScreen(new MainMenuScreen(game));
					// make a noise?
					if (Settings.soundEnabled) Assets.click.play(1);
					return;
				}
			} // end of TOUCH_UP if....
		} // end of for...
	} // end of function...
	
	private void updateReady(List < TouchEvent > touchEvents) { 
		
		int len = touchEvents.size(); 
		for(int i = 0; i < len; i++) {
			
			TouchEvent event = touchEvents.get(i); 
			
			if(event.type == TouchEvent.TOUCH_UP) {	
				if( inBounds(event, 11, 70, 296, 296) ){
					state = GameState.Running;
					if (Settings.soundEnabled) Assets.click.play(1);
				}
				return;
			}
		}	
	}
	
	private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
	
		int len = touchEvents.size(); 
		for(int i = 0; i < len; i++) {
			
			TouchEvent event = touchEvents.get(i); 
			
			if(event.type == TouchEvent.TOUCH_UP) {	
				// what to do if pause/resume button pressed...
				if( inBounds(event, 128, 395, 64, 64) ) { 
					// update game state...
					state = GameState.Paused;
					// make a noise?
					if (Settings.soundEnabled) Assets.click.play(1);
					return;
				}		
			}
		}
	}
	
	private void updateGameOver(List<TouchEvent> touchEvents) {
		// TODO Auto-generated method stub
		
	}

	private void updatePaused(List<TouchEvent> touchEvents) {
		
		int len = touchEvents.size(); 
		for(int i = 0; i < len; i++) {
			
			TouchEvent event = touchEvents.get(i); 
			
			if(event.type == TouchEvent.TOUCH_UP) {	
				// what to do resume button pressed...
				if( inBounds(event, 128, 395, 64, 64) ) { 
					// update game state...
					state = GameState.Running;
					// make a noise?
					if (Settings.soundEnabled){
						Assets.click.play(1); 
					}
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
	public void pause() {
		if(state == GameState.Running) state = GameState.Paused;
	}
	
	@Override
	public void resume() { }

	@Override
	public void dispose() { }

} // end of class...