<?php
	echo "style is ".$_GET['s1']."<br>color is".$_GET['c']."<br>Background color is".$_GET['b']."<br>Size is ".$_GET['s'];
	
	setcookie("set1",$_GET['s1'],time()+3600);
	setcookie("set2",$_GET['c'],time()+3600);
	setcookie("set3",$_GET['b'],time()+3600);
	setcookie("set4",$_GET['s'],time()+3600);
?>

<html>
	<body>
		<form action="Q1-1.php" method="GET">
			<input type=submit value=ok>
		</form>
	</body>
</html>
