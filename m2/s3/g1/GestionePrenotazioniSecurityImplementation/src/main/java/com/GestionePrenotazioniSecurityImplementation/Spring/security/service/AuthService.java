package com.GestionePrenotazioniSecurityImplementation.Spring.security.service;

import com.GestionePrenotazioniSecurityImplementation.Spring.security.payload.LoginDto;
import com.GestionePrenotazioniSecurityImplementation.Spring.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
