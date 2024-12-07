package main.java.edu.lcaitlyn.avaj_launcher.exceptions;

public class WrongScenarioArgument extends RuntimeException {
    public WrongScenarioArgument(String message) {
        super("Wrong scenario line: " + message + "\nMust be: TYPE NAME LONGITUDE LATITUDE HEIGHT");
    }
}
