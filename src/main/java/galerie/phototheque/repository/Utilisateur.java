package galerie.phototheque.repository;

import galerie.phototheque.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Utilisateur extends JpaRepository<Utilisateur, Long> {
}
