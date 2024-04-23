package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("SELECT c.storyAuthor.name, c.storyTranslator.name, c.placePublication.name, c.storyGenre.name FROM Category c")
    List<Object[]> findAllAuthorsTranslatorsPublicationsGenres();


}
