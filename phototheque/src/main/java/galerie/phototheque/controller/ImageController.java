package galerie.phototheque.controller;

import galerie.phototheque.dto.ImageDto;
import galerie.phototheque.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping
    public List<ImageDto> getAllImages() {
        return imageService.getAllImages();
    }
}

