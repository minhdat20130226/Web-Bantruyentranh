package cdweb.sellstories.sellstories.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "story_author")
public class StoryAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    private Long id;

    @Column(unique = true,name = "name")
    private String name;

    public StoryAuthor(Long id) {
        this.id = id;
    }
    public StoryAuthor( String name) {
        this.name = name;
    }
}
