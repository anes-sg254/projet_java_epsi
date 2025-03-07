package galerie.phototheque.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ImageElementId implements Serializable {
    
    private Long imageId;
    private Long elementId;

}
