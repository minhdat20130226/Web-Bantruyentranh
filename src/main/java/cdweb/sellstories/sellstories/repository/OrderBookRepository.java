package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.dto.OrderBookDTO;
import cdweb.sellstories.sellstories.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {
    @Query("SELECT NEW cdweb.sellstories.sellstories.dto.OrderBookDTO(o.stories.id, SUM(o.quantity))" +
            " FROM OrderBook o GROUP BY o.stories.id")
    List<OrderBookDTO> findStoriesWithTotalQuantity();
}
