package galerie.phototheque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false)
    private LocalDateTime dateCreation = LocalDateTime.now();
    @Column(nullable = false)
    private String nom;

    private String description;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @Column(nullable = false)
    private String url; 

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User utilisateur; 

    private LocalDateTime dateUpload = LocalDateTime.now();

    private boolean actif = true;

    public void setNom(String nom) {
        this.nom=nom;
    }
    public void setDescription (String description) {
        this.description=description;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateUpload = dateCreation;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setUtilisateur(User user) {
        this.utilisateur = user;
    }
    public void setDateUpload(LocalDateTime dateUpload) {
        this.dateUpload = dateUpload;
    }

    public String getNom() {
        return this.nom;
    }
    public String getDescription() {
        return this.nom;
    }
    public String getUrl() {
        return this.url;
    }
    public User getUtilisateur() {
        return this.utilisateur;
    }
    public LocalDateTime getDateCreation() {
         return this.dateCreation;
    }





}
