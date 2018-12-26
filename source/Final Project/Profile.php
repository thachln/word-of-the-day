<?php
	$page = 'Profile';
	session_start();
	
	if(($_SESSION['SignedIn'])== FALSE){
		header('location:SignIn.php');
	}
?>


<?php
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "Dictionary";
	$conn = new mysqli($servername, $username, $password,$dbname);
	// Check connection
	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	}
	$Name = $DB = $Email = $Phone = $warning = "";
	$Email = $_SESSION['Email'];
	$sql = "SELECT * FROM user WHERE Email = '$Email'";
	$result = $conn->query($sql);
	if($result->num_rows > 0){
		while($row = $result->fetch_assoc()){
			$Name = $row['Name'];
			$DB = $row['DB'];
			$Email = $row['Email'];
			$Phone = $row['Phone'];
		}
	}
	else{
		$warning = "No User found";
	}
?>



<!DOCTYPE html>
<html>
	<head><title>User</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link href="style.css" rel="stylesheet">
	</head>
<body>
	
	<!--Menu bar-->
	<?php include'MenuBar.php';?>
	<!--Container-->
	<div class="container">
		<div class="title"><h1 class="text-center text-primary">User Profile</h1></div>
		<div class="row">
			<div class ="col-sm-3">
				<img src = "img/avatar.png" width="100%">
			</div>
			<div class ="col-sm-9">
				<p><b>Name:</b> <?php echo $Name;?></p>
				<p><b>Date of Birth:</b> <?php echo $DB;?></p>
				<p><b>Email:</b> <?php echo $Email;?></p>
				<p><b>Phone Number:</b> <?php echo $Phone;?></p>
				<a href = "History.php"><button class = "btn btn-info" role="button">History</button></a>
			</div>
			<?php echo $warning;?>
		</div>
		
	</div>	
	<!--footer-->
	<?php include 'Footer.php';?>
	
</body>
</html>
