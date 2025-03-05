package galerie.phototheque.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String pseudo;

        @Column(nullable = false)
        private String nom;

        @Column(nullable = false)
        private String prenom;

        @Column(nullable = false)
        private String password;

        @Column(nullable = false)
        private String role = "USER"; // "USER" ou "ADMIN"

        @Column(name = "created_at", updatable = false)
        private LocalDateTime createdAt = LocalDateTime.now();
    }
