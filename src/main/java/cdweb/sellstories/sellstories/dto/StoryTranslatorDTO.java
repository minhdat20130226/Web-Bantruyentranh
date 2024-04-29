package cdweb.sellstories.sellstories.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class StoryTranslatorDTO {
    private Long id;
    private String name;
    public StoryTranslatorDTO( String name) {
        this.name = name;
    }
}
