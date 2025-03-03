package galerie.phototheque.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UtilisateurDTO {
    private Long id;
    private String pseudo;
    private String prenom;
    private String nom;
    private String motDePasse;
    private String role;
}
