package com.spring.chatbotApi.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint, no authentication required";
    }

    @GetMapping("/secured")
    public String securedEndpoint() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "This is a secured endpoint. Hello, " + authentication.getName() + "!";
    }
}