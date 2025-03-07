package galerie.phototheque.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageUploadDTO {
    private String nom;
    private String description;
    private String url;
    private Long userId;

    public String getNom() {
        return this.nom;
    }
    public String getDescription() {
        return this.description;
    }

    public Long getUserId() {
        return this.userId;
    }
    public String getUrl() {
        return this.url;
    }

}
