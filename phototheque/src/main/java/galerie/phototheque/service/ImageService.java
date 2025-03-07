package galerie.phototheque.service;

import galerie.phototheque.entity.*;
import galerie.phototheque.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service

public class ImageService {

    private final ImageRepository imageRepository;

    private final UserRepository userRepository;


    @Autowired
    public ImageService(ImageRepository imageRepository, UserRepository userRepository) {
        this.imageRepository = imageRepository;
        this.userRepository=userRepository;
    }
    public List<Image> getUserImages(User user) {
        return imageRepository.findByUtilisateurAndActifTrue(user);
    }


    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }


    public Image uploadImage(Image image) {
        return imageRepository.save(image);
    }


    public void updateImageDetails(Long id, String nom, String description) {
        imageRepository.findById(id).ifPresent(image -> {
            image.setNom(nom);
            image.setDescription(description);
            imageRepository.save(image);
        });
    }


    public void deleteImage(Long id) {
        imageRepository.findById(id).ifPresent(image -> {
            image.setActif(false);
            imageRepository.save(image);
        });
    }


    public List<Image> getLatestImages() {
        return imageRepository.findTop10ByOrderByDateCreationDesc();
    }
}
