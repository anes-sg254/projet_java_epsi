package galerie.phototheque.service;

import galerie.phototheque.entity.Role;
import galerie.phototheque.repository.RoleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface RoleService {

    List<Role> getAllRoles();
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(Role role);
    Role getRoleById(Long id);
}