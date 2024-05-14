package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT cmt.storiesBook.id FROM Comment cmt WHERE cmt.isLike = true GROUP BY cmt.storiesBook.id ORDER BY COUNT(cmt.isLike) DESC LIMIT 1")
    Long findIdOfBookWithHighestLike();
    @Query("SELECT cmt.storiesBook.id FROM Comment cmt GROUP BY cmt.storiesBook.id ORDER BY COUNT(cmt.starRating) DESC LIMIT 1")
    Long findIdOfBookWithStarTotal();
    @Query("SELECT cmt.storiesBook.id FROM Comment cmt GROUP BY cmt.storiesBook.id HAVING SUM(cmt.starRating) > :numberStartFind")
    List<Long> getAllCommentIdStoriesBook(@Param("numberStartFind") int numberStartFind);
}
