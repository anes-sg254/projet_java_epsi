package galerie.phototheque.dto;

import galerie.phototheque.entity.*;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String pseudo;
    private String firstName;
    private String lastName;
    private Role role;
    private boolean isActive;
}
