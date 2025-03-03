package galerie.phototheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;

    private String nom;
    
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    private String description;
    private Long taille;
    private Date dateCreation;
    private Date dateModification;
    
    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL)
    private List<ElementDetecte> elementsDetectes;

    private boolean presenceIndividu;
    private int compteurTelechargements;

    private String urlTailleReelle;
    private String urlMiniature;

    public Image() {}
}
