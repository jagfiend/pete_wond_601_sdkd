<?php
	// function to retrive top 100 scores...this is a simplified version of the call for JSON data...
	function get_all_scores(){
		
		$response = array();

		// include db connect class
		require_once __DIR__ . '/data/db_connect.php';

		// connecting to db
		$db = new DB_CONNECT();

		// query scores...
		$result = mysql_query("SELECT * FROM high_scores ORDER BY player_score DESC, created_at DESC LIMIT 100") or die(mysql_error());

		// check for empty result
		if (mysql_num_rows($result) > 0) {
		    
		    $scores = array();
		    
		    while ($row = mysql_fetch_array($result)) {
		        
		        $score = array();
		        $score["id"] = $row["id"];
		        $score["player_name"] = $row["player_name"];
		        $score["player_score"] = $row["player_score"];
		        $score["player_locale"] = $row["player_locale"];
		        $score["player_photo"] = $row["player_photo"];

		        array_push($scores, $score);
		    }
		} 

		return $scores;   
	} 
?>
<html>
	<head>
		<title>601_wond_peter_sdkd</title>
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
	</head>
	<body class="container">
	<header>
		<h1>Tile Tapper 100 - Hall of Fame</h1>
	</header>
	<p id="top">This is the hall of fame website for Tile Tapper 100, the table below shows the top 100 scores achieved by players around the globe!</p>
	<table class="table table-striped">
		<tr>
			<td>RANK</td>
			<td>SELFIE</td>
			<td>NAME</td>
			<td>LOCALE</td>
			<td>SCORE</td>
		</tr>
		<tr>
		<!-- php foreach loops over array of highscores and prints each score to the page... -->
		<?php $scores = get_all_scores(); $i = 0; foreach ($scores as $score) : ?>
				<td><?php $i++; echo $i; ?></td>
				<td><img src="assets/img/<?php echo $score['player_photo'] ?>" class="avatar_image"></td>
				<td><?php echo $score['player_name']; ?></td>
				<td><?php echo $score['player_locale']; ?></td>
				<td><?php echo $score['player_score']; ?></td>
			</tr>
		<?php endforeach; ?>
	</table>
	<a href="#top">Back to top</a>
	<footer>Wondworks &copy 2014</footer>
	</body>
</html>