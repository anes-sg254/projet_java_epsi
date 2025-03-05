package galerie.phototheque.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Label {
    private String nom;      // Nom du label (par exemple, "Car", "Wheel")
    private double confidence; // Confiance associée au label (par exemple, 100.0)

    // Getters et setters
    public String getName() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    @Override
    public String toString() {
        return "Label{" +
                "name='" + nom + '\'' +
                ", confidence=" + confidence +
                '}';
    }
}
