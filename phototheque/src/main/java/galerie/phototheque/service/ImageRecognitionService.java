package galerie.phototheque.service;

import galerie.phototheque.dto.ImageDescriptionResponse;
import galerie.phototheque.dto.SignedUrlResponse;

public interface ImageRecognitionService {
    public SignedUrlResponse generateSignedUrl(String filename);
    public void uploadImageToSignedUrl(String signedUrl, String filePath);
    public ImageDescriptionResponse getImageDescription(String filename);
}
