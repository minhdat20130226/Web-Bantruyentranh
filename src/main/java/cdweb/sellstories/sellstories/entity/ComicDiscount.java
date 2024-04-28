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
@Table(name = "comic_discount")
public class ComicDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_stories_book")
    private StoriesBook storiesBook;

    @Column(name = "reduction_rate")
    private int reduction_rate;

    @Column(name = "decrease_day")
    private LocalDateTime decreaseDay;

    @Column(name = "expiration_date_reduced")
    private LocalDateTime expirationDateDeduced;

    @Column(name = "add_day")
    private LocalDateTime add_day;

    public ComicDiscount(Long id,StoriesBook storiesBook, int reduction_rate) {
        this.id = id;
        this.storiesBook = storiesBook;
        this.reduction_rate = reduction_rate;
        this.decreaseDay = LocalDateTime.now();
        this.add_day = LocalDateTime.now();
    }
}