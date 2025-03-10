package com.spring.chatbotApi.controller;

import com.spring.chatbotApi.service.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatbotController {
    @Autowired
    private ChatbotService chatbotService;

    @GetMapping("/message")
    public String getResponse(@RequestParam String userMessage) {
        return chatbotService.generateResponse(userMessage);
    }
}
