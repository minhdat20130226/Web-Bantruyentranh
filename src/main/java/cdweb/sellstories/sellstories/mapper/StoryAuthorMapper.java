package cdweb.sellstories.sellstories.mapper;

import cdweb.sellstories.sellstories.dto.StoryAuthorDTO;
import cdweb.sellstories.sellstories.entity.StoryAuthor;

public class StoryAuthorMapper {
    public static StoryAuthorDTO mapToStoryAuthorDTO(StoryAuthor storyAuthor){
        return StoryAuthorDTO.builder()
                .id(storyAuthor.getId())
                .name(storyAuthor.getName())
                .build();
    }
}
