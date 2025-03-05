package galerie.phototheque.repository;

import galerie.phototheque.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByPseudo(String pseudo);
}
