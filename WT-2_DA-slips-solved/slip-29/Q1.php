<?php
// define variables and set to empty values
$num = $op = $result = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $num = $_POST["num"];
    $op = $_POST["op"];

    // perform operation based on user's choice
    switch ($op) {
        case "fib":
            $result = fibonacci($num);
            echo "<p>The Fibonacci series of $num numbers is: $result</p>";
            break;
        case "sum":
            $result = sumOfDigits($num);
            echo "<p>The sum of digits in $num is: $result</p>";
            break;
        default:
            echo "<p>Invalid operation selected</p>";
    }
}
function fibonacci($num)
{
    $first = 0;
    $second = 1;
    $result = "";

    for ($i = 0; $i < $num; $i++) {
        $result .= $first . " ";
        $third = $first + $second;
        $first = $second;
        $second = $third;
    }
    return $result;
}

function sumOfDigits($num)
{
    $sum = 0;
    while ($num > 0) {
        $digit = $num % 10;
        $sum += $digit;
        $num = (int)($num / 10);
    }
    return $sum;
}
?>
