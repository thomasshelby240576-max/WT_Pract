<?php
// Create or load cricket.xml
$xml = new SimpleXMLElement('<CricketTeam></CricketTeam>');

// Function to add Team elements to CricketTeam
function addTeam($country, $player, $runs, $wicket) {
    global $xml;
    $team = $xml->addChild('Team');
    $team->addAttribute('country', $country);
    $team->addChild('player', $player);
    $team->addChild('runs', $runs);
    $team->addChild('wicket', $wicket);
}

// Adding Team elements for different countries
addTeam('Australia', 'Player1', 100, 2);
addTeam('England', 'Player2', 150, 3);
addTeam('India', 'Player3', 120, 1);

// Save the updated XML to a file
$xml->asXML('cricket.xml');

// Add multiple elements for the category with country="India"
$additionalPlayers = [
    ['Player4', 80, 2],
    ['Player5', 110, 4],
    ['Player6', 90, 3],
];

foreach ($additionalPlayers as $playerInfo) {
    addTeam('India', $playerInfo[0], $playerInfo[1], $playerInfo[2]);
}

// Save the updated XML to the file again
$xml->asXML('cricket.xml');

echo 'Cricket.xml file created and updated successfully.';
?>
