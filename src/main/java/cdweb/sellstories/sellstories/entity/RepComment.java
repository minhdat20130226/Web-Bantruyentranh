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
@Table(name = "rep_commnet")
public class RepComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_comment")
    private Comment comment;

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

    @Column(name = "total_like_comment")
    private int totalLikeComment;

    public RepComment(Long id, Long idComment, Long idUserRepComment, String contentRep, String createdAt, String updatedAt,int totalLikeComment) {
        this.id = id;
        this.comment = new Comment(idComment);
        this.userRepComment = new User(idUserRepComment);
        this.contentRep = contentRep;
        this.createdAt = LocalDateTimeUtils.parseDateString(createdAt);
        this.updatedAt = LocalDateTimeUtils.parseDateString(updatedAt);
        this.totalLikeComment = totalLikeComment;
    }
}
