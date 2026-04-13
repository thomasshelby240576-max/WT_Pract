<?php
	session_start();
	if(isset($_SESSION['count']))
	$_SESSION['count']=0;
	$username = $_POST['user'];
	$password = $_POST['pass'];
	
	if($username == "" && $password == "") {
		echo "Enter all details";
	}
	if($username == "Austin" && $password == "makasare") {
		echo "Login Successfull";
		$_SESSION['count']=0;
	}else {
		$_SESSION['count'] = $_SESSION['count']+1;
		if($_SESSION['count']>2) {
			echo ("You Execeded the Limit.....i.e,3");
			$_SESSION['count']=0;
		} else{
			echo "Login Failed..Wrong details Entered...attempts made:".$_SESSION['count'];
			include('Q1.html');
		}
	}
?>
