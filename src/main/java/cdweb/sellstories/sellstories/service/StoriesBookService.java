package cdweb.sellstories.sellstories.service;

import cdweb.sellstories.sellstories.dto.StoriesBookDTO;
import cdweb.sellstories.sellstories.entity.StoriesBook;

import java.util.List;

public interface StoriesBookService {
    List<StoriesBookDTO> getAllStoriesBook();
}
