package main.java.edu.lcaitlyn.avaj_launcher;

import main.java.edu.lcaitlyn.avaj_launcher.dto.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider instance;
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private int random = 1;

    private WeatherProvider() {};

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int sum = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        int index = (sum + random) % weather.length;
        return weather[index];
    }

    public void changeWeather() {
        random = new Random().nextInt(weather.length);
    }
}
