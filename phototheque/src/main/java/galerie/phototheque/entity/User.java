package galerie.phototheque.entity;

import jakarta.persistence.*;
import lombok.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    @NotNull
    @Column(nullable = false)
    private String password;
    @NotNull
    @Column(nullable = false)
    private String nom;

    @Enumerated(EnumType.STRING)
    private Role role = Role.UTILISATEUR; 

    private boolean actif = true;

    public void setActif(boolean actif) {
        this.actif=actif;
    }
    public String getEmail() {
        return this.email;
    }
    public String getNom() {
        return this.nom;
    }

    public String getPassword() {
        return this.password;
    }
    public Role getRole() {
        return this.role;
    }
    public boolean isActif() {
        return this.actif=true;
    }


}
