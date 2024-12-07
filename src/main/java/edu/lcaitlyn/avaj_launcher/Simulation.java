package main.java.edu.lcaitlyn.avaj_launcher;

import main.java.edu.lcaitlyn.avaj_launcher.dto.Flyable;
import main.java.edu.lcaitlyn.avaj_launcher.utils.Logger;

import java.util.List;

public class Simulation {
    public static void launch(int simulationNumber, List<Flyable> aircrafts) {
        WeatherTower weatherTower = new WeatherTower();

        for (Flyable aircraft : aircrafts) {
            aircraft.registerTower(weatherTower);
        }

        for (int i = 0; i < simulationNumber; i++) {
            weatherTower.changeWeather();
        }

        Logger.getInstance().close();
    }
}
