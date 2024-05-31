package cdweb.sellstories.sellstories.entity;

import cdweb.sellstories.sellstories.util.LocalDateTimeUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content_comment")
    private String contentComment;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_stories_book")
    private StoriesBook storiesBook;

    @Column(name = "star_rating")
    private int starRating;

    @Column(name = "create_at", columnDefinition = "datetime DEFAULT GETDATE()")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Comment(Long id, String contentComment, Long idUser, Long idStoriesBook, int starRating, String createdAt, String updatedAt) {
        this.id = id;
        this.contentComment = contentComment;
        this.user = new User(idUser);
        this.storiesBook = new StoriesBook(idStoriesBook);
        this.starRating = starRating;
        this.createdAt = LocalDateTimeUtils.parseDateString(createdAt);
        this.updatedAt = LocalDateTimeUtils.parseDateString(updatedAt);
    }
    public Comment(Long id) {
        this.id = id;
    }
}

