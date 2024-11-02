package com.dreameutopia.service;

import com.dreameutopia.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class AuthService {
    
    @Autowired
    private JavaMailSender mailSender;
    
    private final Map<String, String> emailCodes = new HashMap<>();
    
    public User login(String email, String password) {
        // TODO: Implement actual database authentication
        User user = new User();
        user.setEmail(email);
        user.setUsername("Test User");
        return user;
    }
    
    public void register(String username, String email, String password) {
        // TODO: Implement actual user registration
    }
    
    public void sendEmailCode(String email) {
        String code = generateCode();
        emailCodes.put(email, code);
        
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("DreamEutopia验证码");
        message.setText("您的验证码是: " + code);
        
        mailSender.send(message);
    }
    
    public boolean verifyEmailCode(String email, String code) {
        String savedCode = emailCodes.get(email);
        return savedCode != null && savedCode.equals(code);
    }
    
    private String generateCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }
}