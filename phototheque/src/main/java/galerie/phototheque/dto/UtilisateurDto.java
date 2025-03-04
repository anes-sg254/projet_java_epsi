package galerie.phototheque.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UtilisateurDto {
    private Long id;
    private String pseudo;
    private String prenom;
    private String nom;
    private String motDePasse;
    private String role;
}
