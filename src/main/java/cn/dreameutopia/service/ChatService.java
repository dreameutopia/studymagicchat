package cn.dreameutopia.service;

import cn.dreameutopia.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ChatService {
    
    public String processMessage(String message) {
        return "Echo: " + message;
    }
    
    public List<Map<String, Object>> getChatHistory() {
        return new ArrayList<>();
    }
    
    public List<ChatMessage> getChatMessages(Long chatId) {
        return new ArrayList<>();
    }
}