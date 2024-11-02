package com.dreameutopia.controller;

import com.dreameutopia.model.ChatMessage;
import com.dreameutopia.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    
    @Autowired
    private ChatService chatService;
    
    @PostMapping
    public Map<String, String> chat(@RequestBody Map<String, String> request) {
        String response = chatService.processMessage(request.get("message"));
        return Map.of("response", response);
    }
    
    @GetMapping("/history")
    public List<Map<String, Object>> getChatHistory() {
        return chatService.getChatHistory();
    }
    
    @GetMapping("/{chatId}")
    public List<ChatMessage> getChatMessages(@PathVariable Long chatId) {
        return chatService.getChatMessages(chatId);
    }
}