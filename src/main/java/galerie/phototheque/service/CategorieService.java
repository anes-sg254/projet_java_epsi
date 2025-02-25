package galerie.phototheque.service;

import galerie.phototheque.entity.Categorie;

import java.util.List;

public interface CategorieService {
    List<Categorie> getAll();
    void addCategorie (Categorie categorie);
    void updateCategorie(Categorie categorie);
    void deleteCategorie(Categorie categorie);
    Categorie getCategorieById(Long id);
}
