package galerie.phototheque.controller;

import galerie.phototheque.dto.ImageUploadDTO;
import galerie.phototheque.entity.Image;
import galerie.phototheque.entity.User;
import galerie.phototheque.service.ImageService;
import galerie.phototheque.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/images")

public class ImageController {

    private final ImageService imageService;
    private final UserService userService;
    @Autowired // ✅ Injecte les services avec un constructeur
    public ImageController(ImageService imageService, UserService userService) {
        this.imageService = imageService;
        this.userService = userService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Image> uploadImage(@RequestBody ImageUploadDTO imageUploadDTO) {
        User user = userService.getUserById(imageUploadDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        Image image = new Image();
        image.setNom(imageUploadDTO.getNom());
        image.setDescription(imageUploadDTO.getDescription());
        image.setUrl(imageUploadDTO.getUrl());  // Assurez-vous que ImageUploadDTO contient bien `url`
        image.setUtilisateur(user);
        image.setDateUpload(LocalDateTime.now());

        return ResponseEntity.ok(imageService.uploadImage(image));
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
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}
