package main.java.edu.lcaitlyn.avaj_launcher.dto;

public class JetPlane extends Aircraft {
    private final String RAIN = "Rain? Let’s hope my wipers work at Mach speed.";
    private final String FOG = "Fog ahead! Engaging stealth mode unintentionally.";
    private final String SUN = "Sun’s out, engines out. Just kidding!";
    private final String SNOW = "Snow patrol? More like snow trouble.";

    public JetPlane(long id, String name, Coordinates coordinates) {
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

        moveLatitude(10);
        moveLongitude(2);
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

        moveHeight(-7);
    }
}
