package cdweb.sellstories.sellstories.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "story_genre")
public class StoryGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    private Long id;
    @Column(name = "name")
    private String name;

    public StoryGenre(Long id) {
        this.id = id;
    }

}