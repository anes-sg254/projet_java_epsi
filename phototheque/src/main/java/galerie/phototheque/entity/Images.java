package galerie.phototheque.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "Images")
@Getter
@Setter
public class Images {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Getter
        @Setter
        @Column(nullable = false)
        private String nom;

        @Column(columnDefinition = "TEXT")
        private String description;

        @Column(nullable = false)
        private Long taille;
        @Getter
        @Setter
        @Column(nullable = false, name = "url_originale")
        private String UrlOriginale;

        @Column(nullable = false, name = "url_miniature")
        private String urlMiniature;

        @Column
        private Integer compteur = 0;

        @Column(name = "presence_individus")
        private Boolean presenceIndividus = false;

        @Column(name = "objets_detectes", columnDefinition = "TEXT")
        private String objetsDetectes;

        @Column(name = "created_at", updatable = false)
        private LocalDateTime createdAt = LocalDateTime.now();

        @Column(name = "updated_at")
        private LocalDateTime updatedAt = LocalDateTime.now();

        @Column(name = "deleted_at")
        private LocalDateTime deletedAt;



        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private Users user;

        @ManyToOne
        @JoinColumn(name = "categorie_id")
        private categories category;

        @PreUpdate
        public void setUpdatedAt() {
            this.updatedAt = LocalDateTime.now();
        }

    }

