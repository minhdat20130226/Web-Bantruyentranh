package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.repository.CommentRepository;
import cdweb.sellstories.sellstories.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentImpl implements CommentService {
    final CommentRepository commentRepository;

    @Override
    public Long findIdOfBookWithHighestLike() {
        return commentRepository.findIdOfBookWithHighestLike();
    }

    @Override
    public Long findIdOfBookWithStarTotal() {
        return commentRepository.findIdOfBookWithStarTotal();
    }

    @Override
    public List<Long> getAllCommentIdStoriesBook(int numberStartFind) {
        return commentRepository.getAllCommentIdStoriesBook(numberStartFind);
    }
}
