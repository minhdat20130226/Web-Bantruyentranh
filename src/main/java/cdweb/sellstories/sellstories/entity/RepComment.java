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
@Table(name = "rep_commnet")
public class RepComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user_comment")
    private User userComment;

    @ManyToOne
    @JoinColumn(name = "id_user_rep_comment")
    private User userRepComment;

    @Column(name = "content_rep")
    private String contentRep;
    @Column(name = "create_at", columnDefinition = "datetime DEFAULT GETDATE()")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
