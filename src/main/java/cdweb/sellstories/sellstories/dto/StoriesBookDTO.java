package cdweb.sellstories.sellstories.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class StoriesBookDTO {
    private Long id;
    private String name;
    private String photoUrl;
    private double price;
    private String description;
    private int ageRequirement;
    private String status;
    private int totalChapter;
    private LocalDateTime createdDate;
    private int reductionRate;
    private int newPrice;

    private List<String> authorList;
    private List<String> translatorList;
    private List<String> storyGenreList;
    private List<String> publicationList;


}