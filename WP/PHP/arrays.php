<?php
$numbers = array(1, 2, 3, 4, 5,6,7,8,9,10);

$sum = array_sum($numbers);

$average = $sum/ count($numbers);
$min = min($numbers);
$max = max($numbers);

echo "Numbers : ".implode(",",$numbers)."<br>";
echo "Sum: $sum "."<br>"." Average: $average. "<br>"." Min: $min "."<br>"." Max:$max";
?>