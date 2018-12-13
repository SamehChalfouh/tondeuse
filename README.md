# tondeuse

Tondeuse est une application qui permet d'automatiser la tonte d'un pelouse par un controle automatique un ensemble de tondeuses pour parcourir l'integralite de la surface.

## Description

A partir d'un taille de pelouse donnée et d'une ou plusieurs tondeuses présentées par une poisition (abscisse, ordonnees, orientation : E, W , S, N) et un ensemble d'instrcutions de navigation sous forme de lettres pour chaque tondeuse, le programme va executer les instructions attribuées à chaque tondeuse et calculer sa nouvelle position après chaque mouvement. A la fin du programme les positions finales des tondeuses sont affichées.

les instructions possibles sont : 
 - D : pivoter 90à droite
 - G: pivoter à droite
 - A: avancer

## Creation du jar

./mvn clean package

## Lancement de l'application 

java -jar target/tondeuse.process-0.0.1-SNAPSHOT.jar

## URL Swagger 
http://localhost:8080/swagger-ui.html

