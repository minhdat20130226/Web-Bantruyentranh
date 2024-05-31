package cdweb.sellstories.sellstories.service;

import cdweb.sellstories.sellstories.dto.StoryGenreDTO;
import cdweb.sellstories.sellstories.entity.StoryGenre;

import java.util.List;

public interface StoryGenreService {
    List<StoryGenreDTO> getAllGenres();
}
