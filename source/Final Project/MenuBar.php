<?php
$Email = $_SESSION['Email'];
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "Dictionary";
$conn = new mysqli($servername, $username, $password,$dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
$UserName = '';
$sql = "SELECT * FROM user WHERE Email = '$Email'"; 
$result = $conn->query($sql);
	if($result->num_rows > 0){
		while($row = $result->fetch_assoc()){
			$UserName = $row['Name'];
		}
	}
?>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="style.css">

<nav class="navbar navbar-expand-sm ">
		<!-- Brand/logo -->
		<a class="navbar-brand" href="HomePage.php">
			<p>
				<img src="img/logo.png" alt="logo" style="width:40px;">
				DICTIONARY
			</p>
		</a>
  
		<!-- Links -->
		<div class="collapse navbar-collapse justify-content-center">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="HomePage.php" id="<?php if($page == 'Home'){echo 'active';}?>">Home</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="Search.php" id="<?php if($page == 'Search'){echo 'active';}?>">Search</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="Profile.php" id="<?php if($page == 'Profile'){echo 'active';}?>">Profile</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="About.php" id="<?php if($page == 'About'){echo 'active';}?>">About us</a>
				</li>	
				<li class="nav-item">
					<a class="nav-link" href="Upload.php" id="<?php if($page == 'Upload'){echo 'active';}?>">Upload</a>
				</li>
				
			</ul>
			<ul class="navbar-nav navbar">
				<li class="nav-item"><a href="Profile.php" id="active"><small class="form-text"><?php echo $UserName ;?></small></a></li>
				<li class="nav-item"><a href="SignIn.php">SignOut</a></li>
			</ul>
		</div>
</nav>