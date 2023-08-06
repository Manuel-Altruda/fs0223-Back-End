package com.Progetto_Settimanale.Spring.security.service;

import com.Progetto_Settimanale.Spring.security.payload.LoginDto;
import com.Progetto_Settimanale.Spring.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
