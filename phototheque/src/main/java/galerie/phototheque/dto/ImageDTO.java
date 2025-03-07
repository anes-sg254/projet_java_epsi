package galerie.phototheque.dto;

import lombok.Data;
import java.util.List;

@Data
public class ImageDTO {
    private Long id;
    private String name;
    private String category;
    private String description;
    private long size;
    private String createdAt;
    private String updatedAt;
    private List<String> detectedObjects;
    private boolean containsPerson;
    private String originalUrl;
    private String thumbnailUrl;
}
