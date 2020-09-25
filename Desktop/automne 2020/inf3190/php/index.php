<?php
function getAverageGrade() {
  return (42 + 32 + 12) / 3;
}

function displayGrade($average) {
  return number_format($average, 2);
}

function getCourseArray() {
  return file("cours.txt");
}
?>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Hello World!</title>
    <meta charset="utf-8">
  </head>
  <body>
    <h1>Hello World!</h1>
    <p><?= displayGrade(getAverageGrade()); ?>% en moyenne à l'examen</p>
    <p>Liste de cours plates :</p>
    <ul>
      <?php foreach (getCourseArray() as $sigle): ?>
        <li>
        <?= $sigle; ?>
        </li>
      <?php endforeach; ?>
    </ul>
  </body>
</html>
