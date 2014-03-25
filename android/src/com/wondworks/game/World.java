package com.wondworks.game;

import java.util.Random;

public class World {

	static final int WORLD_WIDTH = 5;
	static final int WORLD_HEIGHT = 5;
	static final int SCORE_INCREMENT = 1;
	static final float TICK_INITIAL = 0.5f;
	
	public Tile tile;
	public boolean gameOver = false;
	public int score = 100;
	
	boolean fields[][] = new boolean[WORLD_WIDTH][WORLD_HEIGHT]; 
	Random random = new Random();
	float tickTime = 0;
	float tick = TICK_INITIAL;;
	
	public World(){
	
		placeTile();
	
	}
	
	public void placeTile(){
		
		int tileX = random.nextInt(WORLD_WIDTH);
		int tileY = random.nextInt(WORLD_HEIGHT);
		int tileType = 0; 
		
		tile = new Tile(tileX, tileY, tileType);
		
	}
	
	public void update(float deltaTime){
		
		// check game state and move tiles as necessary...
		
		if (gameOver) return;
		
		tickTime += deltaTime;
		
		
	}
	
} // end of class...
