package com.giorno1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.giorno1.classes.Utente;
import com.giorno1.repositories.UtenteRepository;

@Controller
public class PageController {
	
	@Autowired
    private UtenteRepository utenteRepository;

    @GetMapping("/home")
    public String getHomePage() {
        return "home";
    }
    
    @GetMapping("/chiSono")
    public String getChiSonoPage(Model model) {
        // Recupera il primo utente dalla rubrica (se presente)
        Iterable<Utente> utenti = utenteRepository.findAll();
        Utente utente = utenti.iterator().hasNext() ? utenti.iterator().next() : null;
        model.addAttribute("utente", utente);
        return "chisono";
    }

    @GetMapping("/rubrica")
    public String getRubricaPage(Model model) {
        Iterable<Utente> utenti = utenteRepository.findAll();
        model.addAttribute("utenti", utenti);
        return "rubrica";
    }

    @GetMapping("/salvaUtente")
    public String getSalvaUtentePage() {
        return "salvautente";
    }

    @PostMapping("/salvaUtente")
    public String salvaUtente(@RequestParam String nome, Model model) {
        Utente nuovoUtente = new Utente();
        nuovoUtente.setNome(nome);
        utenteRepository.save(nuovoUtente);

        return "redirect:/rubrica";
    }
	
}
