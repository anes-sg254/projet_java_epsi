package galerie.phototheque.service;

import galerie.phototheque.entity.Categorie;
import galerie.phototheque.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImp implements CategorieService{

    @Autowired
    private CategorieRepository CategorieRepository;
    @Override
    public List<Categorie> getAll() {
        return List.of();
    }

    @Override
    public void addCategorie(Categorie categorie) {

    }

    @Override
    public void updateCategorie(Categorie categorie) {

    }

    @Override
    public void deleteCategorie(Categorie categorie) {

    }

    @Override
    public Categorie getCategorieById(Long id) {
        return null;
    }


}
