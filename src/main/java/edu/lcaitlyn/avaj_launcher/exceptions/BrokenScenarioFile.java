package main.java.edu.lcaitlyn.avaj_launcher.exceptions;

public class BrokenScenarioFile extends RuntimeException {
    public BrokenScenarioFile() {
        super("Scenario is not correct file");
    }
}
