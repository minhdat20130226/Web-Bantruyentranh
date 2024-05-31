package cdweb.sellstories.sellstories.service;
import cdweb.sellstories.sellstories.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    Long findIdOfBookWithStarTotal();
    List<Long> getAllCommentIdStoriesBook(int numberStartFind);
    List<CommentDTO> findAllByIdStoriesBook(int numberStartFind);
}
