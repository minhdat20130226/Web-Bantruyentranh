package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.entity.ComicDiscount;
import cdweb.sellstories.sellstories.entity.StoriesBook;
import cdweb.sellstories.sellstories.repository.ComicDiscountRepository;
import cdweb.sellstories.sellstories.service.ComicDiscountService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ComicDiscountImpl implements ComicDiscountService {
    final ComicDiscountRepository comicDiscountRepository;

    @PostConstruct
    public void addDefaultComicDiscount() {
        comicDiscountRepository.saveAll(comicDiscounts);
    }

    List<ComicDiscount> comicDiscounts =
            Arrays.asList(
                    new ComicDiscount(1L, new StoriesBook(1L), 12),
                    new ComicDiscount(2L, new StoriesBook(2L), 42),
                    new ComicDiscount(3L, new StoriesBook(3L), 21),
                    new ComicDiscount(4L, new StoriesBook(4L), 63),
                    new ComicDiscount(5L, new StoriesBook(5L), 84),
                    new ComicDiscount(6L, new StoriesBook(6L), 37),
                    new ComicDiscount(7L, new StoriesBook(7L), 19),
                    new ComicDiscount(8L, new StoriesBook(8L), 55),
                    new ComicDiscount(9L, new StoriesBook(9L), 76),
                    new ComicDiscount(10L, new StoriesBook(10L), 28),
                    new ComicDiscount(11L, new StoriesBook(11L), 39),
                    new ComicDiscount(12L, new StoriesBook(12L), 57),
                    new ComicDiscount(13L, new StoriesBook(13L), 68),
                    new ComicDiscount(14L, new StoriesBook(14L), 91),
                    new ComicDiscount(15L, new StoriesBook(15L), 23),
                    new ComicDiscount(16L, new StoriesBook(16L), 47),
                    new ComicDiscount(17L, new StoriesBook(17L), 82),
                    new ComicDiscount(18L, new StoriesBook(18L), 16),
                    new ComicDiscount(19L, new StoriesBook(19L), 35),
                    new ComicDiscount(20L, new StoriesBook(20L), 73),
                    new ComicDiscount(21L, new StoriesBook(21L), 29),
                    new ComicDiscount(22L, new StoriesBook(22L), 62),
                    new ComicDiscount(23L, new StoriesBook(23L), 88),
                    new ComicDiscount(24L, new StoriesBook(24L), 41),
                    new ComicDiscount(25L, new StoriesBook(25L), 75),
                    new ComicDiscount(26L, new StoriesBook(26L), 19),
                    new ComicDiscount(27L, new StoriesBook(27L), 56),
                    new ComicDiscount(28L, new StoriesBook(28L), 83),
                    new ComicDiscount(29L, new StoriesBook(29L), 14),
                    new ComicDiscount(30L, new StoriesBook(30L), 37),
                    new ComicDiscount(31L, new StoriesBook(31L), 42),
                    new ComicDiscount(32L, new StoriesBook(32L), 69),
                    new ComicDiscount(33L, new StoriesBook(33L), 95),
                    new ComicDiscount(34L, new StoriesBook(34L), 21),
                    new ComicDiscount(35L, new StoriesBook(35L), 57),
                    new ComicDiscount(36L, new StoriesBook(36L), 84),
                    new ComicDiscount(37L, new StoriesBook(37L), 12),
                    new ComicDiscount(38L, new StoriesBook(38L), 37),
                    new ComicDiscount(39L, new StoriesBook(39L), 63),
                    new ComicDiscount(40L, new StoriesBook(40L), 89),
                    new ComicDiscount(41L, new StoriesBook(41L), 17),
                    new ComicDiscount(42L, new StoriesBook(42L), 46),
                    new ComicDiscount(43L, new StoriesBook(43L), 73),
                    new ComicDiscount(44L, new StoriesBook(44L), 28),
                    new ComicDiscount(45L, new StoriesBook(45L), 51),
                    new ComicDiscount(46L, new StoriesBook(46L), 76),
                    new ComicDiscount(47L, new StoriesBook(47L), 14),
                    new ComicDiscount(48L, new StoriesBook(48L), 39),
                    new ComicDiscount(49L, new StoriesBook(49L), 68),
                    new ComicDiscount(50L, new StoriesBook(50L), 96),
                    new ComicDiscount(51L, new StoriesBook(51L), 25),
                    new ComicDiscount(52L, new StoriesBook(52L), 53),
                    new ComicDiscount(53L, new StoriesBook(53L), 82),
                    new ComicDiscount(54L, new StoriesBook(54L), 19),
                    new ComicDiscount(55L, new StoriesBook(55L), 47),
                    new ComicDiscount(56L, new StoriesBook(56L), 75),
                    new ComicDiscount(57L, new StoriesBook(57L), 11),
                    new ComicDiscount(58L, new StoriesBook(58L), 40),
                    new ComicDiscount(59L, new StoriesBook(59L), 70),
                    new ComicDiscount(60L, new StoriesBook(60L), 99),
                    new ComicDiscount(61L, new StoriesBook(61L), 15),
                    new ComicDiscount(62L, new StoriesBook(62L), 46),
                    new ComicDiscount(63L, new StoriesBook(63L), 79),
                    new ComicDiscount(64L, new StoriesBook(64L), 23),
                    new ComicDiscount(65L, new StoriesBook(65L), 57),
                    new ComicDiscount(66L, new StoriesBook(66L), 88),
                    new ComicDiscount(67L, new StoriesBook(67L), 31),
                    new ComicDiscount(68L, new StoriesBook(68L), 64),
                    new ComicDiscount(69L, new StoriesBook(69L), 97),
                    new ComicDiscount(70L, new StoriesBook(70L), 42),
                    new ComicDiscount(71L, new StoriesBook(71L), 71),
                    new ComicDiscount(72L, new StoriesBook(72L), 14),
                    new ComicDiscount(73L, new StoriesBook(73L), 48),
                    new ComicDiscount(74L, new StoriesBook(74L), 82),
                    new ComicDiscount(75L, new StoriesBook(75L), 19),
                    new ComicDiscount(76L, new StoriesBook(76L), 53),
                    new ComicDiscount(77L, new StoriesBook(77L), 89),
                    new ComicDiscount(78L, new StoriesBook(78L), 28),
                    new ComicDiscount(79L, new StoriesBook(79L), 60),
                    new ComicDiscount(80L, new StoriesBook(80L), 96),
                    new ComicDiscount(81L, new StoriesBook(81L), 25),
                    new ComicDiscount(82L, new StoriesBook(82L), 62),
                    new ComicDiscount(83L, new StoriesBook(83L), 91),
                    new ComicDiscount(84L, new StoriesBook(84L), 33),
                    new ComicDiscount(85L, new StoriesBook(85L), 69),
                    new ComicDiscount(86L, new StoriesBook(86L), 10),
                    new ComicDiscount(87L, new StoriesBook(87L), 40),
                    new ComicDiscount(88L, new StoriesBook(88L), 76),
                    new ComicDiscount(89L, new StoriesBook(89L), 5),
                    new ComicDiscount(90L, new StoriesBook(90L), 36),
                    new ComicDiscount(91L, new StoriesBook(91L), 17),
                    new ComicDiscount(92L, new StoriesBook(92L), 49),
                    new ComicDiscount(93L, new StoriesBook(93L), 73),
                    new ComicDiscount(94L, new StoriesBook(94L), 29),
                    new ComicDiscount(95L, new StoriesBook(95L), 64),
                    new ComicDiscount(96L, new StoriesBook(96L), 98),
                    new ComicDiscount(97L, new StoriesBook(97L), 42),
                    new ComicDiscount(98L, new StoriesBook(98L), 86),
                    new ComicDiscount(99L, new StoriesBook(99L), 21),
                    new ComicDiscount(100L, new StoriesBook(100L), 55),
                    new ComicDiscount(101L, new StoriesBook(101L), 90),
                    new ComicDiscount(102L, new StoriesBook(102L), 38),
                    new ComicDiscount(103L, new StoriesBook(103L), 71),
                    new ComicDiscount(104L, new StoriesBook(104L), 12),
                    new ComicDiscount(105L, new StoriesBook(105L), 46),
                    new ComicDiscount(106L, new StoriesBook(106L), 80),
                    new ComicDiscount(107L, new StoriesBook(107L), 3));
}
