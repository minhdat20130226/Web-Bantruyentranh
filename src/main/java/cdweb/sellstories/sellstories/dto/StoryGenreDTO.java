package cdweb.sellstories.sellstories.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class StoryGenreDTO {
    private Long id;
    private String name;
    public StoryGenreDTO( String name) {
        this.name = name;
    }
}
