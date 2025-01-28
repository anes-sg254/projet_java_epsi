package galerie.phototheque.repository;

import galerie.phototheque.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Categorie extends JpaRepository<Categorie, Long> {
}
