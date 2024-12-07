package main.java.edu.lcaitlyn.avaj_launcher.dto;

import main.java.edu.lcaitlyn.avaj_launcher.WeatherTower;
import main.java.edu.lcaitlyn.avaj_launcher.utils.SimParams;

public class Aircraft extends Flyable {
    protected Long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }

    public void updateConditions() {}

    protected void moveLongitude(int diff) {
        int newLongitude = coordinates.getLongitude() + diff;

        if (newLongitude > SimParams.LONGITUDE_LATITUDE_MAX) {
            newLongitude = SimParams.LONGITUDE_LATITUDE_MAX;
        }
        coordinates.setLongitude(newLongitude);
    }

    protected void moveLatitude(int diff) {
        int newLatitude = coordinates.getLatitude() + diff;

        if (newLatitude > SimParams.LONGITUDE_LATITUDE_MAX) {
            newLatitude = SimParams.LONGITUDE_LATITUDE_MAX;
        }
        coordinates.setLatitude(newLatitude);
    }

    protected void moveHeight(int diff) {
        int newHeight = coordinates.getHeight() + diff;

        if (newHeight > SimParams.HEIGHT_MAX) {
            newHeight = SimParams.HEIGHT_MAX;
        }
        coordinates.setHeight(newHeight);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        if (weatherTower == null) {
            throw new IllegalArgumentException("Weather Tower cannot be null");
        }

        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}
