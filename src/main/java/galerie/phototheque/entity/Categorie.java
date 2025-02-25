package galerie.phototheque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

@Entity
public class Categorie {
    @Id
    @GeneratedValue
    @Setter
    @Getter
    private Long id_categorie;

    @Setter
    @Getter
    private String nom_categorie;

    public Categorie() {
    }
}
