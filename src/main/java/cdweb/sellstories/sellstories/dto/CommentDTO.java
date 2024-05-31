package cdweb.sellstories.sellstories.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CommentDTO {
    private Long id;
    private String contentComment;
    private UserDTO userDTO;
    private Long idStoriesBook;
    private int starRating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int likesCountComment;

}

