package galerie.phototheque.controller;

import galerie.phototheque.dto.*;
import galerie.phototheque.entity.*;
import galerie.phototheque.service.impl.*;
import galerie.phototheque.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {
    @Autowired
    private ImageRecognitionServiceImpl imageRecognitionService;

    @Autowired
    private ImageServiceImpl imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam(name = "filename", required = false) String filename) {

        if (filename == null || filename.isEmpty()) {
            return ResponseEntity.badRequest().body("Le paramètre 'filename' est requis.");
        }

        try {

            SignedUrlResponse signedUrlResponse = imageRecognitionService.generateSignedUrl(filename);


            String filePath = "C:/Users/Anes/Desktop" + filename;


            imageRecognitionService.uploadImageToSignedUrl(signedUrlResponse.getSignedUrl(), filePath);


            ImageDescriptionResponse descriptionResponse = imageRecognitionService.getImageDescription(signedUrlResponse.getFilename());


            return ResponseEntity.ok(descriptionResponse.getLabels().toString());
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors du traitement de l'image : " + e.getMessage());
        }
    }





    @GetMapping("/latest")
    public ResponseEntity<List<galerie.phototheque.entity.Images>> getLatestImages() {
        List<Images> images = imageService.getLatestImages();
        return ResponseEntity.ok(images);
    }


    @GetMapping("/{id}")
    public ResponseEntity<galerie.phototheque.entity.Images> getImageDetails(@PathVariable Long id) {
        Images image = imageService.getImageDetails(id);
        return ResponseEntity.ok(image);
    }


   // @GetMapping("/{id}/original")
    //public ResponseEntity<?> getOriginalImage(@PathVariable Long id) {
        //String url = imageService.getOriginalImageUrl(id);
        //return ResponseEntity.ok(Map.of("originalUrl", url));
    //}

    @GetMapping("/{id}/thumbnail")
    public ResponseEntity<?> getThumbnailImage(@PathVariable Long id) {
        String url = imageService.getThumbnailImageUrl(id);
        return ResponseEntity.ok(Map.of("thumbnailUrl", url));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateImageDetails(@PathVariable Long id,
                                                @RequestBody Images imageDetails) {
        Images updatedImage = imageService.updateImageDetails(id, imageDetails);
        return ResponseEntity.ok(updatedImage);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return ResponseEntity.ok("Image supprimée logiquement.");
    }
}
