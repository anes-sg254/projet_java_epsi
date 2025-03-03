package galerie.phototheque.service;

import galerie.phototheque.entity.Categorie;
import galerie.phototheque.repository.CategorieRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }
}