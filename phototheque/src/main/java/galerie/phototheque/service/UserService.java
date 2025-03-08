package galerie.phototheque.service;
import galerie.phototheque.dto.*;
import galerie.phototheque.entity.User;
import galerie.phototheque.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findByActifTrue();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findByIdAndActifTrue(id);
    }

    public User createUser(User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        return userRepository.save(user);
    }

    @Transactional
    public User saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Cet email est déjà utilisé !");
        }
        return userRepository.save(user);
    }


    public boolean deleteUser(Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setActif(false);
            userRepository.save(user);
            return true;
        }
        return false;
    }

}

