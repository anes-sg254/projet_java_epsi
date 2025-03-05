package galerie.phototheque.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class UserDownloadId implements java.io.Serializable {
    private Long userId;
    private Long imageId;
}