package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.dto.CommentDTO;
import cdweb.sellstories.sellstories.dto.UserDTO;
import cdweb.sellstories.sellstories.entity.Comment;
import cdweb.sellstories.sellstories.repository.CommentRepository;
import cdweb.sellstories.sellstories.service.CommentService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentImpl implements CommentService {
    final CommentRepository commentRepository;


    @Override
    public Long findIdOfBookWithStarTotal() {
        return commentRepository.findIdOfBookWithStarTotal();
    }

    @Override
    public List<Long> getAllCommentIdStoriesBook(int numberStartFind) {
        return commentRepository.getAllCommentIdStoriesBook(numberStartFind);
    }

    @Override
    public List<CommentDTO> findAllByIdStoriesBook(int bookId) {
        List<Object[]> comments = commentRepository.findAllByIdStoriesBook(bookId);
        List<CommentDTO> commentDTOList = new ArrayList<>();
        for (Object[] row : comments) {
            Long id = (Long) row[0];
            String contentComment = (String) row[1];
            long userId = (long) row[2];
            String fullName = (String) row[3];
            LocalDateTime createdAt = (LocalDateTime) row[4];
            UserDTO userDTO = UserDTO.builder()
                    .id(userId)
                    .fullName(fullName)
                    .build();
            CommentDTO commentDTO = CommentDTO.builder()
                    .id(id)
                    .contentComment(contentComment)
                    .userDTO(userDTO)
                    .createdAt(createdAt)
                    .build();
            commentDTOList.add(commentDTO);
        }

        return commentDTOList;
    }

    @PostConstruct
    public void addDefaultComment() {
        commentRepository.saveAll(lsComment);
    }

    List<Comment> lsComment = Arrays.asList(
            new Comment(1L, "Câu chuyện tuyệt vời!", 1L, 1L, 4, "2023/04/15 10:30:00", "2023/04/15 10:30:00"),
            new Comment(2L, "Tôi rất yêu thích nó!", 2L, 1L, 5, "2023/04/16 14:45:00", "2023/04/16 14:45:00"),
            new Comment(3L, "Twist kịch tính thú vị.", 3L, 2L, 3, "2023/04/17 08:20:00", "2023/04/17 08:20:00"),
            new Comment(4L, "Không phải là thứ tôi ưa thích.", 4L, 3L, 2, "2023/04/18 16:10:00", "2023/04/18 16:10:00"),
            new Comment(5L, "Được viết rất tốt.", 5L, 1L, 4, "2023/04/19 11:50:00", "2023/04/19 11:50:00"),
            new Comment(6L, "Tôi mong chờ những tập tiếp theo.", 1L, 2L, 5, "2023/04/20 13:25:00", "2023/04/20 13:25:00"),
            new Comment(7L, "Kết thúc thất vọng.", 2L, 1L, 3, "2023/04/21 09:00:00", "2023/04/21 09:00:00"),
            new Comment(8L, "Xây dựng thế giới tuyệt vời.", 3L, 3L, 4, "2023/04/22 15:40:00", "2023/04/22 15:40:00"),
            new Comment(9L, "Cần phát triển nhân vật hơn.", 4L, 3L, 3, "2023/04/23 07:30:00", "2023/04/23 07:30:00"),
            new Comment(10L, "Khiến tôi ngồi bên mép ghế.", 5L, 10L, 5, "2023/04/24 14:15:00", "2023/04/24 14:15:00"),
            new Comment(11L, "Các nhân vật được khắc họa rất sống động và thu hút.", 1L, 11L, 4, "2023/04/25 11:20:00", "2023/04/25 11:20:00"),
            new Comment(12L, "Tôi bị cuốn hút vào câu chuyện và không thể rời mắt khỏi màn hình.", 2L, 12L, 5, "2023/04/26 16:45:00", "2023/04/26 16:45:00"),
            new Comment(13L, "Cảm giác như đang lạc vào một thế giới hoàn toàn khác.", 3L, 1L, 4, "2023/04/27 09:00:00", "2023/04/27 09:00:00"),
            new Comment(14L, "Tôi không thể đoán được kết cục, rất bất ngờ.", 4L, 12L, 4, "2023/04/28 14:30:00", "2023/04/28 14:30:00"),
            new Comment(15L, "Phát âm và dịch thuật tuyệt vời, khiến tôi thích thú.", 5L, 12L, 5, "2023/04/29 13:10:00", "2023/04/29 13:10:00"),
            new Comment(16L, "Một câu chuyện đầy cảm xúc và truyền cảm hứng.", 1L, 21L, 5, "2023/04/30 17:45:00", "2023/04/30 17:45:00"),
            new Comment(17L, "Tôi đã xem đi xem lại vài lần rồi và vẫn không thể ngừng nghĩ về nó.", 2L, 11L, 5, "2023/05/01 10:00:00", "2023/05/01 10:00:00"),
            new Comment(18L, "Bối cảnh và âm nhạc rất ấn tượng, tăng thêm sự hấp dẫn.", 3L, 12L, 4, "2023/05/02 15:20:00", "2023/05/02 15:20:00"),
            new Comment(19L, "Tôi thực sự muốn chia sẻ trải nghiệm này với bạn bè.", 4L, 12L, 5, "2023/05/03 08:40:00", "2023/05/03 08:40:00"),
            new Comment(20L, "Một tác phẩm tuyệt vời, xứng đáng với mọi lời khen ngợi.", 5L, 10L, 5, "2023/05/04 13:55:00", "2023/05/04 13:55:00"),
            new Comment(21L, "Tôi đã xem nó hàng chục lần và vẫn không chán.", 1L, 2L, 5, "2023/05/05 11:30:00", "2023/05/05 11:30:00"),
            new Comment(22L, "Một trong những tác phẩm hay nhất tôi từng xem.", 2L, 13L, 5, "2023/05/06 16:20:00", "2023/05/06 16:20:00"),
            new Comment(23L, "Tôi đã giới thiệu cho gia đình và bạn bè xem, ai cũng rất thích.", 3L, 31L, 5, "2023/05/07 09:45:00", "2023/05/07 09:45:00"),
            new Comment(24L, "Nội dung phong phú, kịch tính và đẫy đà cảm xúc.", 4L, 11L, 5, "2023/05/08 14:00:00", "2023/05/08 14:00:00"),
            new Comment(25L, "Trải nghiệm xem tuyệt vời, khiến tôi ấn tượng mãi.", 5L, 10L, 5, "2023/05/09 12:10:00", "2023/05/09 12:10:00"),
            new Comment(26L, "Tác phẩm này đáng được biết đến rộng rãi hơn.", 1L, 16L, 5, "2023/05/10 17:35:00", "2023/05/10 17:35:00"),
            new Comment(27L, "Tôi đã xem nó vài lần và vẫn không thể rời mắt khỏi màn hình.", 2L, 16L, 5, "2023/05/11 10:50:00", "2023/05/11 10:50:00"),
            new Comment(28L, "Nội dung phức tạp nhưng rất hấp dẫn, khiến người xem không thể ngừng suy ngẫm.", 3L, 1L, 5, "2023/05/12 15:15:00", "2023/05/12 15:15:00"),
            new Comment(29L, "Tôi không thể tìm ra từ nào để tả được độ hoàn hảo của tác phẩm này.", 4L, 17L, 5, "2023/05/13 08:20:00", "2023/05/13 08:20:00"),
            new Comment(30L, "Mỗi lần xem lại, tôi lại khám phá được thêm nhiều điều mới lạ.", 5L, 5L, 5, "2023/05/14 13:40:00", "2023/05/14 13:40:00"),
            new Comment(31L, "Một trong những tác phẩm hay nhất tôi từng xem trong đời.", 1L, 5L, 5, "2023/05/15 11:00:00", "2023/05/15 11:00:00"),
            new Comment(32L, "Tôi đã giới thiệu cho đến cả hàng xóm xem và ai cũng phấn khích.", 2L, 8L, 5, "2023/05/16 16:30:00", "2023/05/16 16:30:00"),
            new Comment(33L, "Tôi đã xem nó hàng chục lần và vẫn không thấy chán.", 3L, 8L, 5, "2023/05/17 09:00:00", "2023/05/17 09:00:00"),
            new Comment(34L, "Tác phẩm này đạt đến tầm cao mới về nghệ thuật kể chuyện.", 4L, 4L, 5, "2023/05/18 14:25:00", "2023/05/18 14:25:00"),
            new Comment(35L, "Tôi đã giới thiệu cho tất cả bạn bè và gia đình xem, ai cũng rất thích.", 5L, 4L, 5, "2023/05/19 12:15:00", "2023/05/19 12:15:00"),
            new Comment(36L, "Tôi cảm thấy như đang đặt chân vào một thế giới hoàn toàn khác.", 1L, 4L, 5, "2023/05/20 17:40:00", "2023/05/20 17:40:00"),
            new Comment(37L, "Đây là một trong những tác phẩm hay nhất tôi từng xem.", 2L, 1L, 5, "2023/05/21 11:00:00", "2023/05/21 11:00:00"),
            new Comment(38L, "Mỗi lần xem lại, tôi lại khám phá thêm những điều mới lạ.", 3L, 9L, 5, "2023/05/22 15:20:00", "2023/05/22 15:20:00"),
            new Comment(39L, "Tôi đã xem đi xem lại nhiều lần và vẫn không thể rời mắt.", 4L, 9L, 5, "2023/05/23 08:30:00", "2023/05/23 08:30:00"),
            new Comment(40L, "Một tác phẩm hoàn hảo từ mọi khía cạnh.", 5L, 9L, 5, "2023/05/24 13:50:00", "2023/05/24 13:50:00"),
            new Comment(41L, "Trải nghiệm xem tuyệt vời, khiến tôi ấn tượng mãi.", 2L, 31L, 5, "2023/05/09 12:10:00", "2023/05/09 12:10:00"),
            new Comment(42L, "Tôi đã xem video này rất nhiều lần và luôn cảm thấy rất thích thú.", 2L, 33L, 8, "2023/05/10 09:20:00", "2023/05/10 09:20:00"),
            new Comment(43L, "Nội dung video rất hữu ích, tôi đã học được nhiều điều mới.", 2L, 32L, 12, "2023/05/11 14:35:00", "2023/05/11 14:35:00"),
            new Comment(44L, "Tuyệt vời! Tôi thực sự ấn tượng với cách trình bày và giải thích trong video.", 4L, 4L, 15, "2023/05/12 17:45:00", "2023/05/12 17:45:00"),
            new Comment(45L, "Video này đã giúp tôi hiểu rõ hơn về chủ đề này. Cảm ơn rất nhiều!", 6L, 35L, 9, "2023/05/13 11:00:00", "2023/05/13 11:00:00"),
            new Comment(46L, "Đây là một trong những video hay nhất mà tôi từng xem. Tuyệt vời!", 2L, 66L, 18, "2023/05/14 15:30:00", "2023/05/14 15:30:00"),
            new Comment(47L, "Tôi đã chia sẻ video này với bạn bè và họ cũng rất thích. Cảm ơn tác giả!", 5L, 57L, 7, "2023/05/15 08:40:00", "2023/05/15 08:40:00"),
            new Comment(48L, "Nội dung video rất chi tiết và dễ hiểu. Tôi đã học được rất nhiều điều mới.", 6L, 78L, 13, "2023/05/16 19:25:00", "2023/05/16 19:25:00"),
            new Comment(49L, "Tôi thực sự ấn tượng với cách trình bày vấn đề trong video này. Rất thú vị!", 3L, 59L, 11, "2023/05/17 14:10:00", "2023/05/17 14:10:00"),
            new Comment(50L, "Đây là một trong những video hữu ích nhất về chủ đề này mà tôi từng xem.", 3L, 10L, 14, "2023/05/18 16:55:00", "2023/05/18 16:55:00"),
            new Comment(51L, "Tôi rất thích cách diễn đạt trong video. Nó rất logic và dễ hiểu.", 5L, 11L, 10, "2023/05/19 11:30:00", "2023/05/19 11:30:00"),
            new Comment(52L, "Video này thực sự rất giá trị. Tôi đã học được rất nhiều điều mới.", 1L, 12L, 16, "2023/05/20 09:00:00", "2023/05/20 09:00:00"),
            new Comment(53L, "Tôi đã xem video này vài lần và vẫn không thể ngừng được. Thật tuyệt vời!", 1L, 13L, 20, "2023/05/21 14:15:00", "2023/05/21 14:15:00"),
            new Comment(54L, "Cách giải thích các khái niệm trong video rất dễ hiểu. Tôi đánh giá rất cao.", 4L, 14L, 12, "2023/05/22 16:30:00", "2023/05/22 16:30:00"),
            new Comment(55L, "Đây là một trong những video giá trị nhất mà tôi từng xem về chủ đề này.", 5L, 15L, 18, "2023/05/23 11:45:00", "2023/05/23 11:45:00"),
            new Comment(56L, "Tôi đã chia sẻ video này với cả nhóm và mọi người đều rất thích.", 1L, 16L, 14, "2023/05/24 13:20:00", "2023/05/24 13:20:00"),
            new Comment(57L, "Video này đã giải đáp được nhiều câu hỏi mà tôi vẫn còn băn khoăn.", 2L, 17L, 11, "2023/05/25 15:50:00", "2023/05/25 15:50:00"),
            new Comment(58L, "Tôi thực sự ấn tượng với cách trình bày chuyên nghiệp trong video này.", 2L, 18L, 17, "2023/05/26 10:05:00", "2023/05/26 10:05:00"),
            new Comment(59L, "Đây là một trong những video hữu ích nhất mà tôi từng xem. Cảm ơn tác giả!", 3L, 19L, 15, "2023/05/27 14:40:00", "2023/05/27 14:40:00"),
            new Comment(60L, "Video này đã giúp tôi hiểu rõ hơn về chủ đề này. Tôi rất thích nó.", 4L, 20L, 13, "2023/05/28 16:25:00", "2023/05/28 16:25:00"),
            new Comment(61L, "Tôi đã chia sẻ video này với nhiều người và họ cũng rất thích.", 4L, 21L, 19, "2023/05/29 11:15:00", "2023/05/29 11:15:00")
    );

}
