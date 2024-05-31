package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.entity.StoriesBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StoriesBookRepository extends JpaRepository<StoriesBook,Long> {
    List<StoriesBook> findAll();

    @Query("SELECT s.id, s.name, s.photoUrl, s.price, s.description, s.readingAge.age, s.status, s.totalChapter, s.createdDate" +
            " FROM StoriesBook s WHERE s.status = :genresOption")
    List<StoriesBook> getBooksWithGenres(@Param("genresOption") String genresOption);

    @Query("SELECT COUNT(sb.readingAge.age) FROM StoriesBook sb WHERE  sb.readingAge.age >= :minAge AND sb.readingAge.age <= :maxAge")
    int countProductsBetweenPrices(@Param("minAge")long minAge, @Param("maxAge") long maxAge);

    @Query("SELECT COUNT(sb.readingAge.age) FROM StoriesBook sb WHERE sb.readingAge.age > :minAge")
    int countProductsGreaterThanPrice(@Param("minAge") long minAge);

    @Query("SELECT sb.id FROM StoriesBook sb WHERE sb.createdDate = (SELECT MAX(sb2.createdDate) FROM StoriesBook sb2)")
    Long findIdOfLatestCreatedStoriesBook();



}

