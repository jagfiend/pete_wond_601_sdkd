package com.wondworks.game;

public class Tile {

	// class for attributes of game tiles...
	
	public static final int TYPE_0 = 0; // for white...
	public static final int TYPE_1 = 1; // for red...
	public static final int TYPE_2 = 2; // for black...
	public int x, y;
	public int type;
	
	public Tile(int x, int y, int type){
	
		// constructor...
		
		this.x = x;
		this.y = y;
		this.type = type;
		
	}
	
	public void move(){
		
		// function to move tile further down the grid...
		
		y += 2;
		
	}
	
} // end of class...