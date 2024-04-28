package cdweb.sellstories.sellstories.service;

import cdweb.sellstories.sellstories.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<Object[]> getAllAuthorsTranslatorsPublicationsGenres();
    List<CategoryDTO> getBook();
}
