package cdweb.sellstories.sellstories.mapper;

import cdweb.sellstories.sellstories.dto.StoriesBookDTO;
import cdweb.sellstories.sellstories.entity.StoriesBook;

public class StoriesBookMapper {

    public static StoriesBookDTO storiesBookToStoriesBookDTO(StoriesBook storiesBook) {
        return StoriesBookDTO.builder()
                .id(storiesBook.getId())
                .name(storiesBook.getName())
                .photoUrl(storiesBook.getPhotoUrl())
                .price(storiesBook.getPrice())
                .description(storiesBook.getDescription())
                .ageRequirement(Math.toIntExact(storiesBook.getReadingAge().getAge()))
                .status(storiesBook.getStatus())
                .totalChapter(storiesBook.getTotalChapter())
                .createdDate(storiesBook.getCreatedDate())
                .build();
    }
}
