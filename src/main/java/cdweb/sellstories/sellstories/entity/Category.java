package cdweb.sellstories.sellstories.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "create_date", columnDefinition ="datetime DEFAULT GETDATE()")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(columnDefinition = "VARCHAR(55) DEFAULT 'ngừng hoạt động'")
    private String status;
}
