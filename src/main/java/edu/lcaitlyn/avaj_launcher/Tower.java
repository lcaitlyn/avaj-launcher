package main.java.edu.lcaitlyn.avaj_launcher;

import main.java.edu.lcaitlyn.avaj_launcher.dto.Flyable;
import main.java.edu.lcaitlyn.avaj_launcher.utils.TowerLogger;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers;
    private List<Flyable> unregistredObservers = new ArrayList<>();
    protected TowerLogger logger;

    public Tower() {
        observers = new ArrayList<>();
        logger = new TowerLogger();
    }

    public void register(Flyable flyable) {
        if (flyable == null) {
            throw new NullPointerException();
        }

        if (flyable.getCoordinates().getHeight() > 0) {
            observers.add(flyable);
            logger.logRegister(flyable);
        } else {
            logger.logUnregister(flyable);
        }
    }

    public void unregister(Flyable flyable) {
        if (flyable == null) {
            throw new NullPointerException();
        }

        observers.remove(flyable);
        logger.logUnregister(flyable);
    }

    public void logWeatherMessage(Flyable flyable, String motto) {
        logger.logWeatherMessage(flyable, motto);
    }

    protected void conditionChanged() {
        for (Flyable flyable : observers) {
            if (flyable.getCoordinates().getHeight() > 0) {
                flyable.updateConditions();
            } else {
                unregistredObservers.add(flyable);
            }
        }
        for (Flyable flyable : unregistredObservers) {
            unregister(flyable);
        }
        unregistredObservers.clear();
    }
}
