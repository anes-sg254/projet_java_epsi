package galerie.phototheque.entity;

public class Role {
    private String type_role;
    private Long id_role;

    public Role(String type_role,Long id_role) {
        this.type_role=type_role;
        this.id_role=id_role;
    }

    public String getType_role() {
        return this.type_role;
    }
    public Long getId_role() {
        return this.id_role;
    }
}