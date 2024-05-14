package cdweb.sellstories.sellstories.service;


import cdweb.sellstories.sellstories.dto.OrderBookDTO;

import java.util.List;

public interface OrderBookService {
    List<Long> findStoriesWithTotalQuantity(int largerValue);
}
