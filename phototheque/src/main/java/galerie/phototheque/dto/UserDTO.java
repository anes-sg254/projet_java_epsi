package galerie.phototheque.dto;

import galerie.phototheque.entity.*;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String nom;
    private String email;
    private String password;
    private Role role;
    private boolean isActive;
}
