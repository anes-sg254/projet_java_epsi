package galerie.phototheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import galerie.phototheque.entity.*;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findTop10ByOrderByDateCreationDesc();

    List<Image> findByUtilisateurAndActifTrue(User utilisateur);
}
