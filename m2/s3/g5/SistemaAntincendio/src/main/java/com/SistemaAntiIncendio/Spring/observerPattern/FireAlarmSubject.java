package com.SistemaAntiIncendio.Spring.observerPattern;

public interface FireAlarmSubject {
	
	 void registerObserver(FireAlarmObserver observer);
	 void removeObserver(FireAlarmObserver observer);
	 void notifyObservers(double smokeLevel);
	
}
