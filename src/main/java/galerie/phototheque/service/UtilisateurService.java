package galerie.phototheque.service;


import galerie.phototheque.entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    List<Utilisateur> getAll();
    void addUtilisateur (Utilisateur utilisateur);
    void updateUtilisateur(Utilisateur utilisateur);
    void deleteUtilisateur(Utilisateur utilisateur);
    Utilisateur getUtilisateurById(Long id);
}
