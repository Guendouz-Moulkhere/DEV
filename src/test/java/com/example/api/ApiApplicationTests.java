package com.example.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

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
    }
}
