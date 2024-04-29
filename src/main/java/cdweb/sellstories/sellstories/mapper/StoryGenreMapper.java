package cdweb.sellstories.sellstories.mapper;

import cdweb.sellstories.sellstories.dto.StoryGenreDTO;
import cdweb.sellstories.sellstories.entity.StoryGenre;

public class StoryGenreMapper {
    public static StoryGenreDTO mapToStoryGenreDTO(StoryGenre storyGenre){
        return StoryGenreDTO.builder()
                .name(storyGenre.getName())
                .build();
    }
}
