<?php
	session_start();
	$_SESSION['no'] = $_POST['no'];
	$_SESSION['name'] = $_POST['name'];
	$_SESSION['address'] = $_POST['address'];
?>
<html>
	<body>
		<form action="Q1-1.php" method="POST">
			<center>
			<h3>Enter Employee Earning Details: </h3> <br>
				Basic: <input type=text name=basic><br>
				DA: <input type=text name=da><br>
				HRA: <input type=text name=hra><br>
				<input type=submit value="Display">
			</center>
			
		</form>
	</body>
</html>
