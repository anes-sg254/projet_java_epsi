package galerie.phototheque.service.impl;

import galerie.phototheque.entity.*;
import galerie.phototheque.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;



@Service
public class ImageServiceImpl {


    @Autowired
    private ImageRepository imageRepository;


    public List<Images> getLatestImages() {
        return imageRepository.findTop10ByOrderByCreatedAtDesc();
    }


    public Images getImageDetails(Long id) {
        return imageRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found with id: " + id));
    }

   public String getOriginalImageUrl(Long id) {
        Images image = imageRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found with id: " + id));
        return image.getUrlOriginale();
   }

   public String getThumbnailImageUrl(Long id) {
       Images image = imageRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found with id: " + id));
        return image.getUrlMiniature();
   }

    public Images updateImageDetails(Long id, Images imageDetails) {
        Images image = imageRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found with id: " + id));
        image.setNom(imageDetails.getNom());
        image.setDescription(imageDetails.getDescription());
        image.setTaille(imageDetails.getTaille());
        image.setUrlOriginale(imageDetails.getUrlOriginale());
        image.setUrlMiniature(imageDetails.getUrlMiniature());
        image.setPresenceIndividus(imageDetails.getPresenceIndividus());
        image.setObjetsDetectes(imageDetails.getObjetsDetectes());
        return imageRepository.save(image);
    }

    public void deleteImage(Long id) {
        Images image = imageRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found with id: " + id));
        image.setDeletedAt(LocalDateTime.now());
        imageRepository.save(image);
    }

}
