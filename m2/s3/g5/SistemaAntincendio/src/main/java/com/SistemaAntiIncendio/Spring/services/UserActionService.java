package com.SistemaAntiIncendio.Spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaAntiIncendio.Spring.repository.FireAlarmRepository;

@Service
public class UserActionService {

    private final FireAlarmRepository fireAlarmRepository;

    @Autowired
    public UserActionService(FireAlarmRepository fireAlarmRepository) {
        this.fireAlarmRepository = fireAlarmRepository;
    }

	public FireAlarmRepository getFireAlarmRepository() {
		return fireAlarmRepository;
	}
}
