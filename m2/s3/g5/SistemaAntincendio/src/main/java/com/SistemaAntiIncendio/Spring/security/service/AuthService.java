package com.SistemaAntiIncendio.Spring.security.service;

import com.SistemaAntiIncendio.Spring.security.payload.LoginDto;
import com.SistemaAntiIncendio.Spring.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
