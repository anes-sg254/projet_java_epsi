package galerie.phototheque.service;

import galerie.phototheque.entity.Categorie;
import galerie.phototheque.repository.CategorieRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CategorieService {

    List<Categorie> getAllCategories();
    void addCategorie(Categorie categorie);
    void updateCategorie(Categorie categorie);
    void deleteCategorie(Categorie categorie);
    Categorie getCategorieById(Long id);
}