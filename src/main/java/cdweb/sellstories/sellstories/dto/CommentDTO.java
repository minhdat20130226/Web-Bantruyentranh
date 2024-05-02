package cdweb.sellstories.sellstories.dto;

import cdweb.sellstories.sellstories.entity.User;
import cdweb.sellstories.sellstories.entity.StoriesBook;
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
    private User user;
    private StoriesBook storiesBook;
    private int starRating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isLike;
    private int likesCount;

    public CommentDTO(StoriesBook storiesBook, int likesCount) {
        this.storiesBook = storiesBook;
        this.likesCount = likesCount;
    }
}

