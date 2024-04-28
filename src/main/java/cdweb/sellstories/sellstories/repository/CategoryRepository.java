package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.dto.CategoryDTO;
import cdweb.sellstories.sellstories.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("SELECT c.storyAuthor.name, c.storyTranslator.name, c.placePublication.name, c.storyGenre.name FROM Category c")
    List<Object[]> findAllAuthorsTranslatorsPublicationsGenres();


    @Query("SELECT  NEW cdweb.sellstories.sellstories.dto.CategoryDTO(c.storiesBook.id, c.storyAuthor.name, c.storyTranslator.name, c.placePublication.name, c.storyGenre.name, cd.reduction_rate, c.createdDate, c.status)" +
            "FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE (cd.decreaseDay <= CURRENT_TIMESTAMP AND (cd.expirationDateDeduced IS NULL OR cd.expirationDateDeduced >= CURRENT_TIMESTAMP))")
    List<CategoryDTO> getBooks();

}
