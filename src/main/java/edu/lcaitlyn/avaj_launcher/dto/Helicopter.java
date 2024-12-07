package main.java.edu.lcaitlyn.avaj_launcher.dto;

public class Helicopter extends Aircraft {
    private final String RAIN = "Rain’s like jazz for my rotors – unpredictable but cool.";
    private final String FOG = "Fog’s here! Where’s the sky gone?!";
    private final String SUN = "Clear skies! Time for a spin… or two.";
    private final String SNOW = "Snowstorm incoming! Hope the rotor doesn’t turn into a popsicle.";

    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        if (weather.equals("SUN")) {
            sun();
        } else if (weather.equals("RAIN")) {
            rain();
        } else if (weather.equals("FOG")) {
            fog();
        } else if (weather.equals("SNOW")) {
            snow();
        } else {
            throw new IllegalArgumentException("Invalid weather type: " + weather);
        }
    }

    private void sun() {
        weatherTower.logWeatherMessage(this, SUN);

        moveLongitude(10);
        moveHeight(2);
    }

    private void rain() {
        weatherTower.logWeatherMessage(this, RAIN);

        moveLongitude(5);
    }

    private void fog() {
        weatherTower.logWeatherMessage(this, FOG);

        moveLongitude(1);
    }

    private void snow() {
        weatherTower.logWeatherMessage(this, SNOW);

        moveHeight(-12);
    }
}
