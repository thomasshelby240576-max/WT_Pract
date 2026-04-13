<?php
	$dom = new  DomDocument();
	$dom->load("moives.xml");
	echo "<b>Movies Title</b><br>";
	$t = $dom->getElementsByTagName("mname");
	foreach($t as $node) {
		print $node->textContent;
		echo "<br>";
	}
	echo "<b>Movies Actor</b><br>";
	$t = $dom->getElementsByTagName("actor");
	foreach($t as $node) {
		print $node->textContent;
		echo "<br>";
	}
?>
