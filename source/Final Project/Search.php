<!--Code to change the active page on menu bar-->
<?php
	$page = 'Search';
?>

<!--Code to check input word-->
<?php
session_start();

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "Dictionary";
$conn = new mysqli($servername, $username, $password,$dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
$Email = $_SESSION['Email'];
$input = $linkAudio = $warning = "";
$explain = "explain/NoWord.html";

if($_SERVER["REQUEST_METHOD"] == "POST"){
	if (empty($_POST['search'])) {
		$warning = "You didn't enter";
	}
	else {
		$searchq = $_POST['search'];
		$searchq = preg_replace("#[^0-9a-z]#i","",$searchq);
		
		//Save to history of user//
		$UserID = $_SESSION['UserID'];
		$InsertHistory = "INSERT INTO history (UserID, Word, Date) VALUES ('$UserID','$searchq', NOW())";
		if ($conn->query($InsertHistory) === TRUE) {
				echo "New record created successfully";
			} 	
			else {
				echo "Error: " . $InsertHistory . "<br>" . $conn->error;
			}
			
		//Return word search//
		$sql = "SELECT * FROM english WHERE word = '$searchq'";
		$result2 = $conn->query($sql);
		if($result2->num_rows > 0){
			while($row = $result2->fetch_assoc()){
				$word = $row['word'];
				$mean = $row['mean'];
				$linkAudio = $row['audio'];
				$input = $word;
				$explain = $mean;
			}
		}
		else{
			$warning = "No word found";
		}
	}
}
?>





<!--Interface code-->
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
		<div class="title"><h1 class="text-center"> Enter word to search</h1></div>
		<form method="post" action="<?php echo $_SERVER['PHP_SELF'];?>">
			<div class="row">
				<div class="col-sm-10">	
					<div class="form-group">
						<input type="text" class="form-control" id="Search" placeholder="Search.." name="search">
					</div>
				</div>	
				<div class="col-sm-2">
					<div class="form-group">
						<button class="btn btn-lg btn-primary" type = "submit"><span class="glyphicon glyphicon-search"></span> Search</button>
					</div>
				</div>
			</div>
		
		</form>
		<div class ="text-warning">
			<?php echo $warning;?>
		</div>
		<div class="input_word">
			<p><?php echo $input ;?></p>
		</div>
		<div class="description">
			<?php include $explain;?>			
		</div>
		
		<audio controls>		
			<source src="<?php echo $linkAudio;?>" type="audio/mpeg">
		</audio>
		
	</div>
		
	<!--footer-->
	<?php include'Footer.php';?>
	
	
</body>
</html>