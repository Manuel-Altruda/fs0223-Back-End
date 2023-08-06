package com.Progetto_Settimanale.Spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Progetto_Settimanale.Spring.security.entity.Dispositivo;
import com.Progetto_Settimanale.Spring.security.repository.DispositivoRepository;

@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {
	
	@Autowired
    private DispositivoRepository dispositivoRepository;
	
	@GetMapping
    public List<Dispositivo> getAllDispositivi() {
        return dispositivoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Dispositivo getDispositivoById(@PathVariable Long id) {
        return dispositivoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Dispositivo createDispositivo(@RequestBody Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    @PutMapping("/{id}")
    public Dispositivo updateDispositivo(@PathVariable Long id, @RequestBody Dispositivo dispositivoDetails) {
        Dispositivo dispositivo = dispositivoRepository.findById(id).orElse(null);
        if (dispositivo != null) {
            dispositivo.setTipo(dispositivoDetails.getTipo());
            dispositivo.setStato(dispositivoDetails.getStato());
            return dispositivoRepository.save(dispositivo);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDispositivo(@PathVariable Long id) {
        dispositivoRepository.deleteById(id);
    }
	
}
