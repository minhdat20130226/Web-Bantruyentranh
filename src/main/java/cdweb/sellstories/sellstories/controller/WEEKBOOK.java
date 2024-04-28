package cdweb.sellstories.sellstories.controller;

import cdweb.sellstories.sellstories.dto.CategoryDTO;
import cdweb.sellstories.sellstories.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class WEEKBOOK {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/new-book")
    public ResponseEntity<HttpResponse> getAllNewBook() {
        try {
            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .data(Map.of("bookGenreNew", CategoryDTO.getNewestBooks(categoryService.getBook(), 20)))
                            .message("book genre new successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .message("Error occurred while fetching book benre new: " + e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build()
            );
        }
    }
    @GetMapping("/api/coming-soon-book")
    public ResponseEntity<HttpResponse> getAllComingSoonBook() {

        return null;

    }
    @GetMapping("/api/best-sell-book")
    public ResponseEntity<HttpResponse> getAllBestSellBook() {

        return null;

    }
}
