<?php
// code to create a new high score from a POST request sent from the Android device...
// array for JSON response
$response = array();

// check for required fields
if (isset($_POST['player_name']) && isset($_POST['player_score']) && isset($_POST['player_locale'])) {
    
    // define variables...
    $player_name = $_POST['player_name'];
    $player_score = $_POST['player_score'];
    $player_locale = $_POST['player_locale'];

    // include db connect class...
    require_once __DIR__ . '/db_connect.php';

    // connecting to db...
    $db = new DB_CONNECT();

    // mysql inserting a new row...
    $result = mysql_query("INSERT INTO high_scores(player_name, player_score, player_locale, created_at) 
                            VALUES('$player_name', '$player_score', '$player_locale', NOW())");

    // check if row inserted or not
    if ($result) {
        // successfully inserted into database
        $response["success"] = 1;
        $response["message"] = "Score successfully created.";

        // echoing JSON response
        echo json_encode($response);
    } else {
        // failed to insert row
        $response["success"] = 0;
        $response["message"] = "Oops! An error occurred.";
        
        // echoing JSON response
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";

    // echoing JSON response
    echo json_encode($response);
}
?>