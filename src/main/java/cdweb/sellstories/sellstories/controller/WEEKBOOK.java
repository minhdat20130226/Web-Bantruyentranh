package cdweb.sellstories.sellstories.controller;

import cdweb.sellstories.sellstories.dto.OrderBookDTO;
import cdweb.sellstories.sellstories.dto.StoriesBookDTO;
import cdweb.sellstories.sellstories.service.CategoryService;
import cdweb.sellstories.sellstories.service.OrderBookService;
import cdweb.sellstories.sellstories.service.StoriesBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


import static cdweb.sellstories.sellstories.Constant.Constant.PHOTO_DIRECTORY;
import static org.springframework.util.MimeTypeUtils.IMAGE_JPEG_VALUE;
import static org.springframework.util.MimeTypeUtils.IMAGE_PNG_VALUE;


@RestController
public class WEEKBOOK {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private OrderBookService orderBookService;
    @Autowired
    private StoriesBookService storiesBookService;

    @GetMapping("/api/new-book")
    public ResponseEntity<HttpResponse> getAllNewBook() {

        try {
            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .data(Map.of("bookNew",StoriesBookDTO.getNewBooks(storiesBookService.getAllStoriesBook(),categoryService.getBook(),20,"Hoạt động")))
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
        try {
            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .data(Map.of("bookComingSoon",StoriesBookDTO.getComingSoonBooks(storiesBookService.getAllStoriesBook(),categoryService.getBook(),20,"Sắp ra mắt")))
                            .message("book coming soon successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .message("Error occurred while fetching book coming soon: " + e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build()
            );
        }
    }

    @GetMapping("/api/best-sell-book")
    public ResponseEntity<HttpResponse> getAllBestSellBook() {
        List<OrderBookDTO> bookQuality = orderBookService.findStoriesWithTotalQuantity();
        List<StoriesBookDTO> storiesBooks = StoriesBookDTO.getBooks(storiesBookService.getAllStoriesBook(), categoryService.getBook()).toList();
        try {
            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .data(Map.of("bookBestSell",StoriesBookDTO.getBookBestSell(storiesBooks,bookQuality,20)))
                            .message("book best sell successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .message("Error occurred while fetching book best sell: " + e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build()
            );
        }
    }

    @PutMapping("/photo")
    public ResponseEntity<String> uploadImage(@RequestParam("idBook") Long idBook,@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok().body(storiesBookService.uploadPhoto(idBook,file));
    }

    @GetMapping( path = "book/image/{fileImg}",produces = {IMAGE_PNG_VALUE,IMAGE_JPEG_VALUE})
    public byte[] getImage(@PathVariable("fileImg") String nameImg) throws IOException {
    return storiesBookService.getPhoto(PHOTO_DIRECTORY +nameImg);
    }
}
