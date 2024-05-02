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
    private List<StoryAuthorDTO> authorList;
    private List<StoryTranslatorDTO> translatorList;
    private List<StoryGenreDTO> storyGenreList;
    private List<PlacePublicationDTO> publicationList;

    public static Stream<StoriesBookDTO> getBooks(List<StoriesBookDTO> storiesBooks, List<CategoryDTO> categoryList) {
        return storiesBooks.stream()
                .peek(book -> updateCategoryLists(book, categoryList));
    }

    public static List<StoriesBookDTO> getNewBooks(List<StoriesBookDTO> storiesBooks, List<CategoryDTO> categoryList, int n, String statusBook) {
        return getBooks(storiesBooks, categoryList)
                .filter(s -> statusBook.equalsIgnoreCase(s.getStatus()))
                .sorted(Comparator.comparing(StoriesBookDTO::getCreatedDate).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    private static void updateCategoryLists(StoriesBookDTO book, List<CategoryDTO> categoryList) {
        categoryList.stream()
                .filter(categoryDTO -> book.getId().equals(categoryDTO.getIdStoriesBook()))
                .forEach(categoryDTO -> {
                    if (book.getAuthorList() == null) {
                        book.setAuthorList(new ArrayList<>());
                    }
                    if (book.getTranslatorList() == null) {
                        book.setTranslatorList(new ArrayList<>());
                    }
                    if (book.getStoryGenreList() == null) {
                        book.setStoryGenreList(new ArrayList<>());
                    }
                    if (book.getPublicationList() == null) {
                        book.setPublicationList(new ArrayList<>());
                    }
                    book.getAuthorList().add(new StoryAuthorDTO(categoryDTO.getStoryAuthorName()));
                    book.getTranslatorList().add(new StoryTranslatorDTO(categoryDTO.getStoryTranslatorName()));
                    book.getStoryGenreList().add(new StoryGenreDTO(categoryDTO.getStoryGenre()));
                    book.getPublicationList().add(new PlacePublicationDTO(categoryDTO.getPlacePublicationName()));
                    book.setReductionRate(categoryDTO.getReductionRate());
                });
    }

    public static List<StoriesBookDTO> getComingSoonBooks(List<StoriesBookDTO> storiesBooks, List<CategoryDTO> categoryList, int n, String statusBook) {
        return getBooks(storiesBooks, categoryList)
                .filter(s -> statusBook.equalsIgnoreCase(s.getStatus()))
                .limit(n)
                .collect(Collectors.toList());
    }
    // sach co so luong ban tu lon -> thap
    public static List<StoriesBookDTO> getBookBestSell(List<StoriesBookDTO> storiesBooks, List<OrderBookDTO> bookQuality, int n) {
        return bookQuality.stream()
                .sorted(Comparator.comparing(OrderBookDTO::getTotalQuantity).reversed())
                .limit(n)
                .map(orderBookDTO -> storiesBooks.stream()
                        .filter(storiesBookDTO -> storiesBookDTO.getId().equals(orderBookDTO.getStoriesId()))
                        .findFirst()
                        .orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}