package galerie.phototheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter
public class Telechargement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTelechargement;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    private Date dateTelechargement;

    public Telechargement() {}
}

