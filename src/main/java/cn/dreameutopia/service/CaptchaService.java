package cn.dreameutopia.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Service
public class CaptchaService {
    
    public String generateCaptcha() {
        Random random = new Random();
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            captcha.append(random.nextInt(10));
        }
        return captcha.toString();
    }
    
    public boolean verify(HttpSession session, String captcha) {
        String savedCaptcha = (String) session.getAttribute("captcha");
        return savedCaptcha != null && savedCaptcha.equals(captcha);
    }
}