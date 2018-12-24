<?php
	$page = 'About';
	session_start();
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
	<?php include'MenuBar.php';?>
	
	<!--Container-->
	<div class="container">
		<div class = "title"><h1 class="text-center">About us</h1></div>
		<div class = "row">
			<div class = "col-sm-3">
				<img src = "img/group.png" width="100%">
			</div>
			<div class = "col-sm-9">
				<h1>Our group contain three members : PhucNguyen , ThaoQuan, TrungNgoc.
				We are student in Ton Duc Thang university and this Dictionary website was made by us.</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="card">
					<img src="img/Phuc.jpg" alt="John" style="width:100%">
					<h1>Nguyen Hung Phuc</h1>
					<p class="title">student</p>
					<p>Ton Duc Thang university</p>
					<p><button>Contact</button></p>
				</div>
			</div>
			
			<div class="col-sm-4">
				<div class="card">
					<img src="img/Quan.jpg" alt="John" style="width:100%">
					<h1>Nguyen Chau Thao Quan</h1>
					<p class="title">student</p>
					<p>Ton Duc Thang university</p>
					<p><button>Contact</button></p>
				</div>
			</div>
			
			<div class="col-sm-4">
				<div class="card">
					<img src="img/Ngoc.jpg" alt="John" style="width:100%">
					<h1>Nguyen Trung Ngoc</h1>
					<p class="title">student</p>
					<p>Ton Duc Thang university</p>
					<p><button>Contact</button></p>
				</div>
			</div>
		</div>
	</div>
	<!--Footer-->
	<?php include'Footer.php';?>
</body>
</html>