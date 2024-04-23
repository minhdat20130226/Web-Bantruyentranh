package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.entity.Category;
import cdweb.sellstories.sellstories.repository.CategoryRepository;
import cdweb.sellstories.sellstories.service.CategoryService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor

public class CategoryImpl implements CategoryService {
    final CategoryRepository categoryRepository;



    @PostConstruct
    public void addDefaultCategory() {

        categoryRepository.saveAll(generateCategoryList());
    }

    public List<Category> generateCategoryList() {
            String status = "Hoạt động";
        return Arrays.asList(
        new Category(1L, 1L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(2L,2L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(3L, 3L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(4L, 4L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(5L, 5L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(6L, 6L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(7L, 7L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(8L, 8L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(9L, 9L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(10L, 10L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(11L, 11L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(12L, 12L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(13L, 13L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(14L, 14L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(15L, 15L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(16L, 16L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(17L, 17L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(18L, 18L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(19L, 19L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(20L, 20L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(21L, 21L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(22L, 22L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(23L, 23L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(24L, 24L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(25L, 25L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
        new Category(26L, 26L, 1L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(27L, 27L, 2L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(28L, 28L, 2L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(29L, 29L, 2L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(30L, 30L, 2L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(31L, 31L, 2L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(32L, 32L, 2L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(33L, 33L, 2L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(34L, 34L, 2L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(35L, 35L, 2L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(36L, 36L, 4L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(37L, 37L, 4L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(38L, 38L, 4L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(39L, 39L, 4L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(40L, 40L, 4L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(41L, 41L, 4L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(42L, 42L, 4L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(43L, 43L, 4L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(44L, 44L, 4L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(45L, 45L, 4L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(46L, 46L, 4L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(47L, 47L, 4L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(48L, 48L, 5L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(49L, 49L, 5L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(50L, 50L, 5L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(51L, 51L, 5L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(52L, 52L, 5L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(53L, 53L, 5L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(54L, 54L, 5L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(55L, 55L, 5L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(56L, 56L, 5L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(57L, 57L, 5L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(58L, 58L, 5L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(59L, 59L, 5L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(60L, 60L, 6L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(61L, 61L, 6L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(62L, 62L, 6L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(63L, 63L, 6L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(64L, 64L, 6L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(65L, 65L, 6L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(66L, 66L, 6L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(67L, 67L, 6L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(68L, 68L, 6L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(69L, 69L, 6L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(70L, 70L, 6L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(71L, 71L, 6L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(72L, 72L, 6L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(73L, 73L, 3L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(74L, 74L, 3L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(75L, 75L, 3L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(76L, 76L, 3L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(77L, 77L, 3L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(78L, 78L, 3L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(79L, 79L, 3L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(80L, 80L, 3L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(81L, 81L, 3L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(82L, 82L, 3L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(83L, 83L, 3L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(84L, 84L, 3L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(85L, 85L, 8L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(86L, 86L, 8L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(87L, 87L, 8L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(88L, 88L, 8L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(89L, 89L, 8L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(90L, 90L, 8L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(91L, 91L, 8L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(92L, 92L, 8L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(93L, 93L, 8L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(94L, 94L, 8L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(95L, 95L, 8L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(96L, 96L, 8L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(97L, 97L, 7L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(98L, 98L, 7L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(99L, 99L, 7L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(100L, 100L, 7L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(101L, 101L, 7L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(102L, 102L, 7L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(103L, 103L, 7L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(104L, 104L, 7L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(105L, 105L, 7L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(106L, 106L, 7L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status),
                new Category(107L, 107L, 7L, getRandomLong(20L), getRandomLong(20L), getRandomLong(15L), status)
        );
    }
    private static long getRandomLong(long max) {
        return 1L + (long) (Math.random() * (max - 1L + 1));
    }


    @Override
    public List<Object[]> getAllAuthorsTranslatorsPublicationsGenres() {
        return categoryRepository.findAllAuthorsTranslatorsPublicationsGenres();
    }
}
