Dies ist Worttrainer reworked.

## Einleitung
Er ist in Model, View und eine Main Klasse als Controller gesplittet, ganz nach dem MVC Schema.

## View
Die View Klasse ist im gui package und heißt JOptionView, sie stellt Methoden zur Verfügung welche die Nutzung von JOptionPane vereinfachen, hier kann aber natürlich jederzeit ein anderes Framework als GUI verwendet werden.

## Model
Das Model ist im model package. Es beinhaltet Wortpaare und den Rechtschreibtrainer, welcher die Wortpaare hat und Methoden auf diese zur Verfügung stellt.

## Persistenz
Die Klassen hier ermöglichen es das Rechtschreibtrainer Objekt in der Runtime zu laden oder abzuspeichern.

## Main
Zuguterletzt noch die Main Klasse, sie fungiert als Controller und nutzt die Methoden aller anderen Klassen, so dass weder Model noch View eine gegenseitige Referenz haben.
