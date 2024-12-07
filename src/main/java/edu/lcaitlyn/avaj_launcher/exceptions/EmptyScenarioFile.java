package main.java.edu.lcaitlyn.avaj_launcher.exceptions;

public class EmptyScenarioFile extends RuntimeException {
    public EmptyScenarioFile() {
        super("Empty scenario file");
    }
}
