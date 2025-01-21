package galerie.phototheque.dto;

import galerie.phototheque.entity.Categorie;
import galerie.phototheque.entity.Utilisateur;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class ImageDto {
    
    private Long id_image;

    @Setter
    @Getter
    private Utilisateur utilisateur;


    @Setter
    @Getter
    private String nom;

    @Setter
    @Getter
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

    public ImageDto() {

    }
}
