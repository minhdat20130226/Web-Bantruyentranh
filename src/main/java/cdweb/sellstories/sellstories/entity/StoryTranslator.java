package cdweb.sellstories.sellstories.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "story_tranlator")
public class StoryTranslator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    private Long id;
    @Column(unique = true,name = "name")
    private String name;

    public StoryTranslator(Long id) {
        this.id = id;
    }
    public StoryTranslator( String name) {
        this.name = name;
    }
}
