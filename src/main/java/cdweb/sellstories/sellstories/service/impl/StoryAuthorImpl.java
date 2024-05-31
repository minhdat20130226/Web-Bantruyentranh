package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.dto.StoryAuthorDTO;
import cdweb.sellstories.sellstories.entity.StoryAuthor;
import cdweb.sellstories.sellstories.mapper.StoryAuthorMapper;
import cdweb.sellstories.sellstories.repository.StoryAuthorRepository;
import cdweb.sellstories.sellstories.service.StoryAuthorService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoryAuthorImpl implements StoryAuthorService {
    final StoryAuthorRepository storyAuthorRepository;
    @PostConstruct
    public void addDefaultStoryAuthor() {
        storyAuthorRepository.saveAll(storyAuthor );
    }

    List<StoryAuthor> storyAuthor = Arrays.asList(
            new StoryAuthor(1L, "Bách Lý Khách"),
            new StoryAuthor(2L, "Hồng Long"),
            new StoryAuthor(3L, "Thanh Long"),
            new StoryAuthor(4L, "Kim Dung"),
            new StoryAuthor(5L, "Lão Tử Tiểu Thuyết"),
            new StoryAuthor(6L, "Vương Ngữ Yên"),
            new StoryAuthor(7L, "Nguyễn Nhật Ánh"),
            new StoryAuthor(8L, "Higashino Keigo"),
            new StoryAuthor(9L, "Haruki Murakami"),
            new StoryAuthor(10L, "J.K. Rowling"),
            new StoryAuthor(11L, "George R.R. Martin"),
            new StoryAuthor(12L, "Paulo Coelho"),
            new StoryAuthor(13L, "Agatha Christie"),
            new StoryAuthor(14L, "Chimamanda Ngozi Adichie"),
            new StoryAuthor(15L, "Gabriel García Márquez")
    );

    @Override
    public List<StoryAuthorDTO> getAllStoryAuthor() {
        List<StoryAuthor> storyAuthors = storyAuthorRepository.findAll();
        // parallelStream cho phep xu ly da luong
        return storyAuthors.parallelStream()
                .map(StoryAuthorMapper::mapToStoryAuthorDTO)
                .collect(Collectors.toList());
    }
}
