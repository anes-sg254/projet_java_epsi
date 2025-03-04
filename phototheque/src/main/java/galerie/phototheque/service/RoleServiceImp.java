package galerie.phototheque.service;

import galerie.phototheque.entity.Role;
import galerie.phototheque.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImp implements  RoleService{
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> roles() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);

    }

    @Override
    public void updateRole(Role role) {
        roleRepository.save(role);

    }

    @Override
    public void deleteRole(Role role) {
        roleRepository.delete(role);

    }

    @Override
    public Role getRoleById(Long id) {
        Optional<Role> role = Optional.empty();
        role=roleRepository.findById(id);
        return role.orElse(null);
    }
}
