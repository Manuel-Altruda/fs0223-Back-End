package com.SistemaAntiIncendio.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SistemaAntiIncendio.Spring.data.AlarmData;

@Repository
public interface FireAlarmRepository extends JpaRepository<AlarmData, Long> {

    
	
}
