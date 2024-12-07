package main.java.edu.lcaitlyn.avaj_launcher.utils;

import main.java.edu.lcaitlyn.avaj_launcher.AircraftFactory;
import main.java.edu.lcaitlyn.avaj_launcher.dto.Coordinates;
import main.java.edu.lcaitlyn.avaj_launcher.dto.Flyable;
import main.java.edu.lcaitlyn.avaj_launcher.exceptions.IllegalScenarioArgument;
import main.java.edu.lcaitlyn.avaj_launcher.exceptions.WrongAircraftType;
import main.java.edu.lcaitlyn.avaj_launcher.exceptions.WrongScenarioArgument;

import java.util.ArrayList;
import java.util.List;

public class ScenarioReader {
    public static int getSimulationNumber(List<String> scenario) {
        if (scenario.isEmpty()) {
            throw new IllegalScenarioArgument("Empty scenario");
        }

        int simulationNumber;
        try {
            simulationNumber = Integer.parseInt(scenario.getFirst());
        } catch (NumberFormatException e) {
            throw new IllegalScenarioArgument("Invalid simulation number");
        }

        if (simulationNumber < 1) {
            throw new IllegalScenarioArgument("Simulation Number must be positive");
        }

        return simulationNumber;
    }

    private static String getAircraftType(String type) {
        if (!type.equals("Balloon") && !type.equals("JetPlane") && !type.equals("Helicopter")) {
            throw new WrongAircraftType(type);
        }
        return type;
    }

    private static String getAircraftName(String name) {
        if (name.isEmpty()) {
            throw new WrongScenarioArgument("Empty Aircraft name");
        }
        return name;
    }

    private static int getHeight(String string) {
        int height;
        try {
            height = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new WrongScenarioArgument("Invalid height. Must be a positive integer");
        }

        if (height < SimParams.HEIGHT_MIN) {
            throw new IllegalScenarioArgument("Invalid height. Must be a positive integer");
        }

        if (height > SimParams.HEIGHT_MAX) {
            throw new IllegalScenarioArgument("Invalid height. Can't be greater than " + SimParams.HEIGHT_MAX);
        }

        return height;
    }

    private static int getLongitudeLatitude(String str) {
        int coordinate;

        try {
            coordinate = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalScenarioArgument("Invalid coordinate. Must be a positive integer");
        }
        if (coordinate < 1) {
            throw new IllegalScenarioArgument("Invalid coordinate. Must be a positive integer");
        }
        if (coordinate > SimParams.LONGITUDE_LATITUDE_MAX) {
            throw new IllegalScenarioArgument("Invalid coordinate. Out of range");
        }

        return coordinate;
    }

    private static Flyable getAircraft(String str) {
        if (str == null || str.isEmpty()) {
            throw new WrongScenarioArgument(str);
        }

        String[] aircraft = str.split(" ");
        if (aircraft.length != 5) {
            throw new WrongScenarioArgument(str);
        }

        String aircraftType = getAircraftType(aircraft[0]);
        String aircraftName = getAircraftName(aircraft[1]);
        Coordinates coordinates = new Coordinates(
                getLongitudeLatitude(aircraft[2]),
                getLongitudeLatitude(aircraft[3]),
                getHeight(aircraft[4])
        );

        AircraftFactory aircraftFactory = AircraftFactory.getInstance();

        return aircraftFactory.newAircraft(
                aircraftType,
                aircraftName,
                coordinates
        );
    }

    public static List<Flyable> getAircrafts(List<String> scenario) {
        if (scenario.isEmpty()) {
            throw new IllegalScenarioArgument("Empty scenario");
        }

        List<Flyable> aircrafts = new ArrayList<>();
        for (int i = 1; i < scenario.size(); i++) { // Первый пропускаем, так как это simulationNumber
            Flyable flyable = getAircraft(scenario.get(i));

            if (flyable == null) {
                throw new IllegalScenarioArgument(scenario.get(i));
            }
            aircrafts.add(flyable);
        }

        return aircrafts;
    }
}
