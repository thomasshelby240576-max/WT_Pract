<?php
	session_start();

	$basic = $_POST['basic'];
	$da = $_POST['da'];
	$hra = $_POST['hra'];

	echo "<h3>Employee Details </h3>";
	echo "Number: ".$_SESSION['no']."<br>";
	echo "Name: ".$_SESSION['name']."<br>";
	echo "Address: ".$_SESSION['address']."<br>";
	
	echo "<h3>Earning Details</h3>";
	echo "Basic: ".$basic."<br>";
	echo "DA: ".$da."<br>";
	echo "HRA: ".$hra."<br>";
	
	$total = $basic + $da + $hra;
	echo "<br>Total Earning: ".$total."<br>";
	
?>
