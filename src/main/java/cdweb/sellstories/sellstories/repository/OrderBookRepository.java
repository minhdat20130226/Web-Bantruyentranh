package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {
    @Query("SELECT DISTINCT o.stories.id" +
            " FROM OrderBook o" +
            " WHERE EXISTS (" +
            "     SELECT 1" +
            "     FROM OrderBook ob" +
            "     WHERE ob.stories.id = o.stories.id" +
            "     GROUP BY ob.stories.id" +
            "     HAVING SUM(ob.quantity) >= :larger" +
            " )")
    List<Long> findStoriesWithTotalQuantity(@Param("larger") int larger);

    @Query("SELECT ob.stories.id, SUM(ob.quantity) AS totalQuantity FROM OrderBook ob " +
            "JOIN Category c ON ob.stories.id = c.storiesBook.id " +
            "WHERE ob.quantity > :larger " +
            "AND c.storyGenre.name = :genre " +
            "GROUP BY ob.stories.id " +
            "HAVING SUM(ob.quantity) > :larger")
    List<Object[]> findCategoriesByTotalQuantityAndGenre(@Param("larger") int larger, @Param("genre") String genre);
}
