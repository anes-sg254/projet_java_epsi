package galerie.phototheque.repository;

import galerie.phototheque.entity.categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<categories, Long> {
}