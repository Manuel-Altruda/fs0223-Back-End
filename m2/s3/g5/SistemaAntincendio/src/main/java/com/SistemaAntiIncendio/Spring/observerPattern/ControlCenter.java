package com.SistemaAntiIncendio.Spring.observerPattern;

public class ControlCenter implements FireAlarmObserver {
	
	private String centerName;

    public ControlCenter(String centerName) {
        this.centerName = centerName;
    }

    @Override
    public void update(double smokeLevel) {
        System.out.println("Centro di Controllo: " + centerName + " ha ricevuto un allarme per fumo di livello: " + smokeLevel);
    }
	
}
