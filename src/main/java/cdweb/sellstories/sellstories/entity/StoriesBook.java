package cdweb.sellstories.sellstories.entity;

import cdweb.sellstories.sellstories.util.LocalDateTimeUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "stories_book")
public class StoriesBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "age_requirement")
    private int ageRequirement;

    @Column(name = "status")
    private String status;

    @Column(name = "total_chapter")
    private int totalChapter;

    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    public StoriesBook(Long id,String name, String photoUrl, double price, String description, int ageRequirement, String status, int totalChapter,String createdDate,String updatedDate) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
        this.price = price;
        this.description = description;
        this.ageRequirement = ageRequirement;
        this.status = status;
        this.totalChapter = totalChapter;
        this.createdDate = LocalDateTimeUtils.parseDateString(createdDate);
        this.updatedDate = LocalDateTimeUtils.parseDateString(updatedDate);
    }

    public StoriesBook(Long id) {
        this.id = id;
    }
}



