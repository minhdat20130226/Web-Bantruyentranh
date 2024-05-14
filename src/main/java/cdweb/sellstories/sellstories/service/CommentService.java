package cdweb.sellstories.sellstories.service;
import java.util.List;

public interface CommentService {
    Long findIdOfBookWithHighestLike();
    Long findIdOfBookWithStarTotal();
    List<Long> getAllCommentIdStoriesBook(int numberStartFind);
}
