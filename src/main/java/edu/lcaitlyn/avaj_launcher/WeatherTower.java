package main.java.edu.lcaitlyn.avaj_launcher;

import main.java.edu.lcaitlyn.avaj_launcher.dto.Coordinates;

public class WeatherTower extends Tower {
    private final WeatherProvider weatherProvider;
    private int random;

    public WeatherTower() {
        this.weatherProvider = WeatherProvider.getInstance();
    }

    public String getWeather(Coordinates coordinates) {
        return weatherProvider.getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        weatherProvider.changeWeather();
        conditionChanged();
    }
}
