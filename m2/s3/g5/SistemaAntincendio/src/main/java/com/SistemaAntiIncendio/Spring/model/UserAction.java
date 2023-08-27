package com.SistemaAntiIncendio.Spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaAntiIncendio.Spring.observerPattern.ControlCenter;
import com.SistemaAntiIncendio.Spring.observerPattern.FireAlarmSensor;
import com.SistemaAntiIncendio.Spring.repository.FireAlarmRepository;

@Service
public class UserAction {
	private FireAlarmSensor sensor;
    private FireAlarmRepository repository;

    public UserAction(FireAlarmSensor sensor, FireAlarmRepository repository) {
        this.sensor = sensor;
        this.repository = repository;

        ControlCenter center = new ControlCenter("Center");
        sensor.registerObserver(center);
    }

//    public void sendAlarmData(String idSonda, double latitude, double longitude, double smokeLevel) {
//        sensor.updateSmokeLevel(smokeLevel);
//        repository.saveAlarmData(idSonda, latitude, longitude, smokeLevel);
//    }
}
