package com.example.api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Bonjour, bienvenue dans votre API Spring Boot!";
    }
}