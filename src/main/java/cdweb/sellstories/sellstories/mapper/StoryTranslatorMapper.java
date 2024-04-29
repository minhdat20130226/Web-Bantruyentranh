package cdweb.sellstories.sellstories.mapper;

import cdweb.sellstories.sellstories.dto.StoryTranslatorDTO;
import cdweb.sellstories.sellstories.entity.StoryTranslator;

public class StoryTranslatorMapper {
    public static StoryTranslatorDTO mapToStoryTranslatorDTO(StoryTranslator storyTranslator){
        return StoryTranslatorDTO.builder()
                .name(storyTranslator.getName())
                .build();
    }
}
