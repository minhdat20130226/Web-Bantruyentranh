package cdweb.sellstories.sellstories.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_book")
public class PaymentBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_order_book")
    private OrderBook orderBook;

    @Column(name = "amount_paid")
    private double amountPaid;

    @Column(name = "payment_date")
    @CreatedDate
    private LocalDateTime paymentDate;

    @Column(name = "payment_method")
    private String paymentMethod;
}
