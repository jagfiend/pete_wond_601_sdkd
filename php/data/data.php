<?php

$connection = mysqli_connect("localhost", "root", "root", "db_601");

if (mysqli_connect_errno($connection))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$result = mysqli_query($connection,"SELECT * FROM high_scores ORDER BY player_score DESC, created_at DESC LIMIT 100");

	$scores = [];

	while ($row = mysqli_fetch_array($result)){
			array_push($scores, $row);
	}

// close the db connection...
mysqli_close($connection);

// return 
$scoresJSON = json_encode($scores);

return $scoresJSON;