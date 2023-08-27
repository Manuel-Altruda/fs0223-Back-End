package com.SistemaAntiIncendio.Spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
//public class ThymeleafController {
//	
//	@GetMapping("/home")
//    public String showHomePage(Model model) {
//        model.addAttribute("message", "Benvenuto nella pagina Thymeleaf!");
//        return "home"; 
//    }
//
//    @GetMapping("/alarmList")
//    public String showAlarmPageList(Model model) {
//        model.addAttribute("message", "Benvenuto nella pagina Thymeleaf!");
//        return "alarmList"; 
//    }
//    
//    @Controller
//    public class RegisterController {
//
//        @GetMapping("/register")
//        public String showRegistrationPage(Model model) {
//            
//            return "register.html"; 
//        }
//    }
//    
//    @GetMapping("/login")
//    public String showLoginPage(Model model) {
//        
//        return "login"; 
//    }
//}