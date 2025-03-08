package galerie.phototheque.repository;

import galerie.phototheque.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
    List<User> findByActifTrue();
    Optional<User> findByIdAndActifTrue(Long id);

}
