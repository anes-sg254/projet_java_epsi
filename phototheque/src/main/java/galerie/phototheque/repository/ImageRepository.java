package galerie.phototheque.repository;

import galerie.phototheque.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Images, Long> {
    List<Images> findTop10ByOrderByCreatedAtDesc();
}
