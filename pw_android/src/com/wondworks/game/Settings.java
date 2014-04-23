package com.wondworks.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.wondworks.game.framework.FileIO;

public class Settings {	
	// boolean controls whether sounds are played where appropriate...
	public static boolean soundEnabled = true;
	
	// this creates a basic highscore array to be used if no connection can be made to the database...
	public static int[] highscores = new int[] { 1120, 1110, 1100, 190, 180, 170, 165, 160, 155, 150 };
	
	// the class then attempts to retrieve the high scores and the replace the default values with these...
	public static GetScores scoresData;
	
	public static void load(FileIO files) { 
	
		System.out.println("Settings: Loading!!");
	
		scoresData = new GetScores();
		
		BufferedReader in = null;
		
		try {
			
			in = new BufferedReader( new InputStreamReader( files.readFile(".game") ));
			
			soundEnabled = Boolean.parseBoolean(in.readLine()); 
			
			for (int i = 0; i < 10; i++) {
				highscores[i] = Integer.parseInt(in.readLine()); 
			}
			
		} catch (IOException e) { 
		// :( It's ok we have defaults.. 
		} catch (NumberFormatException e) {
		// :/ It's ok, defaults save our day...
		} finally { 
			try {
				if (in != null) in.close();
			} catch (IOException e) {
				// catch exception...
			} 
		}
		
	}
	
	public static void save(FileIO files) { 
		
		BufferedWriter out = null;
		try {
			out = new BufferedWriter( new OutputStreamWriter( files.writeFile(".game") ));
			out.write(Boolean.toString(soundEnabled)); 
			for (int i = 0; i < 10; i++) {
				out.write(Integer.toString(highscores[i])); 
			}
		} catch (IOException e) { 
			
		} finally {
			try {
				if (out != null) out.close();
			} catch (IOException e) { }
		}
		
	}

	public static void addScore(int score) {
		
		for (int i = 0; i < 10; i++) {
			if (highscores[i] < score) { 
				for (int j = 9; j > i; j--)
					highscores[j] = highscores[j - 1];
					highscores[i] = score;
				break;
			}
		}
	
	}	
}