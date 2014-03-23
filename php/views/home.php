<!doctype html>
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
		<!-- php foreach loops over array of results and prints each row to the page... -->
		<?php $i = 0; foreach ($scores as $score) : ?>
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