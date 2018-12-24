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
	
	$ErrName = $ErrEmail = $ErrDB = $ErrPass = $ErrPhone = "";
	$Name = $Email = $DB = $PassWord = $Phone = "";

	if($_SERVER["REQUEST_METHOD"] == "POST"){
		if (empty($_POST["Name"])) {
			$ErrName = "Name is required";
		}
		else{
			$Name = $_POST['Name'];
		}
		
		if (empty($_POST["DB"])) {
			$ErrDB = "Date of Birth required";
		}
		else {
			$DB = $_POST['DB'];
		}
		
		if (empty($_POST["Phone"])) {
			$ErrPhone = "Phone is required";
		}
		else {
			$Phone = $_POST['Phone'];
		}
		
		if (empty($_POST["Email"])) {
			$ErrEmail = "Email required";
		}
		else {
			$Email = $_POST['Email'];
		}
		
		if (empty($_POST["PassWord"])) {
			$ErrPass = "PassWord required";
		}
		else {
			$PassWord = $_POST['PassWord'];
		}
		
		if ((!empty($Name)) && (!empty($Email)) && (!empty($PassWord)) && (!empty($Phone)) && (!empty($DB))){
			$sql = "INSERT INTO user (Name, Email, PassWord ,Phone ,DB)
			VALUES ('$Name','$Email','$PassWord','$Phone','$DB')";
			if ($conn->query($sql) === TRUE) {
				echo "<p>Your account created successfully</p>";
				echo "<p>Please Sign In by your new account <a href='SignIn.php'>SignIn </a></p>";
			} 	
			else {
				echo "Error: " . $sql . "<br>" . $conn->error;
			}
			die();
		}
	}
?>


<!DOCTYPE html>
<html>
	<head><title>SignUp</title>
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
				<section class="col-12 col-sm-3 col-md-6">
					<form class="form-container" action="<?php echo $_SERVER['PHP_SELF'];?>" method="POST">
						<div class="title"><h1 class="text-center">Sign Up</h1></div>
						<div class="form-group">
							<input type="text" class="form-control" id="Name" name="Name" placeholder="Enter your name here..">
							<p class="text-warning"><?php echo $ErrName;?></p>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="DB" name="DB" placeholder="Enter date of birth : yyyy/mm/dd">
							<p><?php echo $ErrDB;?></p>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="Phone" name="Phone" placeholder="Enter your Phone here..">
							<p class="text-warning"><?php echo $ErrPhone;?></p>
						</div>
						<div class="form-group">
							<input type="email" class="form-control" id="Email" name="Email" aria-describedby="emailHelp" placeholder="Enter email here..">
							<p class="text-warning"><?php echo $ErrEmail;?></p>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="PassWord" name="PassWord" placeholder="Enter password here..">
							<p class="text-warning"><?php echo $ErrPass;?></p>
						</div>
						<button type="submit" class="btn btn-success btn-block" name="SignUp">Sign up</button>
						
					</form>
				</section>
			</section>	
		</div>
	</body>
</html>