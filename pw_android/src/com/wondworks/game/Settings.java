package com.wondworks.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.wondworks.game.data.CreateScore;
import com.wondworks.game.data.GetScores;
import com.wondworks.game.framework.FileIO;

public class Settings {	
	// boolean controls whether sounds are played where appropriate...
	public static boolean soundEnabled = true;
	
	// this creates an integer array to be rendered on the highscore screen...
	public static int[] highscores = new int[]{10,9,8,7,6,5,4,3,2,1};

	// variable for loading scores from the database...
	public static GetScores scoresData;
	
	// variable for loading the create score load...
	public static CreateScore newScore;
	
	public static void load(FileIO files) { 
		
		// call get scores class...
		try {
			scoresData = new GetScores();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		// retrive list of scores from the database result object...
		ArrayList<HashMap<String, String>> scoresFromDatabase = scoresData.getScoresList();
	
		// loop over database result and pick out top ten scores for basic rendering exercise...
		String scoreAsString;
		int scoreAsInt;
		
		for (int i = 0; i < 10; i++) {
			// retrieve score value from the object...
			scoreAsString = scoresFromDatabase.get(i).get("player_score").toString();
			// convert string value into an integer...
			scoreAsInt = Integer.parseInt(scoreAsString);
			// replace default value...
			highscores[i] = scoreAsInt;
		}
		
		// reader and writer stuff....
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
		// ideally this function adds a score to the database and totally reloads the scores...
		// for now it updates the local array and adds to the remote database...not too shabby...

		for (int i = 0; i < 10; i++) {
			if (highscores[i] < score) { 
				for (int j = 9; j > i; j--)
					highscores[j] = highscores[j - 1];
					highscores[i] = score;
				break;
			}
		}
		
		newScore = new CreateScore(score);
	
	}	
}