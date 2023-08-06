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

import com.Progetto_Settimanale.Spring.security.entity.User;
import com.Progetto_Settimanale.Spring.security.repository.DispositivoRepository;
import com.Progetto_Settimanale.Spring.security.repository.UserRepository;

@RestController
@RequestMapping("/api/user") // probabilmente da modificare in /user
public class UserController {
    @Autowired
    private UserRepository utenteRepository;

    @GetMapping
    public List<User> getAllUtenti() {
        return utenteRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUtenteById(@PathVariable Long id) {
        return utenteRepository.findById(id).orElse(null);
    }

    @PostMapping
    public User createUtente(@RequestBody User utente) {
        return utenteRepository.save(utente);
    }

    @PutMapping("/{id}")
    public User updateUtente(@PathVariable Long id, @RequestBody User utenteDetails) {
        User utente = utenteRepository.findById(id).orElse(null);
        if (utente != null) {
            utente.setUsername(utenteDetails.getUsername());
            utente.setName(utenteDetails.getName());
            utente.setSurname(utenteDetails.getSurname());
            utente.setEmail(utenteDetails.getEmail());
            return utenteRepository.save(utente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUtente(@PathVariable Long id) {
        utenteRepository.deleteById(id);
    }
    
}


