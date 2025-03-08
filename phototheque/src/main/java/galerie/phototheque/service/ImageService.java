package galerie.phototheque.service;

import galerie.phototheque.entity.*;
import galerie.phototheque.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
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
        return imageRepository.findByIdAndActifTrue(id);
    }


    public Image uploadImage(Image image) {
        System.out.println("Nom: " + image.getNom());
        System.out.println("Description: " + image.getDescription());
        System.out.println("URL: " + image.getUrl());
        System.out.println("Utilisateur: " + (image.getUtilisateur() != null ? image.getUtilisateur().getId() : "NULL"));
        System.out.println("Date Creation: " + image.getDateCreation());

        if (image.getDateCreation() == null) {
            System.out.println("ERREUR: dateCreation est NULL avant l'enregistrement !");
            image.setDateCreation(LocalDateTime.now());
        }

        return imageRepository.save(image);
    }


    public void updateImageDetails(Long id, String nom, String description) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image non trouvée"));

        image.setNom(nom);
        image.setDescription(description);
        imageRepository.save(image);
    }


    public void deleteImage(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image non trouvée"));

        image.setActif(false);
        imageRepository.save(image);
    }

    public List<Image> getLatestImages() {
        return imageRepository.findTop10ByActifTrueOrderByDateCreationDesc();
    }
}
