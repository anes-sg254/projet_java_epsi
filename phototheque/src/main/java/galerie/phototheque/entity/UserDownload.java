package galerie.phototheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_downloads")
@Getter
@Setter
public class UserDownload {

        @EmbeddedId
        private UserDownloadId id;

        @Column(name = "downloaded_at", nullable = false)
        private LocalDateTime downloadedAt = LocalDateTime.now();

        @MapsId("userId")
        @ManyToOne
        @JoinColumn(name = "user_id")
        private Users user;

        @MapsId("imageId")
        @ManyToOne
        @JoinColumn(name = "image_id")
        private Images image;
}
