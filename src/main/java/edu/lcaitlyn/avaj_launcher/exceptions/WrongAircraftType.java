package main.java.edu.lcaitlyn.avaj_launcher.exceptions;

public class WrongAircraftType extends RuntimeException {
    public WrongAircraftType(String message) {
        super(message + ". Aircraft Type Should Be Only: Balloon, JetPlane or Helicopter");
    }
}
