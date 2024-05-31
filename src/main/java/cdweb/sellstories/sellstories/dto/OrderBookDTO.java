package cdweb.sellstories.sellstories.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class OrderBookDTO {
    private Long id;
    private Long storiesId;
    private Long userId;
    private String orderCode;
    private String orderStatus;
    private int quantity;
    private String methodTransport;
    private LocalDateTime orderDate;
    private String paymentAction;
    private int totalQuantity;

    public OrderBookDTO(Long storiesId, int totalQuantity) {
        this.storiesId = storiesId;
        this.totalQuantity = totalQuantity;
    }
}