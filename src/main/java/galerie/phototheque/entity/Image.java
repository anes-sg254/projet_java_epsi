package galerie.phototheque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class Image {

    @Id
    @GeneratedValue
    @Setter
    @Getter
    private Long id_image;

    @ManyToOne
    @Setter
    @Getter
    private Utilisateur utilisateur;


    @Setter
    @Getter
    private String nom;

    @Setter
    @Getter
    @ManyToOne
    private Categorie categorie;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    private String taille;

    @Setter
    @Getter
    private Date date_creation;

    @Setter
    @Getter
    private Date date_modification;

    @Setter
    @Getter
    private String elements_detecte;

    @Setter
    @Getter
    private String flag_individu;

    @Setter
    @Getter
    private String url_reel;

    @Setter
    @Getter
    private String url_mini;

    public Image() {

    }
}
