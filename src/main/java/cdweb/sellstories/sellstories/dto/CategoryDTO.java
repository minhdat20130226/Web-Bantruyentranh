package cdweb.sellstories.sellstories.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Builder
@Data
public class CategoryDTO {
    public Long idStoriesBook;
    public StoriesBookDTO storiesBookDTO;
    public String storyAuthorName;
    public String storyTranslatorName;
    public String placePublicationName;
    public String storyGenre;
    public int reductionRate;
    public LocalDateTime createdDate;
    public String status;

    public CategoryDTO(String storyAuthorName, String storyTranslatorName, String placePublicationName) {
        this.storyAuthorName = storyAuthorName;
        this.storyTranslatorName = storyTranslatorName;
        this.placePublicationName = placePublicationName;
    }
    public CategoryDTO(Long idStoriesBook, String storyAuthorName, String storyTranslatorName, String placePublicationName, String storyGenre, int reductionRate, LocalDateTime createdDate, String status ) {
        this.idStoriesBook = idStoriesBook;
        this.storyAuthorName = storyAuthorName;
        this.storyTranslatorName = storyTranslatorName;
        this.placePublicationName = placePublicationName;
        this.storyGenre = storyGenre;
        this.reductionRate = reductionRate;
        this.createdDate = createdDate;
        this.status = status;
    }
    public static Map<String, List<CategoryDTO>> groupCategoryByGenre(List<Object[]> category) {
        Map<String, List<CategoryDTO>> groupedCategories = new HashMap<>();

        for (Object[] entry : category) {
            String storyAuthorName = (String) entry[0];
            String storyTranslatorName = (String) entry[1];
            String placePublicationName = (String) entry[2];
            String storyGenre = (String) entry[3];

            // Kiểm tra xem map đã có key storyGenre chưa
            if (!groupedCategories.containsKey(storyGenre)) {
                // Nếu chưa có, tạo mới một danh sách rỗng và thêm vào map
                groupedCategories.put(storyGenre, new ArrayList<>());
            }
            groupedCategories.get(storyGenre).add(new CategoryDTO(storyAuthorName, storyTranslatorName, placePublicationName));
        }

        return groupedCategories;
    }

    public static Map<String, List<CategoryDTO>> getBooksWithGenre(List<CategoryDTO> category) {
        return category.stream().collect(Collectors.groupingBy(
                CategoryDTO::getStoryGenre,
                HashMap::new,
                Collectors.toList()
        ));
    }
}
