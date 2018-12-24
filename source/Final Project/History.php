<?php
$page = 'Profile';
session_start(); 
?>


<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link href="style.css" rel="stylesheet">
</head>
<body>
	<?php include'MenuBar.php';?>
	<div class = "container">
		<div class="title"><h1 class="text-center">History Search</h1></div> 
		<table class="table table-striped">
			<tr>
				<th>Num</th>
				<th>Word</th>
				<th>DateTime</th>
			</tr>
			<?php 
				$servername = "localhost";
				$username = "root";
				$password = "";
				$dbname = "Dictionary";
				$conn = new mysqli($servername, $username, $password,$dbname);
				if ($conn->connect_error) {
					die("Connection failed: " . $conn->connect_error);
				}
				$UserID = $_SESSION['UserID'];
				$sql = "SELECT * FROM history where UserID = '$UserID'";
				$result = $conn->query($sql);
				$STT = 1;
				if ($result->num_rows > 0) {
				// output data of each row
					while($row = $result->fetch_assoc()) {
						echo "<tr><td>". $STT."</td><td>". $row["Word"]."</td><td>". $row["Date"]."</td></tr>";
						$STT = $STT + 1;
					}
				} 
				else {
					echo "0 results";
				}
				$conn->close();
			?> 
		</table>
	</div>
	<?php include'Footer.php';?>
</body>
</html>