package galerie.phototheque.service.impl;

import galerie.phototheque.dto.*;
import galerie.phototheque.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ImageRecognitionServiceImpl implements ImageRecognitionService {


    @Value("${image.recognition.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public SignedUrlResponse generateSignedUrl(String filename) {
        String url = "https://uf8m8gb2k0.execute-api.eu-central-1.amazonaws.com/epsi/generate-signed-url";
        String jsonBody = "{ \"filename\": \"" + filename + "\" }";

        HttpHeaders headers = new HttpHeaders();
        headers.set("image.recognition.api.key", apiKey);
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);

        ResponseEntity<SignedUrlResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity, SignedUrlResponse.class);

        if(response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Failed to generate signed URL: " + response.getBody());
        }

        return response.getBody();
    }


    public void uploadImageToSignedUrl(String signedUrl, String filePath) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "image/jpeg");

        byte[] fileBytes = null;
        try {
            fileBytes = Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the image file: " + e.getMessage());
        }

        HttpEntity<byte[]> entity = new HttpEntity<>(fileBytes, headers);

        try {
            restTemplate.exchange(signedUrl, HttpMethod.PUT, entity, Void.class);
        } catch (HttpClientErrorException e) {
            // Log and throw if API returns a 403 error
            if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
                throw new RuntimeException("Permission denied: Unable to upload to the signed URL.");
            }
            throw new RuntimeException("Error uploading image: " + e.getResponseBodyAsString());
        }
    }

    public ImageDescriptionResponse getImageDescription(String filename) {
        String url = "https://uf8m8gb2k0.execute-api.eu-central-1.amazonaws.com/epsi/detect-labels/" + filename;

        HttpHeaders headers = new HttpHeaders();
        headers.set("image.recognition.api.key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ImageDescriptionResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, ImageDescriptionResponse.class);
        return response.getBody();
    }
}
