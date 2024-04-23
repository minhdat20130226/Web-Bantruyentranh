package cdweb.sellstories.sellstories.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    private Long id;
    private String name;
    private String description;

    public Permission(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
