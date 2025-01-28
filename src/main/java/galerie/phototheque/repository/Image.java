package galerie.phototheque.repository;

import galerie.phototheque.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Image extends JpaRepository<Image, Long> {
}
