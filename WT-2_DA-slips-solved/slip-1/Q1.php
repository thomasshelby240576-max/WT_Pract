<?php
// Write a PHP script to keep track of number of times the web page has been accessed (Use Session  Tracking).
    Session_start();
    if(isset($_SESSION["pcount"])) {
        $_SESSION["pcount"] += 1;
    } else {
        $_SESSION["pcount"] = 1;
    }
    Echo"You have visited this page  ".$_SESSION['pcount']." Times(s)";
?>