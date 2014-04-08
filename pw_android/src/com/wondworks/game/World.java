package com.wondworks.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {

	// score and time variables...
	static final int SCORE_INCREMENT = 1;
	static final int SCORE_DECREMENT = 5;
	static final int TIME_DECREMENT = 5;
	float tickTime = 0;
	float tick = 1; 
	public int score = 100;
	public int time = 60;
	
	// tile variables & array...
	public Tile tile;
	public List < Tile > tiles = new ArrayList < Tile > ();
	public int[] startX = new int[]{ 11, 71, 129, 188, 247 };
	public int startY = 70;
	
	// gamestate variables & random number generator...
	public boolean gameOver = false;
	public boolean winner = false;
	Random random = new Random();
	
	public World(){
		// empty constructor...
	}
	
	public void update(float deltaTime){
		
		// change game state if time or score hit zero...
		if (time <= 0 || score <= 0){
			gameOver = true;
			// actions to take when game over...
			// check scores to determine if high score achieved...
			if(score > Settings.highscores[Settings.highscores.length-1]){
				winner = true;
				if(Settings.soundEnabled) Assets.gameOverWin.play(1);
			} else {
				if(Settings.soundEnabled) Assets.gameOverLose.play(1);
			}
			return;
		}
			
		// increment tickTime...
		tickTime += deltaTime;
	
		while(tickTime > 0.5){
			tickTime -= tick;
			// add tiles every half second and update time...
			addTile();
			time -= 0.5;
		}
		
		// loop over tiles array...
		for(Tile tile : tiles){
			if(tile.y % 60 == 0){
				// change tile color...
				tile.type = random.nextInt(3); 
			}
			if(tile.y >= 305){
				// remove tiles that have hit the bottom of the grid...
				tiles.remove(tile);
				if (Settings.soundEnabled) Assets.tileSmash.play(1);
				return;
			} else {
				// move the rest down a square...
				tile.move();
			}
		} // end of tile loop...
		
	} // end of update function...
	
	public void addTile(){
		//function to add a tile into the world...
		// set x, y and type...
		// choose a random column...
		int indexX = random.nextInt(5);
		// assign column x position from array...
		int tileX = startX[indexX];
		// assign y from variable...
		int tileY = startY;
		// assign random type...
		int tileType = random.nextInt(3); 
		
		// instantiate tile object...
		tile = new Tile(tileX, tileY, tileType);
		
		// add new tile into the tiles array...		
		tiles.add(tile);
	}
	
} // end of class...
