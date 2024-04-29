package cdweb.sellstories.sellstories.dto;

import cdweb.sellstories.sellstories.entity.OrderBook;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class OrderBookDTO {
    private Long id;
    private Long storiesId;
    private Long userId;
    private String orderCode;
    private String orderStatus;
    private int quantity;
    private String shippingMethod;
    private LocalDateTime orderDate;
    private String paymentAction;
    private Long totalQuantity;

    public OrderBookDTO(Long storiesId, Long totalQuantity) {
        this.storiesId = storiesId;
        this.totalQuantity = totalQuantity;
    }
}