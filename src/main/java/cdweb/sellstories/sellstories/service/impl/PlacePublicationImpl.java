package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.dto.PlacePublicationDTO;
import cdweb.sellstories.sellstories.entity.PlacePublication;
import cdweb.sellstories.sellstories.mapper.PlacePublicationMapper;
import cdweb.sellstories.sellstories.repository.PlacePublicationRepository;
import cdweb.sellstories.sellstories.service.PlacePublicationService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlacePublicationImpl implements PlacePublicationService {
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
            new PlacePublication(6L, "NXB Shueisha"),
            new PlacePublication(7L, "NXB Kodansha"),
            new PlacePublication(8L, "NXB Shogakukan"),
            new PlacePublication(9L, "NXB Penguin Random House"),
            new PlacePublication(10L, "NXB HarperCollins"),
            new PlacePublication(11L, "NXB Simon & Schuster"),
            new PlacePublication(12L, "NXB Hachette Livre"),
            new PlacePublication(13L, "NXB Macmillan Publishers"),
            new PlacePublication(14L, "NXB Holtzbrinck Publishing Group"),
            new PlacePublication(15L, "NXB Pearson"),
            new PlacePublication(16L, "NXB O'Reilly Media"),
            new PlacePublication(17L, "NXB Springer Nature"),
            new PlacePublication(18L, "NXB Wiley"),
            new PlacePublication(19L, "NXB McGraw-Hill Education"),
            new PlacePublication(20L, "NXB Oxford University Press")
    );

    @Override
    public List<PlacePublicationDTO> getAllPlacePublication() {
        List<PlacePublication> placePublications = publicationRepository.findAll();
    // parallelStream cho phep xu ly da luong
        return placePublications.parallelStream()
                .map(PlacePublicationMapper::mapToPlacePublicationDTO)
                .collect(Collectors.toList());
    }
}
