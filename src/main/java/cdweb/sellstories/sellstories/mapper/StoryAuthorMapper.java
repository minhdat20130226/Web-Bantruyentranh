package cdweb.sellstories.sellstories.mapper;

import cdweb.sellstories.sellstories.dto.StoryAuthorDTO;
import cdweb.sellstories.sellstories.dto.StoryGenreDTO;
import cdweb.sellstories.sellstories.entity.StoryAuthor;
import cdweb.sellstories.sellstories.entity.StoryGenre;

public class StoryAuthorMapper {
    public static StoryAuthorDTO mapToStoryTranslatorDTO(StoryAuthor storyAuthor){
        return StoryAuthorDTO.builder()
                .name(storyAuthor.getName())
                .build();
    }
}
