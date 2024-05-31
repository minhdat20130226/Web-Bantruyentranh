package cdweb.sellstories.sellstories.service;

import cdweb.sellstories.sellstories.dto.ProfileBookDTO;
import cdweb.sellstories.sellstories.dto.StoriesBookDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StoriesBookService {
    List<StoriesBookDTO> getAllStoriesBook();

    String uploadPhoto(Long id, MultipartFile file);

    byte[] getPhoto(String fileName) throws IOException;

    List<StoriesBookDTO> getBooksWithGenres(String genresOption);

    int countProductsBetweenPrices(long minAge, long maxAge);

    int countProductsGreaterThanPrice(long minAge);
    Long findIdOfLatestCreatedStoriesBook();
}
