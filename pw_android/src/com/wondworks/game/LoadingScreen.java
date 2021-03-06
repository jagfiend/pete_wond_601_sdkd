package com.wondworks.game;

import com.wondworks.game.framework.Game;
import com.wondworks.game.framework.Graphics;
import com.wondworks.game.framework.Graphics.PixmapFormat;
import com.wondworks.game.framework.Screen;

public class LoadingScreen extends Screen { 
	
	// this class initializes the game and load assets and settings to be used elsewhere...
	
	public LoadingScreen(Game game) {
		super(game);
	}
	
	@Override
	public void update(float deltaTime) {
		// update function loads in the image and sound assets...
		// graphical assets...
		Graphics g = game.getGraphics();
		
		// for all screens...
		Assets.background = g.newPixmap("img_background.png", PixmapFormat.RGB565);
		
		// for main menu...
		Assets.logo = g.newPixmap("img_logo.png", PixmapFormat.ARGB4444);
		Assets.mainMenu = g.newPixmap("img_mainMenu.png", PixmapFormat.ARGB4444);
		
		// for game...
		Assets.gameHUD = g.newPixmap("img_gameHUD.png", PixmapFormat.ARGB4444);
		Assets.gameBoard = g.newPixmap("img_gameBoard.png", PixmapFormat.ARGB4444);
		Assets.gameReady = g.newPixmap("img_gameReady.png", PixmapFormat.ARGB4444);
		Assets.gamePaused = g.newPixmap("img_gamePaused.png", PixmapFormat.ARGB4444);
		Assets.gameOverWinner = g.newPixmap("img_gameOverWinner.png", PixmapFormat.ARGB4444);
		Assets.gameOverLoser = g.newPixmap("img_gameOverLoser.png", PixmapFormat.ARGB4444);
		Assets.gameButtons = g.newPixmap("img_gameButtons.png", PixmapFormat.ARGB4444);
		Assets.whiteTile = g.newPixmap("img_whiteTile.png", PixmapFormat.ARGB4444);
		Assets.redTile = g.newPixmap("img_redTile.png", PixmapFormat.ARGB4444);
		Assets.blackTile = g.newPixmap("img_blackTile.png", PixmapFormat.ARGB4444);
		
		// for high scores...
		Assets.highscores = g.newPixmap("img_highscores.png", PixmapFormat.ARGB4444);
		Assets.numbers = g.newPixmap("img_numbers.png", PixmapFormat.ARGB4444);
		
		// for instructions...
		Assets.instructions = g.newPixmap("img_instructions.png", PixmapFormat.ARGB4444);
		
		// for high scores and instructions...
		Assets.backButton = g.newPixmap("img_backButton.png", PixmapFormat.ARGB4444); 
		
		// sound assets...
		Assets.click = game.getAudio().newSound("audio_click.mp3");
		Assets.gameBegins = game.getAudio().newSound("audio_gameBegins.mp3");
		Assets.gameOverLose = game.getAudio().newSound("audio_gameOverLose.mp3");
		Assets.gameOverWin = game.getAudio().newSound("audio_gameOverWin.mp3");
		Assets.tileFail = game.getAudio().newSound("audio_tileFail.mp3");
		Assets.tileSmash = game.getAudio().newSound("audio_tileSmash.mp3");
		Assets.tileSuccess = game.getAudio().newSound("audio_tileSuccess.mp3");
		
		// load high scores and call main menu screen...
		Settings.load(game.getFileIO());
		game.setScreen(new MainMenuScreen(game));
	}
	
	// rest of class methods are empty stubs...
	@Override
	public void present(float deltaTime){ }
	
	@Override
	public void pause() { }
	
	@Override
	public void resume() { }
	
	@Override
	public void dispose() { }
	
} // end of class....