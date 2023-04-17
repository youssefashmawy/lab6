@echo off
javac *.java
java Main Rte_Ecuc.arxml

java Main notValidAutosarFileCase.txt

java Main empty.arxml
pause