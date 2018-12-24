<?php 
	session_start();
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "Dictionary";
	$conn = new mysqli($servername, $username, $password,$dbname);
	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	}
	if($_SERVER["REQUEST_METHOD"] == "POST"){
		$Email = $_POST['Email'];
		$password = $_POST['Password'];
		
		if (!$Email || !$password) {
			echo "Please fill all Email and Password information. <a href='javascript: history.go(-1)'>Return</a>";
			exit;
		}
		
		if (mysqli_num_rows(mysqli_query($conn,"SELECT Email, PassWord FROM user WHERE Email = '$Email'")) == 0) {
			echo "This Email isn't existed. <a href='javascript: history.go(-1)'>Return</a>";
			exit;
		}
		
		$Check = mysqli_fetch_array(mysqli_query($conn,"SELECT Email, PassWord FROM user WHERE Email = '$Email'"));
		
		if ($password != $Check['PassWord']) {
			echo "Incorrect PassWord. <a href='javascript: history.go(-1)'>Return</a>";
			exit;
		}
		
		$UserID = "";
		$user = "SELECT ID FROM user WHERE Email = '$Email'"; 
		$result1 = $conn->query($user);
		if($result1->num_rows > 0){
			while($row = $result1->fetch_assoc()){
				$UserID = $row['ID'];
			}
		}
		$_SESSION['UserID'] = $UserID;
		$_SESSION['Email'] = $Email;
		echo "Hi " . $Email . ". You have Sign in successful click here to move to HomePage.<a href='HomePage.php'>Home page </a>";
		die();
	}	

?>


<!DOCTYPE html>
<html>
	<head><title>Login</title>
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
		<div class="container-fluid" id="Login">
			<section class="row justify-content-center">
				<section class="col-12 col-sm-6 col-md-3">
					<form class="form-container" action="<?php echo $_SERVER['PHP_SELF'];?>" method="POST">
						<h1 class="text-center text-primary">Sign In</h1>
						<div class="form-group">
							<label for="Email"><b>Email address:</b></label>
							<input type="email" class="form-control" id="Email" name="Email" aria-describedby="emailHelp" placeholder="Enter email">
						</div>
						<div class="form-group">
							<label for="Password"><b>Password:</b></label>
							<input type="password" class="form-control" id="Password" name="Password" placeholder="Enter password">
						</div>
						<button type="submit" class="btn btn-success btn-block" name="SignIn">Sign in</button>
						<a href = "SignUp.php"><small class="form-text text-muted">Don't have account ? Click here</small></a>
						
					</form>
				</section>
			</section>	
		</div>
	</body>
</html>