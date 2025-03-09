package galerie.phototheque.controller;
import org.springframework.http.HttpStatus;
import galerie.phototheque.dto.ImageUploadDTO;
import galerie.phototheque.entity.Image;
import galerie.phototheque.entity.User;
import galerie.phototheque.service.ImageService;
import galerie.phototheque.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/images", produces = MediaType.APPLICATION_JSON_VALUE)

public class ImageController {

    private final ImageService imageService;
    private final UserService userService;
    @Autowired
    public ImageController(ImageService imageService, UserService userService) {
        this.imageService = imageService;
        this.userService = userService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestBody ImageUploadDTO imageUploadDTO) {
        if (imageUploadDTO.getNom() == null || imageUploadDTO.getNom().isEmpty()) {
            return ResponseEntity.badRequest().body("Erreur : Le nom de l'image est obligatoire.");
        }
        if (imageUploadDTO.getUrl() == null || imageUploadDTO.getUrl().isEmpty()) {
            return ResponseEntity.badRequest().body("Erreur : L'URL de l'image est obligatoire.");
        }

        Optional<User> userOpt = userService.getUserById(imageUploadDTO.getUserId());
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erreur : Utilisateur avec l'ID " + imageUploadDTO.getUserId() + " non trouvé.");
        }

        User user = userOpt.get();
        Image image = new Image();
        image.setNom(imageUploadDTO.getNom());
        image.setDescription(imageUploadDTO.getDescription());
        image.setUrl(imageUploadDTO.getUrl());
        image.setUtilisateur(user);
        image.setDateCreation(LocalDateTime.now());
        image.setDateUpload(LocalDateTime.now());

        return ResponseEntity.ok(imageService.uploadImage(image));
    }

    @PostMapping("/uploadAndDetect")
    public ResponseEntity<String> uploadAndDetect(@RequestParam("file") MultipartFile file) {
        try {
            String filename = file.getOriginalFilename();
            byte[] imageBytes = file.getBytes();

            // Appelle le service pour upload et analyser l'image
            String description = imageService.uploadAndAnalyzeImage(filename, imageBytes);

            return ResponseEntity.ok(description);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'upload et de l'analyse : " + e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Long id) {
        return imageService.getImageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/latest")
    public ResponseEntity<List<Image>> getLatestImages() {
        return ResponseEntity.ok(imageService.getLatestImages());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateImageDetails(@PathVariable Long id, @RequestParam String nom, @RequestParam String description) {
        imageService.updateImageDetails(id, nom, description);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable Long id) {
        try {
            imageService.deleteImage(id);
            return ResponseEntity.ok("Image supprimée avec succès");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image non trouvée");
        }
    }

}