package galerie.phototheque.dto;

public class RoleDto {

    private String type_role;

    private Long id_role;

    public RoleDto(){}

    public RoleDto(String type_role,Long id_role) {
        this.type_role=type_role;
        this.id_role=id_role;
    }
}
