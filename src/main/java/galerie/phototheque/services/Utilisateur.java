package galerie.phototheque.services;

import galerie.phototheque.entity.Utilisateur;
import galerie.phototheque.repository.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Utilisateur {

    @Autowired
    private Utilisateur utilisateurRepository;

    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur saveUser(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }


}
