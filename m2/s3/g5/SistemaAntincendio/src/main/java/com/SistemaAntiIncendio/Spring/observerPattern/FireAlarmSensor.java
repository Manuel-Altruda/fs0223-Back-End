package com.SistemaAntiIncendio.Spring.observerPattern;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FireAlarmSensor implements FireAlarmSubject {
	
	private List<FireAlarmObserver> observers = new ArrayList<>();
    private double smokeLevelThreshold = 5.0;

    public void setSmokeLevelThreshold(double threshold) {
        this.smokeLevelThreshold = threshold;
    }

    public void updateSmokeLevel(double smokeLevel) {
        if (smokeLevel >= smokeLevelThreshold) {
            notifyObservers(smokeLevel);
        }
    }

    @Override
    public void registerObserver(FireAlarmObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(FireAlarmObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(double smokeLevel) {
        for (FireAlarmObserver observer : observers) {
            observer.update(smokeLevel);
        }
    }
	
}
