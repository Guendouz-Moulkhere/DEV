package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.math3.analysis.function.Identity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ApiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}

@Entity
class Utilisateur {
    @Id @GeneratedValue
    private Long id;
    private String nom;
    private String email;

    // getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {}

@Service
class UtilisateurService {
    private final UtilisateurRepository repository;

    @Autowired
    public UtilisateurService(UtilisateurRepository repository) {
        this.repository = repository;
    }

    public List<Utilisateur> findAll() {
        return repository.findAll();
    }

    public Optional<Utilisateur> findById(Long id) {
        return repository.findById(id);
    }

    public Utilisateur save(Utilisateur utilisateur) {
        return repository.save(utilisateur);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

@RestController
@RequestMapping("/api/utilisateurs")
class UtilisateurController {
    private final UtilisateurService service;

    @Autowired
    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Utilisateur> getUtilisateur(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return service.save(utilisateur);
    }

    @PutMapping("/{id}")
    public Utilisateur updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur existingUtilisateur = service.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        existingUtilisateur.setNom(utilisateur.getNom());
        existingUtilisateur.setEmail(utilisateur.getEmail());
        return service.save(existingUtilisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable Long id) {
        service.deleteById(id);
    }
}
