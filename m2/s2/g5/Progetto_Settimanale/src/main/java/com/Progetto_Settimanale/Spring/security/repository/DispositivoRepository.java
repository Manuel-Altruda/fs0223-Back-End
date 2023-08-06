package com.Progetto_Settimanale.Spring.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Progetto_Settimanale.Spring.security.entity.Dispositivo;
import com.Progetto_Settimanale.Spring.security.entity.StatoDispositivo;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
	
	List<Dispositivo> findByStato(StatoDispositivo stato);
	
	List<Dispositivo> findByTipo(StatoDispositivo tipo);

}
