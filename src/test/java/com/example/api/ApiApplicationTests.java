package com.example.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetAllUtilisateurs() throws Exception {
        mockMvc.perform(get("/api/utilisateurs")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetUtilisateur() throws Exception {
        mockMvc.perform(get("/api/utilisateurs/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateUtilisateur() throws Exception {
        String utilisateur = "{\"nom\": \"test\", \"email\": \"test@example.com\"}";
        mockMvc.perform(post("/api/utilisateurs")
                .content(utilisateur)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateUtilisateur() throws Exception {
        String utilisateur = "{\"nom\": \"test updated\", \"email\": \"testupdated@example.com\"}";
        mockMvc.perform(put("/api/utilisateurs/1")
                .content(utilisateur)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUtilisateur() throws Exception {
        mockMvc.perform(delete("/api/utilisateurs/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
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
