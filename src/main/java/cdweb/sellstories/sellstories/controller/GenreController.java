package cdweb.sellstories.sellstories.controller;

import cdweb.sellstories.sellstories.dto.StoryGenreDTO;
import cdweb.sellstories.sellstories.service.CategoryService;
import cdweb.sellstories.sellstories.service.StoryGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class GenreController {
    @Autowired
    private StoryGenreService storyGenreService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/genres")
    public ResponseEntity<HttpResponse> getAllGenres() {
        try {
            List<StoryGenreDTO> genres = storyGenreService.getAllGenres();
            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .data(Map.of("genres", genres))
                            .message("Genres Fetched Successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .message("Failed to fetch genres: " + e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }

    }
    @GetMapping("/api/genre-with-book-count")
    public ResponseEntity<HttpResponse> getGenreWithBookCount() {
        try {
            List<StoryGenreDTO> genres = storyGenreService.getAllGenres();
            List<StoryGenreDTO> validGenres = genres.stream()
                    .peek(genre -> {
                        Long authorId = genre.getId();
                        int bookCount = categoryService.countBooksByGenreId(authorId);
                        genre.setTotalBookPublic(bookCount);
                    })
                    .filter(genre -> genre.getTotalBookPublic() > 0)
                    .toList();

            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .data(Map.of("validGenres", validGenres))
                            .message("ValidGenres Fetched Successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .message("Failed to fetch validGenres: " + e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }

    }
}
