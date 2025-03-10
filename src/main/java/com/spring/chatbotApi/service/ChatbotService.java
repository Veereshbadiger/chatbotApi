package com.spring.chatbotApi.service;

import com.spring.chatbotApi.model.ChatMessage;
import com.spring.chatbotApi.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ChatbotService {
    
    @Autowired
    private ChatMessageRepository chatMessageRepository;
    
    public String generateResponse(String userMessage) {
        String botResponse;
        
        // Simple pattern matching for responses
        if (userMessage.toLowerCase().contains("hello") || 
            userMessage.toLowerCase().contains("hi")) {
            botResponse = "Hello! How can I assist you today?";
        } else if (userMessage.toLowerCase().contains("how are you")) {
            botResponse = "I'm doing well, thanks for asking! How can I help you today?";
        } else if (userMessage.toLowerCase().contains("bye")) {
            botResponse = "Goodbye! Have a great day!";
        } else if (userMessage.toLowerCase().contains("weather")) {
            botResponse = "I don't have access to current weather data, but I can help with many other questions!";
        } else if (userMessage.toLowerCase().contains("thank")) {
            botResponse = "You're welcome! Is there anything else you'd like to know?";
        } else if (userMessage.toLowerCase().contains("help")) {
            botResponse = "I can answer questions, provide information, or just chat. What would you like to talk about?";
        } else {
            botResponse = "Interesting! Tell me more or ask me a specific question.";
        }
        
        // Save the conversation to database
        ChatMessage chatMessage = new ChatMessage(null, userMessage, botResponse, LocalDateTime.now());
        chatMessageRepository.save(chatMessage);
        
        return botResponse;
    }
}