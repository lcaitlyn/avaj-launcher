package main.java.edu.lcaitlyn.avaj_launcher.exceptions;

public class WrongArgumentException extends RuntimeException {
    public WrongArgumentException() {
        super("Wrong arguments! Example: java Program scenario.txt");
    }
}
