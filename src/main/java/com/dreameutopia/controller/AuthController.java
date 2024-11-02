package com.dreameutopia.controller;

import com.dreameutopia.model.User;
import com.dreameutopia.service.AuthService;
import com.dreameutopia.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {
    
    @Autowired
    private AuthService authService;
    
    @Autowired
    private CaptchaService captchaService;
    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
    
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String email, 
                       @RequestParam String password,
                       @RequestParam String captcha,
                       HttpSession session) {
        // 验证图形验证码
        if (!captchaService.verify(session, captcha)) {
            return "验证码错误";
        }
        
        try {
            User user = authService.login(email, password);
            session.setAttribute("user", user);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestParam String username,
                         @RequestParam String email,
                         @RequestParam String password,
                         @RequestParam String emailCode,
                         @RequestParam String captcha,
                         HttpSession session) {
        // 验证图形验证码
        if (!captchaService.verify(session, captcha)) {
            return "验证码错误";
        }
        
        // 验证邮箱验证码
        if (!authService.verifyEmailCode(email, emailCode)) {
            return "邮箱验证码错误";
        }
        
        try {
            authService.register(username, email, password);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    @PostMapping("/api/auth/send-email-code")
    @ResponseBody
    public String sendEmailCode(@RequestParam String email) {
        try {
            authService.sendEmailCode(email);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}