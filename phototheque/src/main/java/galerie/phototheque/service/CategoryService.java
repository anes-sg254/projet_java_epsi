package galerie.phototheque.service;

import com.projet.phototheque.dto.CategoryDTO;
import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    List<String> getCategoryPictures(Long categoryId);
}