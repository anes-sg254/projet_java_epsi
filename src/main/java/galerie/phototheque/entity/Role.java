package galerie.phototheque.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Role {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_role;

    @Getter
    @Setter
    private String type_role;

    public Role(){}
    public Role(String type_role,Long id_role) {
        this.type_role=type_role;
        this.id_role=id_role;
    }


}
