package galerie.phototheque.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "elements_detectes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ElementDetecte {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom; 

}
