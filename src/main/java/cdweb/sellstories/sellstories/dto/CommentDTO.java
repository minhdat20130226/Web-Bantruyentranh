package cdweb.sellstories.sellstories.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Long id;
    private String contentComment;
    private Long idUser;
    private Long idStoriesBook;
    private int starRating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isLike;
    private int likesCount;

}

