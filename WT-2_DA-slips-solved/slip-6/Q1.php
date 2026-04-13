<?php
	$xml = simplexml_load_file("book.xml");
	
	echo "<h2>Book Details</h2>";
	echo "<table border=2>";
	echo "<tr><th>ID</th><th>Name</th><th>Price</th><th>Auther</th></tr>";
	foreach($xml->book as $v) {
		echo "<tr>";
		echo "<td>".$v['id']."</td>";
		echo "<td>".$v->bname."</td>";
		echo "<td>".$v->price."</td>";
		echo "<td>".$v->auther."</td>";
		echo"</tr>";
	
	}
	echo "</table>";
?>
