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
	World world;
	int gameTime = 60;
	String timeString = "60";
	int gameScore = 100;
	String scoreString = "100";
	boolean saved = false;
		
	public GameScreen(Game game) {
		super(game);
		world = new World();
	}
	
	// update functions...
	
	@Override
	public void update(float deltaTime) {
		// update function listens for touch events on each frame...
		List < TouchEvent > touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        
        int len = touchEvents.size(); 
		for(int i = 0; i < len; i++) {
			
			TouchEvent event = touchEvents.get(i); 
			
			if(event.type == TouchEvent.TOUCH_UP) {
				// what to do if sound button pressed...
				if( inBounds(event, 38, 395, 64, 64) ) { 
					// invert sound enabled boolean...
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
        
        // call state dependent functions...
		if(state == GameState.Ready){
			updateReady(touchEvents); 
			return;
		}
		if(state == GameState.Running){
			updateRunning(touchEvents,deltaTime); 
			return;
		}
		if(state == GameState.Paused){
			updatePaused(touchEvents); 
			return;
		}
		if(state == GameState.GameOver){
			updateGameOver(touchEvents); 
			return;
		}
	} // end of function...
	
	private void updateReady(List < TouchEvent > touchEvents) { 
		
		int len = touchEvents.size(); 
		for(int i = 0; i < len; i++) {
			
			TouchEvent event = touchEvents.get(i); 
			
			if(event.type == TouchEvent.TOUCH_UP) {
				// what to do if ready screen touched...
				if( inBounds(event, 11, 70, 296, 296) ){
					// update game state...
					state = GameState.Running;
					// make a noise?
					if (Settings.soundEnabled) Assets.click.play(1);
					return;
				}
			}
		}	
	}
	
	private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
	
		List < Tile > tiles = world.tiles;
		
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
			
				// loop over array to know what to do if tile pressed....
				for(Tile tile : tiles){
					if( inBounds(event, tile.x, tile.y, 50, 50) ){
				
						// if white... 
						if(tile.type == 0){
							world.score += World.SCORE_INCREMENT;
							// make a noise?
							if(Settings.soundEnabled) Assets.tileSuccess.play(1);
						}
							
						// if red...
						if(tile.type == 1){
							world.score -= World.SCORE_DECREMENT;
							// make a noise?
							if(Settings.soundEnabled) Assets.tileSmash.play(1);
						}
						
						// if black...
						if(tile.type == 2){
							world.time -= World.TIME_DECREMENT;
							// make a noise?
							if(Settings.soundEnabled) Assets.tileFail.play(1);
						}
						
						// remove from tiles array...
						tiles.remove(tile);
						return;
					}
				}
			}
		}
		
		// run updates on world...
		world.update(deltaTime); 
		
		// to do if game over...
		if(world.gameOver){
			state = GameState.GameOver; 
			return;
		}
		
		// update time...
		if(gameTime != world.time){
			// checks to see if the game time is different world time (updated in world)
			// if so, matches them and updates the string...
			gameTime = world.time;
			timeString = "" + gameTime;
		}
		
		// update score...
		if(gameScore != world.score) { 
			// checks to see if the game score is different world score (updated above)
			// if so, matches them and updates the string...
			gameScore = world.score; 
			scoreString = "" + gameScore; 
		}
	}
	
	private void updateGameOver(List<TouchEvent> touchEvents) {
		
		// if winner add score to array...
		if(world.winner && saved == false){
			saveScore();
		}
		
		int len = touchEvents.size(); 
		for(int i = 0; i < len; i++) {
			
			TouchEvent event = touchEvents.get(i); 
			
			if(event.type == TouchEvent.TOUCH_UP) {
				// what to do if gameover screen touched...
				if( inBounds(event, 11, 70, 296, 296) ){
					// restart game by reloading...
					game.setScreen(new GameScreen(game));
					if(Settings.soundEnabled) Assets.click.play(1); 
					return;
				}
			}
		}	
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
					if (Settings.soundEnabled) Assets.click.play(1);
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
	
	// present functions render the graphics to the screen...

	@Override
	public void present(float deltaTime) { 
		// load graphics....
		Graphics g = game.getGraphics();
		// draw static elements
		g.drawPixmap(Assets.background, 0, 0); 
		g.drawPixmap(Assets.gameHUD, 15, 10);
		g.drawPixmap(Assets.gameBoard, 11, 70);
		
		// call draw world method...
		drawWorld();
		
		// call dynamic elements dependent on gameState...
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
	
	private void drawWorld() {
		// function to render dynamic world elements...
		Graphics g = game.getGraphics();
		
		// render score and time....
		drawText(g, timeString, 90, 26);
		drawText(g, scoreString, 200, 26);
		
		// render tiles...
		List < Tile > tiles = world.tiles;
		
		// for each loop renders each tile in the array in turn...
		for(Tile tile : tiles){

			// clear previous pixmap...
			Pixmap tilePixmap = null;
			
			// set type...
			if(tile.type == Tile.TYPE_0) tilePixmap = Assets.whiteTile;
			if(tile.type == Tile.TYPE_1) tilePixmap = Assets.redTile;
			if(tile.type == Tile.TYPE_2) tilePixmap = Assets.blackTile;
			
			// set x and y...
			int x = tile.x;
			int y = tile.y;
			
			// draw as appropriate...
			g.drawPixmap(tilePixmap, x, y);
			
		}	
	} // end of drawWorld function...
	
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
		
		Graphics g = game.getGraphics();
		
		// show game over overlay appropriate to win / lose...
		if(world.winner){
			// win...
			g.drawPixmap(Assets.gameOverWinner, 11, 70);
		} else {
			// lose...
			g.drawPixmap(Assets.gameOverLoser, 11, 70);
		}
		
		// show nonfunctional pause button...
		g.drawPixmap(Assets.gameButtons, 128, 395, 128, 0, 65, 65);
		
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
	
	public void saveScore(){
		Settings.addScore(world.score); 
		Settings.save(game.getFileIO());
		saved = true;
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