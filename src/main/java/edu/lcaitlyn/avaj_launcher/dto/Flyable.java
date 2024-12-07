package main.java.edu.lcaitlyn.avaj_launcher.dto;

import main.java.edu.lcaitlyn.avaj_launcher.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract Coordinates getCoordinates();
    public abstract void updateConditions();
    public abstract void registerTower(WeatherTower weatherTower);
    public abstract Long getId();
    public abstract String getName();


    @Override
    public String toString() {
        return super.toString();
    }
}
