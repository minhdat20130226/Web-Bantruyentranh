package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.dto.OrderBookDTO;
import cdweb.sellstories.sellstories.entity.OrderBook;
import cdweb.sellstories.sellstories.repository.OrderBookRepository;
import cdweb.sellstories.sellstories.service.OrderBookService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderBookImpl implements OrderBookService {
    final OrderBookRepository orderBookRepository;

    @Override
    public List<OrderBookDTO> findStoriesWithTotalQuantity() {
        return orderBookRepository.findStoriesWithTotalQuantity();
    }

    @PostConstruct
    public void addDefaultStoryTranslator() {
        orderBookRepository.saveAll(storyTranslator);
    }

    List<OrderBook> storyTranslator = Arrays.asList(
            new OrderBook(1L, 1L, 1L, "ABC123", "Pending", 3, "Express", "2022/01/01 10:00:00", "Payment1"),
            new OrderBook(2L, 5L, 2L, "DEF456", "Completed", 2, "Standard", "2022/02/02 15:30:00", "Payment2"),
            new OrderBook(3L, 10L, 3L, "GHI789", "In Progress", 1, "Express", "2022/03/03 09:45:00", "Payment3"),
            new OrderBook(4L, 20L, 4L, "JKL012", "Pending", 4, "Standard", "2022/04/04 14:15:00", "Payment4"),
            new OrderBook(5L, 50L, 5L, "MNO345", "Completed", 2, "Express", "2022/05/05 11:30:00", "Payment5"),
            new OrderBook(6L, 15L, 6L, "PQR678", "In Progress", 3, "Standard", "2022/06/06 16:45:00", "Payment6"),
            new OrderBook(7L, 30L, 7L, "STU901", "Pending", 1, "Express", "2022/07/07 12:00:00", "Payment7"),
            new OrderBook(8L, 90L, 8L, "VWX234", "Completed", 5, "Standard", "2022/08/08 09:15:00", "Payment8"),
            new OrderBook(9L, 75L, 9L, "YZA567", "In Progress", 2, "Express", "2022/09/09 13:30:00", "Payment9"),
            new OrderBook(10L, 37L, 10L, "BCD890", "Pending", 4, "Standard", "2022/10/10 17:45:00", "Payment10"),
            new OrderBook(11L, 95L, 1L, "EFG123", "Completed", 3, "Express", "2022/11/11 10:30:00", "Payment11"),
            new OrderBook(12L, 10L, 3L, "GHI189", "In Progress", 1, "Express", "2022/03/03 09:45:00", "Payment3"),
            new OrderBook(13L, 20L, 4L, "JKL012", "Pending", 4, "Standard", "2022/04/04 14:15:00", "Payment4"),
            new OrderBook(14L, 50L, 5L, "MNO345", "Completed", 2, "Express", "2022/05/05 11:30:00", "Payment5"),
            new OrderBook(15L, 15L, 6L, "PQR678", "In Progress", 3, "Standard", "2022/06/06 16:45:00", "Payment6"),
            new OrderBook(16L, 30L, 7L, "STU901", "Pending", 1, "Express", "2022/07/07 12:00:00", "Payment7"),
            new OrderBook(17L, 90L, 8L, "VWX234", "Completed", 5, "Standard", "2022/08/08 09:15:00", "Payment8"),
            new OrderBook(18L, 75L, 9L, "YZA567", "In Progress", 2, "Express", "2022/09/09 13:30:00", "Payment9"),
            new OrderBook(19L, 37L, 10L, "BCD890", "Pending", 4, "Standard", "2022/10/10 17:45:00", "Payment10"),
            new OrderBook(20L, 12L, 2L, "HIJ345", "Pending", 2, "Express", "2022/12/12 14:30:00", "Payment12"),
            new OrderBook(21L, 25L, 3L, "KLM678", "Completed", 1, "Standard", "2023/01/01 11:45:00", "Payment13"),
            new OrderBook(22L, 80L, 4L, "NOP901", "In Progress", 3, "Express", "2023/02/02 16:00:00", "Payment14"),
            new OrderBook(23L, 60L, 5L, "QRS234", "Pending", 2, "Standard", "2023/03/03 12:15:00", "Payment15"),
            new OrderBook(24L, 70L, 6L, "TUV567", "Completed", 4, "Express", "2023/04/04 10:30:00", "Payment16"),
            new OrderBook(25L, 40L, 7L, "WXY890", "In Progress", 1, "Standard", "2023/05/05 14:45:00", "Payment17"),
            new OrderBook(26L, 85L, 8L, "ZAB123", "Pending", 3, "Express", "2023/06/06 11:00:00", "Payment18"),
            new OrderBook(27L, 55L, 9L, "CDE456", "Completed", 2, "Standard", "2023/07/07 15:15:00", "Payment19"),
            new OrderBook(28L, 65L, 10L, "FGH789", "In Progress", 4, "Express", "2023/08/08 13:30:00", "Payment20"),
            new OrderBook(29L, 77L, 1L, "IJK012", "Pending", 1, "Standard", "2023/09/09 09:45:00", "Payment21")
    );


}
