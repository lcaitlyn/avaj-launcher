package main.java.edu.lcaitlyn.avaj_launcher.exceptions;

import java.io.FileNotFoundException;

public class ScenarioNotFound extends FileNotFoundException {
    public ScenarioNotFound() {
        super("Scenario not found");
    }
}
