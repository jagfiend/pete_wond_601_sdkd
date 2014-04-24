package com.wondworks.game.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class CreateScore {

	JSONParser jsonParser = new JSONParser();

	// player values to be added to database...
	String playerName ="Pete Wond";
	String playerScore;
	String playerLocale = "UK";

	// url to create new score...
	// NOTE: REMEMBER TO CHANGE TO CURRENT IP AND CONNECT DEVICE TO SAME WIFI FOR LOCAL TESTING!!!
	private static String url_create_product = "http://10.44.68.64:8888/pw_php/data/create_score.php";

	// JSON Node names...
	private static final String TAG_SUCCESS = "success";

	public CreateScore(int score) {
	
			// convert score into string...
			playerScore = Integer.toString(score);
			
			// creating new score in background thread...
			new CreateNewScore().execute();
	
	}

	/* Background Async Task to create new score in database */
	class CreateNewScore extends AsyncTask<String, String, String> {

		/* Creating score */
		protected String doInBackground(String... args) {
			
			String player_name = playerName;
			String player_score = playerScore;
			String player_locale = playerLocale;

			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("player_name", player_name));
			params.add(new BasicNameValuePair("player_score", player_score));
			params.add(new BasicNameValuePair("player_locale", player_locale));

			// getting JSON Object
			// Note that create product url accepts POST method
			JSONObject json = jsonParser.makeHttpRequest(url_create_product, "POST", params);
			
			// check log cat for response
			Log.d("Create Response", json.toString());

			// check for success tag
			try {
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					// succeeded to create score...
					Log.i("Create Score:", "Success");
				} else {
					// failed to create score...
					Log.i("Create Score", "Fail");
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}
	}
}