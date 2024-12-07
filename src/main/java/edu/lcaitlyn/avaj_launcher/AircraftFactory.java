package main.java.edu.lcaitlyn.avaj_launcher;

import main.java.edu.lcaitlyn.avaj_launcher.dto.*;

public class AircraftFactory {
    private static AircraftFactory aircraftFactory;
    private static long id = 1;

    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        if (aircraftFactory == null) {
            aircraftFactory = new AircraftFactory();
        }
        return aircraftFactory;
    }

    public Flyable newAircraft(String type, String name, Coordinates coordinates) {
        switch (type) {
            case "Helicopter":
                return new Helicopter(id++, name, coordinates);
            case "Balloon":
                return new Balloon(id++, name, coordinates);
            case "JetPlane":
                return new JetPlane(id++, name, coordinates);
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
    }
}
