package cdweb.sellstories.sellstories.service;


import cdweb.sellstories.sellstories.dto.CategoryDTO;
import cdweb.sellstories.sellstories.dto.OrderBookDTO;
import cdweb.sellstories.sellstories.dto.ProductBuyDTO;
import cdweb.sellstories.sellstories.entity.Category;
import cdweb.sellstories.sellstories.entity.OrderBook;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderBookService {
    List<Long> findStoriesWithTotalQuantity(int largerValue);
    List<OrderBookDTO>  findCategoriesByTotalQuantityAndGenre(int larger, String genre);
    Long createOrderBook(OrderBookDTO orderBookDTO);
}
