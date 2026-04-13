<?php
	$style = $_COOKIE['set1'];
	$color = $_COOKIE['set2'];
	$size = $_COOKIE['set4'];
	$b_color = $_COOKIE['set3'];
	$msg = "Welcome to KKW";
	
	echo "<body bgcolor=$b_color>";
	echo "<font face=$style color=$color size=$size>$msg";
	echo "</font></body>";
	
?>
