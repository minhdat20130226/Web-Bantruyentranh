package cdweb.sellstories.sellstories.controller;

import cdweb.sellstories.sellstories.entity.StoryGenre;
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
public class Genre {
    @Autowired
    private StoryGenreService storyGenreService;

    @GetMapping("/api/genres")
    public ResponseEntity<HttpResponse> getAllGenres() {
        try {
            List<StoryGenre> genres = storyGenreService.getAllGenres();
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

}
