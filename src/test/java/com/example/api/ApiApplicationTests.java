package com.example.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
<<<<<<< HEAD
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
=======
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
>>>>>>> 222939bd8f7fdaf551980aff6d77ae3d9534db1e

@SpringBootTest
@AutoConfigureMockMvc
class ApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
<<<<<<< HEAD
    public void testGetAllUtilisateurs() throws Exception {
        mockMvc.perform(get("/api/utilisateurs")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetUtilisateur() throws Exception {
        // Remplacez '1' par l'ID de l'utilisateur que vous voulez tester
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
        // Remplacez '1' par l'ID de l'utilisateur que vous voulez tester
        mockMvc.perform(put("/api/utilisateurs/1")
                .content(utilisateur)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUtilisateur() throws Exception {
        // Remplacez '1' par l'ID de l'utilisateur que vous voulez tester
        mockMvc.perform(delete("/api/utilisateurs/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
=======
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
>>>>>>> 222939bd8f7fdaf551980aff6d77ae3d9534db1e
    }
}
