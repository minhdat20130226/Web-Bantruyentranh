package cdweb.sellstories.sellstories.controller;

import cdweb.sellstories.sellstories.dto.CategoryDTO;
import cdweb.sellstories.sellstories.dto.StoriesBookDTO;
import cdweb.sellstories.sellstories.service.CategoryService;
import cdweb.sellstories.sellstories.service.ComicDiscountService;
import cdweb.sellstories.sellstories.service.CommentService;
import cdweb.sellstories.sellstories.service.StoriesBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;


@RestController
public class TopicGroup {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private StoriesBookService storiesBookService;
    @Autowired
    private ComicDiscountService comicDiscountService;

    // uu dai trong ngay lay san pham giam gia cao nhat
    @GetMapping("api/topic/ud-in-day")
    public ResponseEntity<HttpResponse> maxReductionRateBook() {
        try {
            Long idBook = comicDiscountService.findIdWithMaxReductionRate();
            CategoryDTO bookUDIN = categoryService.findByStoriesBookId(idBook);
            if (bookUDIN != null) {
                HttpResponse response = HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("bookMaxReductionRate", bookUDIN))
                        .message("book genre new successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build();

                return ResponseEntity.ok().body(response);
            } else {
                System.out.println("No books found.");

                HttpResponse response = HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .message("No books found")
                        .status(HttpStatus.NOT_FOUND)
                        .statusCode(HttpStatus.NOT_FOUND.value())
                        .build();

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            System.out.println("Error occurred while fetching book reduction rate: " + e.getMessage());

            HttpResponse response = HttpResponse.builder()
                    .timeStamp(LocalDateTime.now().toString())
                    .message("Error occurred while fetching book reduction rate: " + e.getMessage())
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    // lay sach co so luong nguoi dung thich nhieu nhat
    @GetMapping("api/topic/max-is-like")
    public ResponseEntity<HttpResponse> maxIsLikeBook() {
        try {
            Long idHighestLike = commentService.findIdOfBookWithHighestLike();
            CategoryDTO highestLikeBook = categoryService.findByStoriesBookId(idHighestLike);
            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .data(Map.of("bookMaxLike", highestLikeBook))
                            .message("book best sell successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .message("Error occurred while fetching book max like: " + e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build()
            );
        }
    }

    // lay sach co so sao duoc danh gia nhieu nhat
    @GetMapping("api/topic/popular-book")
    public ResponseEntity<HttpResponse> maxPopularBook() {

        try {
            Long idBookWithStarTop = commentService.findIdOfBookWithStarTotal();
            CategoryDTO highestLikeBook = categoryService.findByStoriesBookId(idBookWithStarTop);
            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .data(Map.of("bookPopularTop", highestLikeBook))
                            .message("book popular top successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .message("Error occurred while fetching book popular top: " + e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build()
            );
        }
    }

    // lay san pham co ngay them vo lon nhat
    @GetMapping("/api/topic/new-book")
    public ResponseEntity<HttpResponse> maxNewBook() {
        try {
            Long idBookWithStarTop =storiesBookService.findIdOfLatestCreatedStoriesBook();
            CategoryDTO newBook = categoryService.findByStoriesBookId(idBookWithStarTop);
            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .data(Map.of("bookNew", newBook))
                            .message("book new successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .message("Error occurred while fetching book new: " + e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build()
            );
        }
    }

}
