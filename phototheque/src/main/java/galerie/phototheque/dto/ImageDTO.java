package galerie.phototheque.dto;

import lombok.Data;
import java.util.List;

@Data
public class ImageDTO {
    private Long id;
    private String nom;
    private String description;
    private long taille;
    private String dateCreation;
    private String dateUpload;
    private List<String> objetsDetectes;
    private boolean contientPersonne;
    private String urlOriginale;
    private String urlMiniature;
}
