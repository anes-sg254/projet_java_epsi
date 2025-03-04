package galerie.phototheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String pseudo;
    private String prenom;
    private String nom;
    private String motDePasse;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Telechargement> telechargements;

    private boolean active = true;

    public Utilisateur() {}
}