package galerie.phototheque.service;

import galerie.phototheque.entity.Role;
import galerie.phototheque.repository.RoleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}