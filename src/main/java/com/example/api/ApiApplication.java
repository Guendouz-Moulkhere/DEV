package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    class HelloController {

        @GetMapping("/api/hello")
        public String hello() {
            return "Bonjour, bienvenue dans votre API Spring Boot!";
        }
    }
}
