package galerie.phototheque.service;

import galerie.phototheque.entity.Images;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ImageService {
    public Map<String, String> generateSignedUrl(String filename);
    public void uploadFile(String signedUrl, byte[] fileContent, String contentType);
    public Map<String, Object> getImageDescription(String filename);
    public List<Images> getLatestImages();
    public Images getImageDetails(Long id);
    public String getOriginalImageUrl(Long id);
    public String getThumbnailImageUrl(Long id);
    public List<Images> searchImages(String name, String description, int page, int size);
    public Images updateImageDetails(Long id, Images imageDetails);
    public void deleteImage(Long id);
}
