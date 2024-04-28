package cdweb.sellstories.sellstories.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class CategoryDTO {
    public Long id;
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
    public CategoryDTO(Long id, String storyAuthorName, String storyTranslatorName, String placePublicationName, String storyGenre, int reductionRate, LocalDateTime createdDate, String status ) {
        this.id = id;
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
    public static List<CategoryDTO> getNewestBooks(List<CategoryDTO> books, int n) {
        // Sắp xếp danh sách sách theo thứ tự giảm dần của createdDate
        List<CategoryDTO> sortedBooks = books.stream()
                .sorted((b1, b2) -> b2.getCreatedDate().compareTo(b1.getCreatedDate()))
                .collect(Collectors.toList());

        // Lấy ra n sách mới nhất
        List<CategoryDTO> newestBooks = sortedBooks.subList(0, Math.min(n, sortedBooks.size()));

        return newestBooks;
    }

}
