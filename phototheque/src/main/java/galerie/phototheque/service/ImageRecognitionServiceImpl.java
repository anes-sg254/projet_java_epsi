package galerie.phototheque.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

@Service
public class ImageRecognitionServiceImpl implements ImageRecognitionService {

    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String apiKey;

    public ImageRecognitionServiceImpl(RestTemplate restTemplate,
                                       @Value("${api.base-url}") String apiUrl,
                                       @Value("${image.recognition.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    @Override
    public String analyzeImage(String imageUrl) {
        String detectUrl = apiUrl + "/detect";

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);
        headers.set("Content-Type", "application/json");

        Map<String, String> body = new HashMap<>();
        body.put("imageUrl", imageUrl);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(detectUrl, HttpMethod.POST, requestEntity, String.class);

        return response.getBody();
    }

    @Override
    public String generateSignedUrl(String filename) {
        return apiUrl + "/generate-signed-url?filename=" + filename;
    }
    public void uploadImageToSignedUrl(String signedUrl, byte[] imageData) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "image/jpeg"); // Ou un autre type selon ton format d'image

        HttpEntity<byte[]> requestEntity = new HttpEntity<>(imageData, headers);

        restTemplate.put(signedUrl, requestEntity);
    }
    @Override
    public String getImageDescription(String filename) {
        String descriptionUrl = apiUrl + "/describe?filename=" + filename;

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                descriptionUrl, HttpMethod.GET, requestEntity, String.class
        );

        return response.getBody();
    }

}
