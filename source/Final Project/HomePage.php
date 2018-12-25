<?php
	$page = 'Home';
	session_start();
	
	if(!isset($_SESSION['SignedIn'])){
		header('location:SignedIn.php');
	}
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<link rel="stylesheet" href="style.css">
</head>
<body>	
	<!--Menu bar-->
	<div>
	<?php include'MenuBar.php';?>
	</div>
	<!--Container-->
	<div id="home">
		<div class="landing-text">
			<h1>Welcome to Dictionary!</h1>
			<h3>A good website to learn English you ever seen</h3>
			<a href="Search.php"><button id="Start" class="btn btn-lg btn-primary">Get Started</button></a>
		</div>
	</div>
	<div class="container">
		<div class="title"><h1 class = "text-center">Introduction</h1></div>
		<h3 class="text-center">This website is using for learning English and you can enter what word you want to search . About the cost : It's Free for use</h3>
	</div>
	<!--Footer-->
	<div>
	<?php include'Footer.php';?>
	</div>
</body>
</html>
	