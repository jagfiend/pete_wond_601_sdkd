<?php
// for retrieving data via GET from the Android device....
// array for JSON response
$response = array();

// include db connect class
require_once __DIR__ . '/db_connect.php';

// connecting to db
$db = new DB_CONNECT();

// get all scores from high_scores table
$result = mysql_query("SELECT * FROM high_scores ORDER BY player_score DESC, created_at DESC LIMIT 100") or die(mysql_error());

// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // scores node
    $response["scores"] = array();
    
    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $score = array();
        $score["id"] = $row["id"];
        $score["player_name"] = $row["player_name"];
        $score["player_score"] = $row["player_score"];
        $score["player_locale"] = $row["player_locale"];
        $score["created_at"] = $row["created_at"];

        // push single product into final response array
        array_push($response["scores"], $score);
    }
    // success
    $response["success"] = 1;

    // echoing JSON response
    echo json_encode($response);
} else {
    // no products found
    $response["success"] = 0;
    $response["message"] = "No scores found";

    // echo no users JSON
    echo json_encode($response);
}
?>