package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @RestController
    class HelloController {

        @GetMapping("/api/hello")
        public String hello() {
            return "Bonjour, bienvenue dans votre API Spring Boot!";
        }
    }
}
