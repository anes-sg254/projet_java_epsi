package galerie.phototheque.service;

public interface ImageRecognitionService {
    String analyzeImage(String imageUrl);
    String generateSignedUrl(String filename);
    void uploadImageToSignedUrl(String signedUrl, byte[] imageData);
    String getImageDescription(String filename);
}