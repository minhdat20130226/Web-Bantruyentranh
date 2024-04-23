package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.entity.PlacePublication;
import cdweb.sellstories.sellstories.repository.PlacePublicationRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlacePublicationImpl {
    final PlacePublicationRepository publicationRepository;

    @PostConstruct
    public void addDefaultPlacePublication() {
        publicationRepository.saveAll(placePublication);
    }

    List<PlacePublication> placePublication = Arrays.asList(
            new PlacePublication(1L, "NXB Kim Đồng"),
            new PlacePublication(2L, "NXB Văn Học"),
            new PlacePublication(3L, "NXB Trẻ"),
            new PlacePublication(4L, "NXB Hội Nhà Văn"),
            new PlacePublication(5L, "NXB Thanh Niên"),
            new PlacePublication(6L, "Shueisha"),
            new PlacePublication(7L, "Kodansha"),
            new PlacePublication(8L, "Shogakukan"),
            new PlacePublication(9L, "Penguin Random House"),
            new PlacePublication(10L, "HarperCollins"),
            new PlacePublication(11L, "Simon & Schuster"),
            new PlacePublication(12L, "Hachette Livre"),
            new PlacePublication(13L, "Macmillan Publishers"),
            new PlacePublication(14L, "Holtzbrinck Publishing Group"),
            new PlacePublication(15L, "Pearson"),
            new PlacePublication(16L, "O'Reilly Media"),
            new PlacePublication(17L, "Springer Nature"),
            new PlacePublication(18L, "Wiley"),
            new PlacePublication(19L, "McGraw-Hill Education"),
            new PlacePublication(20L, "Oxford University Press")
    );

}
