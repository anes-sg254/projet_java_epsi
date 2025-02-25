package galerie.phototheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("phototheque/")
public class ImageServiceImp {
    @Autowired
    private ImageServiceImp imageService;
    @Autowired
    private UtilisateurServiceImp utilisateurService;
    @Autowired
    private CategorieService categorieService;





}
