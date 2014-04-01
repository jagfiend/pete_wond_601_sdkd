package com.wondworks.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.util.Log;

public class World {

	static final int WORLD_WIDTH = 5;
	static final int WORLD_HEIGHT = 5;
	static final int SCORE_INCREMENT = 1;
	static final float TICK_INITIAL = 0.5f;
	
	public Tile tile;
	public List < Tile > tiles = new ArrayList < Tile > ();
	
	public int[] startX = new int[]{ 11, 71, 129, 188, 247 };
	public int startY = 70;
	
	public boolean gameOver = false; 
	public int score = 0;
	
	boolean fields[][] = new boolean[WORLD_WIDTH][WORLD_HEIGHT];
	Random random = new Random();
	
	float tickTime = 0;
	float tick = TICK_INITIAL;
	
	public World(){
		// empty constructor...
	}
	
	public void addTile(){
		
		// set x, y and type...
		int indexX = random.nextInt(5);
		int tileX = startX[indexX];
		int tileY = startY;
		int tileType = random.nextInt(3); 
		
		// instantiate tile object...
		tile = new Tile(tileX, tileY, tileType);
		
		// add new tile into the tiles array...		
		tiles.add(tile);
		
	}
		
	public void update(float deltaTime){
		
		// check game state and move tiles as necessary...
		if (gameOver) return;
		
		// increment time...
		tickTime += deltaTime;
		
		int roundedTime = Math.round(tickTime * 100);
		
		Log.i("Time", "" + roundedTime );
		Log.i("Tiles", "" + tiles);
		
		// add new tile every "second"...
		if(roundedTime % 100 == 0){
			addTile();
		}
		
		// loop over tiles array...
		int len = tiles.size();
		for(Tile tile : tiles){
			
			// remove tiles that have hit the bottom of the grid...
			if(tile.y > 300){
				tiles.remove(tile);
				if (Settings.soundEnabled) Assets.tileSmash.play(1);
				return;
			} else {
				// move the rest down a square...
				tile.move();
			}
		
		}
			
	} // end of update function...
	
} // end of class...
