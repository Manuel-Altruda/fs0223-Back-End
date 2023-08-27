package com.SistemaAntiIncendio.Spring.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaAntiIncendio.Spring.security.entity.Sonda;

public interface SondaRepository extends JpaRepository<Sonda, Long> {
	
	List<Sonda> findAll(); 
    Sonda findById(long id); 
    Sonda save(Sonda sonda); 
    void deleteById(long id);

}
