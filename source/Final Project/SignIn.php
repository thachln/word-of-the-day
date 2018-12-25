<?php 
	session_start();
	
	$_SESSION['SignedIn'] = FALSE;
	
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "Dictionary";
	$conn = new mysqli($servername, $username, $password,$dbname);
	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	}
	
	$Email = $Password  = $ErrEmail = $ErrPassword = "";
	
	if($_SERVER["REQUEST_METHOD"] == "POST"){
		if(empty($_POST['Email'])) {
			$ErrEmail = "Please fill Email";
		}
		
		if(empty($_POST['Password'])) {
			$ErrPassword = "Please fill Password";
		}
		
		if((!empty($_POST['Email'])) && (!empty($_POST['Password']))) {
			$Email = $_POST['Email'];
			$Password = $_POST['Password'];
			
			if (mysqli_num_rows(mysqli_query($conn,"SELECT Email, PassWord FROM user WHERE Email = '$Email'")) == 0) {
				$ErrEmail = "Email doesn't exist";
			}
			else {
				$Check = mysqli_fetch_array(mysqli_query($conn,"SELECT Email, PassWord FROM user WHERE Email = '$Email'"));
				if ($Password != $Check['PassWord']) {
					$ErrPassword = "Password wrong! Please try again";
				}
				else {
					$UserID = "";
					$user = "SELECT ID FROM user WHERE Email = '$Email'"; 
					$result1 = $conn->query($user);
					if($result1->num_rows > 0) {
						while($row = $result1->fetch_assoc()) {
							$UserID = $row['ID'];
						}
					}
					$_SESSION['UserID'] = $UserID;
					$_SESSION['Email'] = $Email;
					$_SESSION['SignedIn'] = TRUE;
					header('location:HomePage.php');
				}
			}
		}
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
							<p class="text-warning"><?php echo $ErrEmail;?></p>
						</div>
						<div class="form-group">
							<label for="Password"><b>Password:</b></label>
							<input type="password" class="form-control" id="Password" name="Password" placeholder="Enter password">
							<p class="text-warning"><?php echo $ErrPassword;?></p>
						</div>
						<button type="submit" class="btn btn-success btn-block" name="SignIn">Sign in</button>
						<a href = "SignUp.php"><small class="form-text text-muted">Don't have account ? Click here</small></a>
						
					</form>
				</section>
			</section>	
		</div>
	</body>
</html>