package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.entity.StoryTranslator;
import cdweb.sellstories.sellstories.repository.StoryTranslatorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoryTranslatorImpl {
    final StoryTranslatorRepository storyTranslatorRepository;


    @PostConstruct
    public void addDefaultStoryTranslator() {
        storyTranslatorRepository.saveAll(storyTranslator);
    }

    List<StoryTranslator> storyTranslator = Arrays.asList(
            new StoryTranslator(1L, "Nguyễn Thị Ánh"),
            new StoryTranslator(2L, "Trần Văn Tuấn"),
            new StoryTranslator(3L, "Lê Thị Thanh Hương"),
            new StoryTranslator(4L, "Phạm Minh Tuấn"),
            new StoryTranslator(5L, "Hoàng Thị Lan"),
            new StoryTranslator(6L, "Đỗ Văn Minh"),
            new StoryTranslator(7L, "Nguyễn Thị Mai"),
            new StoryTranslator(8L, "Trần Minh Tâm"),
            new StoryTranslator(9L, "Phan Thị Hải Yến"),
            new StoryTranslator(10L, "Lê Văn Long"),
            new StoryTranslator(11L, "Nguyễn Thị Hoài An"),
            new StoryTranslator(12L, "Trần Thị Hồng"),
            new StoryTranslator(13L, "Vũ Văn Hùng"),
            new StoryTranslator(14L, "Nguyễn Thị Ngọc Trâm"),
            new StoryTranslator(15L, "Lê Văn Hải"),
            new StoryTranslator(16L, "Phạm Thị Thúy"),
            new StoryTranslator(17L, "Trần Minh Hiếu"),
            new StoryTranslator(18L, "Đỗ Thị Mai"),
            new StoryTranslator(19L, "Hoàng Văn Hùng"),
            new StoryTranslator(20L, "Nguyễn Thị Hồng Loan")
    );
}
