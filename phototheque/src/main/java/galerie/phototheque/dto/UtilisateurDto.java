package galerie.phototheque.dto;

import galerie.phototheque.entity.Role;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class UtilisateurDto {

    private Long id_user;


    private String pseudo;
    private Role role;
    private String prenom;
    private String nom;
    private String mot_de_pass;
    public UtilisateurDto() {}
}
