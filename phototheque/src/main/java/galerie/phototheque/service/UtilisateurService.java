package galerie.phototheque.service;

import galerie.phototheque.entity.Utilisateur;
import galerie.phototheque.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UtilisateurService {
    List<Utilisateur> getAllUtilisateurs();
    void addUtilisateur(Utilisateur utilisateur);
    void updateUtilisateur(Utilisateur utilisateur);
    void deleteUtilisateur(Utilisateur utilisateur);
    Utilisateur getUtilisateurById(Long id);
}