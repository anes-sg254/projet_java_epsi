package galerie.phototheque.entity;

import jakarta.persistence.*;

import java.time.LocalTime;
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;


    private String pseudo;
    @ManyToOne
    private Role role;
    private String prenom;
    private String nom;
    private String mot_de_pass;
    public User(String pseudo, Role role, String prenom, String nom, String mot_de_pass,Long id_user) {
        this.pseudo=pseudo;
        this.role=role;
        this.prenom=prenom;
        this.nom=nom;
        this.mot_de_pass=mot_de_pass;
        this.id_user=id_user;
    }
    public String getPseudo() {
        return this.pseudo;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public String getNom() {
        return this.nom;
    }
    public String getMot_de_pass() {
        return this.mot_de_pass;
    }


}