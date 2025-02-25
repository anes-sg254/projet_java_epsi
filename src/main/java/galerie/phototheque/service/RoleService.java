package galerie.phototheque.service;

import galerie.phototheque.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> roles();
    void addRole (Role role);
    void updateRole(Role role);
    void deleteRole(Role role);
    Role getRoleById(Long id);
}
