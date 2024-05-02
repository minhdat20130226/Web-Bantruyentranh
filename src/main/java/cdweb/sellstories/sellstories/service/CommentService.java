package cdweb.sellstories.sellstories.service;

public interface CommentService {
    Long findIdOfBookWithHighestLike();
    Long findIdOfBookWithStarTotal();
}
