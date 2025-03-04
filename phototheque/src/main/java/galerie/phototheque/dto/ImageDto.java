package galerie.phototheque.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Data
public class ImageDto {
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