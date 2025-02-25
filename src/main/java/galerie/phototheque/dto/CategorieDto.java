package galerie.phototheque.dto;

import lombok.Getter;
import lombok.Setter;

public class CategorieDto {
    private Long id_categorie;

    @Setter
    @Getter
    private String nom_categorie;

    public CategorieDto() {
    }
}
