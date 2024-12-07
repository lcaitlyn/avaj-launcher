find * -name "*.java" > sources.txt
javac @sources.txt
java src/main/java/edu/lcaitlyn/avaj_launcher/Program.java resources/scenario.txt