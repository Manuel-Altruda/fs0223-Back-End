package com.giorno4.Spring.security.service;

import com.giorno4.Spring.security.payload.LoginDto;
import com.giorno4.Spring.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
