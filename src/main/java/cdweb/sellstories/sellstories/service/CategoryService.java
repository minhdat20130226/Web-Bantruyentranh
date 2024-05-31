package cdweb.sellstories.sellstories.service;

import cdweb.sellstories.sellstories.dto.CategoryDTO;
import cdweb.sellstories.sellstories.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryService {
    List<Object[]> getAllAuthorsTranslatorsPublicationsGenres();
    CategoryDTO findByStoriesBookId(Long storiesBookId);
    List<CategoryDTO> getBookByStatus(String statusBook);
    int countBooksByAuthorId(long authorId);
    int countBooksByPlacePublication(long publicationId);
    int countBooksByGenreId(Long genreId);
    List<CategoryDTO> findBooksByGenresOptionAndNameBook(String nameBook);
    List<CategoryDTO> findBooksByGenresOptionAndNameBook(String genresOption, String nameBook);
    List<CategoryDTO> findBooksByListProductSame(String type,String valueFind);
    Page<CategoryDTO> findGetCategoryFind(String codeCategory, String valueSession, String filterValue,int page,int size);
}
