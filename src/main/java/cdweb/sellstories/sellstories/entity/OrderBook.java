package cdweb.sellstories.sellstories.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_book")
public class OrderBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_stories")
    private StoriesBook stories;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "order_date", columnDefinition = "datetime DEFAULT GETDATE()")
    @CreatedDate
    private LocalDateTime orderDate;

    @Column(name = "payment_action")
    private String paymentAction;

}
