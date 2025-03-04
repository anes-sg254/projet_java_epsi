package galerie.phototheque.service;

import galerie.phototheque.entity.Utilisateur;
import galerie.phototheque.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImp implements UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    
    public List<Utilisateur> getAll() {
        return utilisateurRepository.findAll();
    }
    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }
    @Override
    public void addUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public void deleteUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.delete(utilisateur);

    }

    @Override
    public Utilisateur getUtilisateurById(Long id) {
            Optional<Utilisateur> utilisateur  = Optional.empty();
        utilisateur = utilisateurRepository.findById(id);
        return utilisateur.orElse(null);
    }
}
