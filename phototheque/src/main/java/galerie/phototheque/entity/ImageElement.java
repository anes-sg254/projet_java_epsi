package galerie.phototheque.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "image_element")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ImageElement {

    @EmbeddedId
    private ImageElementId id = new ImageElementId();

    @ManyToOne
    @MapsId("imageId")
    private Image image;

    @ManyToOne
    @MapsId("elementId")
    private ElementDetecte element;

}
