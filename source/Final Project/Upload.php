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
$word = $linkExplain = $linkAudio = "";

if($_SERVER["REQUEST_METHOD"] == "POST"){
	$word = $_POST['word'];
	$linkExplain = $_POST['linkExplain'];
	$linkAudio = $_POST['linkAudio'];
	$Email = $_SESSION['Email'];
	
	$sql = "INSERT INTO english (word, mean, audio,upBy)
	VALUES ('$word','$linkExplain','$linkAudio','$Email')";
	
	if ($conn->query($sql) === TRUE) {
		echo "New record created successfully";} 	
	else {
		echo "Error: " . $sql . "<br>" . $conn->error;
	}
}
?>
<!<!DOCTYPE html>
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
	
	

	<!--Form upload word-->
	<div class = "container">
		<form  method = "post" action = "<?php echo $_SERVER['PHP_SELF'];?>">
			<div class="form-group">
				<label for = "word">Word:</label>
				<input name = "word" type="text" class="form-control" id="word" placeholder="Enter word...">
			</div>
			<div class="form-group">
				<label for="explain">Explain:</label>
				<input name = "linkExplain" type="text" class="form-control" id="explain" placeholder="Enter URL like : explain/abc.html">
			</div>
			<div class="form-group">
				<label for="audio">Audio:</label>
				<input name = "linkAudio" type="text" class="form-control" id="audio" placeholder="Enter URL like : audio/abc.mp3">
			</div>
			<div class="form-group">
				<button class="btn btn-lg btn-primary" type ="submit">Upload</button>
			</div>
		</form>
	</div>
	
	<!--footer-->
	<?php include'Footer.php';?>

</body>
	
	
</html>
