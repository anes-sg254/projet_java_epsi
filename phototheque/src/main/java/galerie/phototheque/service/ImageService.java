package galerie.phototheque.services;

import galerie.phototheque.dto.ImageDTO;
import galerie.phototheque.entity.Image;
import galerie.phototheque.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public List<ImageDTO> getAllImages() {
        return imageRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ImageDTO convertToDTO(Image image) {
        ImageDTO dto = new ImageDTO();
        dto.setId(image.getIdImage());
        dto.setNom(image.getNom());
        dto.setDescription(image.getDescription());
        dto.setCategorie(image.getCategorie().getNom());
        dto.setPresenceIndividu(image.isPresenceIndividu());
        dto.setCompteurTelechargements(image.getCompteurTelechargements());
        dto.setUrlTailleReelle(image.getUrlTailleReelle());
        dto.setUrlMiniature(image.getUrlMiniature());
        dto.setDateCreation(image.getDateCreation());
        return dto;
    }
}
