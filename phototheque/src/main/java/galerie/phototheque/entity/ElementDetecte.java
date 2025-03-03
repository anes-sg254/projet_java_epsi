package galerie.phototheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ElementDetecte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idElement;

    private String nomElement;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    public ElementDetecte() {}
}
