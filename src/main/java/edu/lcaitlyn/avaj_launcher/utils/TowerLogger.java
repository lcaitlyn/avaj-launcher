package main.java.edu.lcaitlyn.avaj_launcher.utils;

import main.java.edu.lcaitlyn.avaj_launcher.dto.Flyable;

public class TowerLogger {
    private static final String TOWER_REGISTER = "Tower says: %s#%s(%d) registered to weather tower.";
    private static final String TOWER_FAILED_REGISTER = "Tower says: %s#%s(%d) can not be registered (Because it has height = 0).";
    private static final String TOWER_UNREGISTER = "Tower says: %s#%s(%d) unregistered from weather tower.";
    private static final String WEATHER_MESSAGE = "%s#%s(%d): %s";
    private static final String WEATHER_MESSAGE_W_COORDS = "%s#%s(%d): %s (%d, %d, %d)";

    private Logger logger;

    public TowerLogger() {
        logger = Logger.getInstance();
    }

    public void logRegister(Flyable flyable) {
        logger.log(String.format(TOWER_REGISTER,
                flyable.getClass().getSimpleName(),
                flyable.getName(),
                flyable.getId()
        ));
    }

    public void logFailedRegister(Flyable flyable) {
        logger.log(String.format(TOWER_FAILED_REGISTER,
                flyable.getClass().getSimpleName(),
                flyable.getName(),
                flyable.getId()
        ));
    }

    public void logUnregister(Flyable flyable) {
        logger.log(String.format(TOWER_UNREGISTER,
                flyable.getClass().getSimpleName(),
                flyable.getName(),
                flyable.getId()
        ));
    }

    public void logWeatherMessage(Flyable flyable, String motto) {
        logger.log(String.format(WEATHER_MESSAGE,
                flyable.getClass().getSimpleName(),
                flyable.getName(),
                flyable.getId(),
                motto,
                flyable.getCoordinates().getLongitude(), flyable.getCoordinates().getLatitude(), flyable.getCoordinates().getHeight()
        ));
    }

    public void close() {
        logger.close();
    }
}
