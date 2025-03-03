package galerie.phototheque.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ImageDTO {
    private Long id;
    private String nom;
    private String description;
    private String categorie;
    private boolean presenceIndividu;
    private int compteurTelechargements;
    private String urlTailleReelle;
    private String urlMiniature;
    private List<String> elementsDetectes;
    private Date dateCreation;
}