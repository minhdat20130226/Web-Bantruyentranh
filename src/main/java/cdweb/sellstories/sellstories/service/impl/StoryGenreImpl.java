package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.entity.StoryGenre;
import cdweb.sellstories.sellstories.repository.StoryGenreRepository;
import cdweb.sellstories.sellstories.service.StoryGenreService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoryGenreImpl implements StoryGenreService {
    final StoryGenreRepository storyGenreRepository;

    @Override
    public List<StoryGenre> getAllGenres() {
        return storyGenreRepository.findAll();
    }


    @PostConstruct
    public void addDefaultStoryGenre() {
        storyGenreRepository.saveAll(genreNames);
    }

    List<StoryGenre> genreNames = Arrays.asList(
            new StoryGenre(1L, "Tiên Hiệp"),
            new StoryGenre(2L, "Kiếm Hiệp"),
            new StoryGenre(3L, "Fantasy"),
            new StoryGenre(4L, "Huyền Bí"),
            new StoryGenre(5L, "Hài Hước"),
            new StoryGenre(6L, "Phiêu Lưu"),
            new StoryGenre(7L, "Anime"),
            new StoryGenre(8L, "Shoujo")
    );


}
