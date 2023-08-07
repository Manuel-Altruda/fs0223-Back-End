package com.Progetto_Settimanale.Spring.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Progetto_Settimanale.Spring.security.entity.Device;
import com.Progetto_Settimanale.Spring.security.entity.DeviceStatus;
import com.Progetto_Settimanale.Spring.security.entity.User;

public interface DispositivoRepository extends JpaRepository<Device, Long> {
	
	List<Device> findByStatus(DeviceStatus status);
	
	 List<Device> findByAssignedUser(User user);
	
	List<Device> findByTipo(DeviceStatus tipo);
	
	Optional<Device> findById(Long id);

	Device getDispositivoById(Long dispositivoId);
	
}
