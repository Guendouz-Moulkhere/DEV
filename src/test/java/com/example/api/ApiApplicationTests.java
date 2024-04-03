package com.example.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class ApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    public void helloShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/api/hello"))
            .andExpect(status().isOk())
            .andExpect(content().string("Bonjour, bienvenue dans votre API Spring Boot!"));
    }

    @Test
    public void greetingShouldReturnPersonalizedMessage() throws Exception {
        this.mockMvc.perform(get("/api/greeting").param("name", "John"))
            .andExpect(status().isOk())
            .andExpect(content().string("Bonjour John, bienvenue dans votre API Spring Boot!"));
    }
}
