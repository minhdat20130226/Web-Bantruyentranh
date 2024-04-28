package cdweb.sellstories.sellstories.entity;

import cdweb.sellstories.sellstories.util.LocalDateTimeUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_stories_book")
    private StoriesBook storiesBook;

    @ManyToOne
    @JoinColumn(name = "id_story_genre")
    private StoryGenre storyGenre;

    @ManyToOne
    @JoinColumn(name = "id_story_translator")
    private StoryTranslator storyTranslator;

    @ManyToOne
    @JoinColumn(name = "id_place_publication")
    private PlacePublication placePublication;

    @ManyToOne
    @JoinColumn(name = "id_story_author")
    private StoryAuthor storyAuthor;

    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(columnDefinition = "VARCHAR(55) DEFAULT 'ngừng hoạt động'")
    private String status;

    public Category(Long id, Long idStoriesBook, Long idStoryGenre, Long idStoryTranslator, Long idPlacePublication, Long idStoryAuthor,String createdDate,String updatedDate, String status) {
        this.id = id;
        this.storiesBook = new StoriesBook(idStoriesBook);
        this.storyGenre = new StoryGenre(idStoryGenre);
        this.storyTranslator = new StoryTranslator(idStoryTranslator);
        this.placePublication = new PlacePublication(idPlacePublication);
        this.storyAuthor = new StoryAuthor(idStoryAuthor);
       this.createdDate = LocalDateTimeUtils.parseDateString(createdDate);
        this.updatedDate = LocalDateTimeUtils.parseDateString(updatedDate);
        this.status = status;
    }

}
