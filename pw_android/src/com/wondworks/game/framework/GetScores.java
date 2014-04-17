package com.wondworks.game.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class GetScores {

	// Creating JSON Parser object
	JSONParser jParser = new JSONParser();

	ArrayList< HashMap <String, String> > scoresList;

	// url to get all scores...
	// NOTE: HAVE TO CHANGE TO CURRENT IP AND CONNECT DEVICE TO SAME WIFI FOR LOCAL TESTING!!!
	private static String url_all_scores = "http://10.44.68.139:8888/pw_php/data/get_all_scores.php";

	// JSON Node names
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_SCORES = "scores";
	private static final String TAG_SID = "	id";
	private static final String TAG_PLAYER_NAME = "player_name";
	private static final String TAG_PLAYER_SCORE = "player_score";
	private static final String TAG_PLAYER_LOCALE = "player_locale";

	private static final String TAG_GET = "GetScores: ";
	
	// scores JSONArray
	JSONArray scores = null;

	public GetScores() {
		// check to see if constructor called...
		Log.i(TAG_GET, "called");
		// Hashmap for ListView
		scoresList = new ArrayList< HashMap <String, String> >();
		// Loading scores in Background Thread
		new LoadAllScores().execute();
	}

	/**
	 * Background Async Task to Load all product by making HTTP Request
	 * */
	class LoadAllScores extends AsyncTask<String, String, String> {

		/**
		 * getting All scores from url...
		 * */
		@Override
		protected String doInBackground(String... args) {
			// Building Parameters
			List <NameValuePair> params = new ArrayList<NameValuePair>();
			// getting JSON string from URL
			JSONObject json = jParser.makeHttpRequest(url_all_scores, "GET", params);
			
			// Check your log cat for JSON response
			Log.d("All Scores: ", json.toString());

			try {
				// Checking for SUCCESS TAG
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1){
					// scores found
					// Getting Array of scores
					scores = json.getJSONArray(TAG_SCORES);

					// looping through All scores
					for (int i = 0; i < scores.length(); i++) {
						
						JSONObject c = scores.getJSONObject(i);

						// Storing each json item in variable
						String id = c.getString(TAG_SID);
						String player_name = c.getString(TAG_PLAYER_NAME);
						String player_score = c.getString(TAG_PLAYER_SCORE);
						String player_locale = c.getString(TAG_PLAYER_LOCALE);

						// creating new HashMap
						HashMap<String, String> map = new HashMap<String, String>();

						// adding each child node to HashMap key => value
						map.put(TAG_SID, id);
						map.put(TAG_PLAYER_NAME, player_name);
						map.put(TAG_PLAYER_SCORE, player_score);
						map.put(TAG_PLAYER_LOCALE, player_locale);

						// adding HashList to ArrayList
						scoresList.add(map);
						
					}
				} 
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;
		}		
	}
}