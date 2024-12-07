package main.java.edu.lcaitlyn.avaj_launcher.dto;

public class Balloon extends Aircraft {
    private final String RAIN = "Rain?! I didn’t sign up for a water ride!";
    private final String FOG = "Foggy, huh? Who turned off the GPS?";
    private final String SUN = "Sun’s out, time to soak up some vitamin D… and hot air!";
    private final String SNOW = "Snowflakes everywhere! This is like a giant sky snow globe.";

    public Balloon(long id, String name, Coordinates coordinates) {
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

    private void snow() {
        weatherTower.logWeatherMessage(this, SNOW);

        moveHeight(-15);
    }

    private void fog() {
        weatherTower.logWeatherMessage(this, FOG);

        moveHeight(-3);
    }

    private void rain() {
        weatherTower.logWeatherMessage(this, RAIN);

        moveHeight(-5);
    }

    private void sun() {
        weatherTower.logWeatherMessage(this, SUN);

        moveLongitude(2);
        moveHeight(4);
    }
}
