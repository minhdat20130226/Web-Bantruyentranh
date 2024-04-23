package cdweb.sellstories.sellstories.controller;

import cdweb.sellstories.sellstories.dto.CategoryInfo;
import cdweb.sellstories.sellstories.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class Category {
@Autowired
    private CategoryRepository categoryRepository;

@GetMapping("/api/category-genres")
   public ResponseEntity<HttpResponse> getCategoryGenres() {
    try {
        List<Object[]> category = categoryRepository.findAllAuthorsTranslatorsPublicationsGenres();

        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .message("No category found")
                            .status(HttpStatus.NOT_FOUND)
                            .statusCode(HttpStatus.NOT_FOUND.value())
                            .build());
        }
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("category", CategoryInfo.groupCategoryByGenre(category)))
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
