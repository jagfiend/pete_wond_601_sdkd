<?php // CRUD file...

function createScore(){

	// connect to the database...
	$connection = mysqli_connect("localhost", "root", "root", "db_601");

	if (mysqli_connect_errno($connection))
	{
	   echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}

	// TO DO: set variables from POST and wrap in conditional...
	$name = $_POST['player_name'];
	$score = $_POST['player_score'];

	// mysql inserting a new row...
    $result = mysqli_query($connection, "INSERT INTO high_scores(
    			player_name, 
    			player_score,
    			created_at) 
    		VALUES(
    			'$name', 
    			'$score',
    			NOW())"
    		);

    // array for JSON response...
	$response = array();

	// check if row inserted or not...
    if ($result) {
        
        // successfully inserted into database...
        $response["success"] = 1;
        $response["message"] = "New high score successfully created.";
 
        // echoing JSON response...
        echo json_encode($response);

    } else {
        
        // failed to insert row...
        $response["success"] = 0;
        $response["message"] = "Oops! An error occurred.";
 
        // echoing JSON response...
        echo json_encode($response);

    }

	// close the db connection...
	mysqli_close($connection);

}

function readTop10(){

	// read function for the application...
	$connection = mysqli_connect("localhost", "root", "root", "db_601");

	if (mysqli_connect_errno($connection))
	{
	   echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}

	$result = mysqli_query($connection,"SELECT * FROM high_scores ORDER BY player_score DESC, created_at DESC LIMIT 10");

	if (mysqli_num_rows($result) > 0) {

		$response["scores"] = [];

		while ($row = mysqli_fetch_array($result)){

				$score = array();
				$score['player_name'] = $row['player_name'];
				$score['player_score'] = $row['player_score'];
				$score['player_locale'] = $row['player_locale'];

				array_push($response["scores"], $score);

		}

		// success
	    $response["success"] = 1;

	}  else {

	    // no products found
	    $response["success"] = 0;
	    $response["message"] = "No products found";  

	}

	// close the db connection...
	mysqli_close($connection);
	
	// return... 
	$scoresJSON = json_encode($response);

	return $scoresJSON;

}

function readTop100(){

	// read function for website...
	$connection = mysqli_connect("localhost", "root", "root", "db_601");

	if (mysqli_connect_errno($connection))
	{
	   echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}

	$result = mysqli_query($connection,"SELECT * FROM high_scores ORDER BY player_score DESC, created_at DESC LIMIT 100");

	$scores = [];

	while ($row = mysqli_fetch_array($result)) {
		array_push($scores, $row);
	}

	// close the db connection...
	mysqli_close($connection);

	// return...
	return $scores;
	
}

function deleteScore(){

	// use for housekeeping...

}