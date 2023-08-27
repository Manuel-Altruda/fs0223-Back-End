package com.SistemaAntiIncendio.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SistemaAntiIncendio.Spring.data.AlarmData;
import com.SistemaAntiIncendio.Spring.repository.FireAlarmRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SistemaAntiIncendioApplication {
	
	@Autowired
	FireAlarmRepository fireAlarmRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaAntiIncendioApplication.class, args);
		
	}
	
	
	@PostConstruct
    public void init() {
        AlarmData alarmData = new AlarmData("sonda04441", 74825.183, -689.456, 9.5);
        fireAlarmRepository.save(alarmData);
        
        AlarmData alarmData1 = new AlarmData("sonda69059598", 47.123, -481.456, 6.5);
        fireAlarmRepository.save(alarmData1);
        
        AlarmData alarmData2 = new AlarmData("sonda456784", 42.123, -695.436, 5.5);
        fireAlarmRepository.save(alarmData2);
    }
	
}
