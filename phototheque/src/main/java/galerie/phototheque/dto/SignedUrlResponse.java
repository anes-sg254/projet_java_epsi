package galerie.phototheque.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignedUrlResponse {
    private String filename;
    private String SignedUrl;

    public String getSignedUrl() {
        return SignedUrl;
    }

    public String getFilename() {
        return filename;
    }
}
