package galerie.phototheque.repository;

import galerie.phototheque.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}