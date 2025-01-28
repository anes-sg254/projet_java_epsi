package galerie.phototheque.controller;

import galerie.phototheque.entity.Utilisateur;
import galerie.phototheque.services.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/utilisateurs")
public class Utilisateur {

    @Autowired
    private Utilisateur utilisateurService;

    @GetMapping
    public List<Utilisateur> getAllUsers() {
        return utilisateurService.getAllUsers();
    }

    @PostMapping
    public Utilisateur saveUser(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.saveUser(utilisateur);
    }

}
