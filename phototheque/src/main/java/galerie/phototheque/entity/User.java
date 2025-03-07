package galerie.phototheque.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nom;

    @Enumerated(EnumType.STRING)
    private Role role = Role.UTILISATEUR; 

    private boolean actif = true;

    public void setActif(boolean actif) {
        this.actif=actif;
    }

}
