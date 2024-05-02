package cdweb.sellstories.sellstories.controller;

import cdweb.sellstories.sellstories.dto.StoriesBookDTO;
import cdweb.sellstories.sellstories.service.CategoryService;
import cdweb.sellstories.sellstories.service.CommentService;
import cdweb.sellstories.sellstories.service.StoriesBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Comparator;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;


@RestController
public class TopicGroup {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private StoriesBookService storiesBookService;

        @GetMapping("api/topic/ud-in-day")
    public ResponseEntity<HttpResponse> maxReductionRateBook() {
        try {
            Optional<StoriesBookDTO> maxReductionRateBook = StoriesBookDTO.getBooks(storiesBookService.getAllStoriesBook(), categoryService.getBook())
                    .max(Comparator.comparingDouble(StoriesBookDTO::getReductionRate));
            if (maxReductionRateBook.isPresent()) {
                StoriesBookDTO bookWithMaxReductionRate = maxReductionRateBook.get();
                System.out.println("Book with max reduction rate: " + bookWithMaxReductionRate);

                HttpResponse response = HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("bookMaxReductionRate", bookWithMaxReductionRate))
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
    private  Optional<StoriesBookDTO> getBookWithTopic(Long idBook){
        Stream<StoriesBookDTO> bookDTOList = StoriesBookDTO.getBooks(storiesBookService.getAllStoriesBook(), categoryService.getBook());
    return bookDTOList
                .filter(book -> book.getId().equals(idBook))
                .findFirst();
    }
    // lay sach co so luong nguoi dung thich nhieu nhat
    @GetMapping("api/topic/max-is-like")
    public ResponseEntity<HttpResponse> maxIsLikeBook() {
        Long idHighestLike = commentService.findIdOfBookWithHighestLike();
        try {

                StoriesBookDTO highestLikeBook = getBookWithTopic(idHighestLike).get();
                return ResponseEntity.ok().body(
                        HttpResponse.builder()
                                .timeStamp(LocalDateTime.now().toString())
                                .data(Map.of("bookMaxLike", highestLikeBook))
                                .message("book best sell successfully")
                                .status(HttpStatus.OK)
                                .statusCode(HttpStatus.OK.value())
                                .build()
                );

        }
        catch (Exception e) {
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
        Long idBookWithStarTop = commentService.findIdOfBookWithStarTotal();
        try {

            StoriesBookDTO highestLikeBook = getBookWithTopic(idBookWithStarTop).get();
            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .data(Map.of("bookPopularTop", highestLikeBook))
                            .message("book popular top successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );

        }
        catch (Exception e) {
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
        StoriesBookDTO idBookWithStarTop = StoriesBookDTO.getBooks(storiesBookService.getAllStoriesBook(),categoryService.getBook())
                .sorted(Comparator.comparing(StoriesBookDTO::getCreatedDate)).toList().getLast();
            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .data(Map.of("bookNew", idBookWithStarTop))
                            .message("book new successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );

        }
        catch (Exception e) {
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
