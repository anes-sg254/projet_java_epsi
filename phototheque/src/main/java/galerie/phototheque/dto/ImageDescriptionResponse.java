package galerie.phototheque.dto;

import java.util.List;

public class ImageDescriptionResponse {
    private List<Label> labels;

    // Getters et setters
    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}

