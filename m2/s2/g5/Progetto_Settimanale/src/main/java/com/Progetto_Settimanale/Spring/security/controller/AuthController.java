package com.Progetto_Settimanale.Spring.security.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Progetto_Settimanale.Spring.security.payload.JWTAuthResponse;
import com.Progetto_Settimanale.Spring.security.payload.LoginDto;
import com.Progetto_Settimanale.Spring.security.payload.RegisterDto;
import com.Progetto_Settimanale.Spring.security.service.AuthService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    } 

    // Build Login REST API
    @PostMapping(value = "/login")
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
           	
    	String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setUsername(loginDto.getUsername());
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API
    
    
    @PostMapping(value = "/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", response);
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }
    // JSON inviato dal Client
    /*{
        "name": "Giuseppe",
        "lastname": "Verdi",
        "username": "giuseppevardi",
        "email": "g.verdi@example.com",
        "password": "qwerty",
        "roles": ["MODERATOR", "ADMIN"]
    }*/
}
