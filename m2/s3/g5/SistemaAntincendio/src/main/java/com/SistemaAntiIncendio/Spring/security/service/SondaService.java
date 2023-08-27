package com.SistemaAntiIncendio.Spring.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaAntiIncendio.Spring.security.entity.Sonda;
import com.SistemaAntiIncendio.Spring.security.repository.SondaRepository;

@Service
public class SondaService {
	
	@Autowired
    private SondaRepository sondaRepository;

    public List<Sonda> getAllSonde() {
        return sondaRepository.findAll();
    }
	
    public Sonda getSondaById(long id) {
        return sondaRepository.findById(id);
    }
}
