package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.dto.CategoryDTO;
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
            String[] status = {"Hoạt động","Sắp ra mắt"};
        return Arrays.asList(
                new Category(1L, 1L, 1L, 10L, 15L, 8L, "2024/04/22 12:20:30", "2024/04/22 23:20:30", status[0]),
                new Category(2L, 2L, 1L, 12L, 18L, 5L, "2024/04/23 12:22:30", "2024/04/23 23:22:30", status[0]),
                new Category(3L, 3L, 1L, 15L, 10L, 12L, "2024/04/24 12:24:30", "2024/04/24 23:24:30",status[1]),
                new Category(4L, 4L, 1L, 18L, 12L, 10L, "2024/04/22 12:20:30", "2024/04/22 23:20:30",status[1]),
                new Category(5L, 5L, 1L, 16L, 14L, 8L, "2024/04/23 12:22:30", "2024/04/23 23:22:30",status[1]),
                new Category(6L, 6L, 1L, 14L, 16L, 6L, "2024/04/24 12:24:30", "2024/04/24 23:24:30",status[1]),
                new Category(7L, 7L, 1L, 12L, 18L, 4L, "2024/04/25 12:26:30", "2024/04/25 23:26:30",status[1]),
                new Category(8L, 8L, 1L, 10L, 20L, 2L, "2024/04/26 12:28:30", "2024/04/26 23:28:30",status[1]),
                new Category(9L, 9L, 1L, 8L, 18L, 12L, "2024/05/01 12:30:30", "2024/05/01 23:30:30",status[1]),
                new Category(10L, 10L, 1L, 6L, 16L, 10L, "2024/05/02 12:32:30", "2024/05/02 23:32:30",status[1]),
                new Category(11L, 11L, 1L, 4L, 14L, 8L, "2024/05/03 12:34:30", "2024/05/03 23:34:30",status[1]),
                new Category(12L, 12L, 1L, 2L, 12L, 6L, "2024/05/04 12:36:30", "2024/05/04 23:36:30",status[1]),
                new Category(13L, 13L, 1L, 12L, 10L, 4L, "2024/05/05 12:38:30", "2024/05/05 23:38:30",status[1]),
                new Category(14L, 14L, 1L, 2L, 8L, 2L, "2024/05/06 12:40:30", "2024/05/06 23:40:30",status[1]),
                new Category(15L, 15L, 1L, 18L, 12L, 10L, "2024/04/22 12:20:30", "2024/04/22 23:20:30",status[1]),
                new Category(16L, 16L, 1L, 17L, 14L, 8L, "2024/04/23 12:22:30", "2024/04/23 23:22:30",status[1]),
                new Category(17L, 17L, 1L, 16L, 16L, 5L, "2024/04/24 12:24:30", "2024/04/24 23:24:30",status[1]),
                new Category(18L, 18L, 1L, 15L, 18L, 12L, "2024/04/25 12:26:30", "2024/04/25 23:26:30",status[1]),
                new Category(19L, 19L, 1L, 14L, 20L, 10L, "2024/04/26 12:28:30", "2024/04/26 23:28:30",status[1]),
                new Category(20L, 20L, 1L, 13L, 18L, 8L, "2024/04/27 12:30:30", "2024/04/27 23:30:30",status[1]),
                new Category(21L, 21L, 1L, 12L, 16L, 5L, "2024/04/28 12:32:30", "2024/04/28 23:32:30",status[1]),
                new Category(22L, 22L, 1L, 11L, 14L, 3L, "2024/04/29 12:34:30", "2024/04/29 23:34:30",status[1]),
                new Category(23L, 23L, 1L, 10L, 12L, 1L, "2024/04/30 12:36:30", "2024/04/30 23:36:30",status[1]),
                new Category(24L, 24L, 1L, 9L, 10L, 10L, "2024/05/01 12:38:30", "2024/05/01 23:38:30",status[1]),
                new Category(25L, 25L, 1L, 8L, 8L, 8L, "2024/05/02 12:40:30", "2024/05/02 23:40:30",status[1]),
                new Category(26L, 26L, 1L, 7L, 6L, 6L, "2024/05/03 12:42:30", "2024/05/03 23:42:30",status[1]),
                new Category(27L, 27L, 2L, 5L, 4L, 3L, "2024/05/04 12:44:30", "2024/05/04 23:44:30",status[1]),
                new Category(28L, 28L, 2L, 3L, 2L, 1L, "2024/05/05 12:46:30", "2024/05/05 23:46:30", status[0]),
                new Category(29L, 29L, 2L, 1L, 1L, 1L, "2024/05/06 12:48:30", "2024/05/06 23:48:30", status[0]),
                new Category(30L, 30L, 2L, 1L, 2L, 3L, "2024/05/07 12:50:30", "2024/05/07 23:50:30", status[0]),
                new Category(31L, 31L, 2L, 18L, 12L, 10L, "2024/04/29 12:34:30", "2024/04/29 23:34:30", status[0]),
                new Category(32L, 32L, 2L, 17L, 14L, 8L, "2024/04/30 12:36:30", "2024/04/30 23:36:30", status[0]),
                new Category(33L, 33L, 2L, 16L, 16L, 5L, "2024/05/01 12:38:30", "2024/05/01 23:38:30", status[0]),
                new Category(34L, 34L, 2L, 15L, 18L, 12L, "2024/05/02 12:40:30", "2024/05/02 23:40:30", status[0]),
                new Category(35L, 35L, 2L, 14L, 20L, 10L, "2024/05/03 12:42:30", "2024/05/03 23:42:30", status[1]),
                new Category(36L, 36L, 4L, 13L, 18L, 8L, "2024/05/04 12:44:30", "2024/05/04 23:44:30", status[0]),
                new Category(37L, 37L, 4L, 12L, 16L, 5L, "2024/05/05 12:46:30", "2024/05/05 23:46:30", status[0]),
                new Category(38L, 38L, 4L, 11L, 14L, 3L, "2024/05/06 12:48:30", "2024/05/06 23:48:30", status[0]),
                new Category(39L, 39L, 4L, 10L, 12L, 10L, "2024/05/07 12:50:30", "2024/05/07 23:50:30", status[1]),
                new Category(40L, 40L, 4L, 9L, 10L, 8L, "2024/05/08 12:52:30", "2024/05/08 23:52:30", status[0]),
                new Category(41L, 41L, 4L, 8L, 8L, 5L, "2024/05/09 12:54:30", "2024/05/09 23:54:30", status[0]),
                new Category(42L, 42L, 4L, 7L, 6L, 12L, "2024/05/10 12:56:30", "2024/05/10 23:56:30", status[0]),
                new Category(43L, 43L, 4L, 6L, 4L, 10L, "2024/05/11 12:58:30", "2024/05/11 23:58:30", status[0]),
                new Category(44L, 44L, 4L, 5L, 2L, 8L, "2024/05/12 13:00:30", "2024/05/12 23:00:30", status[0]),
                new Category(45L, 45L, 4L, 18L, 12L, 10L, "2024/05/13 13:02:30", "2024/05/13 23:02:30", status[0]),
                new Category(46L, 46L, 4L, 17L, 14L, 8L, "2024/05/14 13:04:30", "2024/05/14 23:04:30", status[0]),
                new Category(47L, 47L, 4L, 16L, 16L, 5L, "2024/05/15 13:06:30", "2024/05/15 23:06:30", status[0]),
                new Category(48L, 48L, 5L, 15L, 18L, 12L, "2024/05/16 13:08:30", "2024/05/16 23:08:30", status[0]),
                new Category(49L, 49L, 5L, 14L, 20L, 10L, "2024/05/17 13:10:30", "2024/05/17 23:10:30", status[0]),
                new Category(50L, 50L, 5L, 13L, 18L, 8L, "2024/05/18 13:12:30", "2024/05/18 23:12:30", status[0]),
                new Category(51L, 51L, 5L, 12L, 16L, 5L, "2024/05/19 13:14:30", "2024/05/19 23:14:30", status[0]),
                new Category(52L, 52L, 5L, 11L, 14L, 3L, "2024/05/20 13:16:30", "2024/05/20 23:16:30", status[0]),
                new Category(53L, 53L, 5L, 10L, 12L, 10L, "2024/05/21 13:18:30", "2024/05/21 23:18:30", status[0]),
                new Category(54L, 54L, 5L, 9L, 10L, 8L, "2024/05/22 13:20:30", "2024/05/22 23:20:30", status[0]),
                new Category(55L, 55L, 5L, 8L, 8L, 5L, "2024/05/23 13:22:30", "2024/05/23 23:22:30", status[0]),
                new Category(56L, 56L, 5L, 7L, 6L, 12L, "2024/05/24 13:24:30", "2024/05/24 23:24:30", status[0]),
                new Category(57L, 57L, 5L, 6L, 4L, 10L, "2024/05/25 13:26:30", "2024/05/25 23:26:30", status[0]),
                new Category(58L, 58L, 5L, 5L, 2L, 8L, "2024/05/26 13:28:30", "2024/05/26 23:28:30", status[0]),
                new Category(59L, 59L, 6L, 4L, 4L, 5L, "2024/05/27 13:30:30", "2024/05/27 23:30:30", status[0]),
                new Category(60L, 60L, 6L, 3L, 6L, 2L, "2024/05/28 13:32:30", "2024/05/28 23:32:30", status[0]),
                new Category(61L, 61L, 6L, 2L, 8L, 10L, "2024/05/29 13:34:30", "2024/05/29 23:34:30", status[0]),
                new Category(62L, 62L, 6L, 1L, 10L, 8L, "2024/05/30 13:36:30", "2024/05/30 23:36:30", status[0]),
                new Category(63L, 63L, 6L, 20L, 12L, 5L, "2024/05/31 13:38:30", "2024/05/31 23:38:30", status[1]),
                new Category(64L, 64L, 6L, 19L, 14L, 2L, "2024/06/01 13:40:30", "2024/06/01 23:40:30", status[0]),
                new Category(65L, 65L, 6L, 18L, 16L, 10L, "2024/06/02 13:42:30", "2024/06/02 23:42:30", status[0]),
                new Category(66L, 66L, 6L, 17L, 18L, 8L, "2024/06/03 13:44:30", "2024/06/03 23:44:30", status[0]),
                new Category(67L, 67L, 6L, 18L, 12L, 10L, "2024/06/04 13:46:30", "2024/06/04 23:46:30", status[0]),
                new Category(68L, 68L, 6L, 17L, 14L, 8L, "2024/06/05 13:48:30", "2024/06/05 23:48:30", status[1]),
                new Category(69L, 69L, 6L, 16L, 16L, 5L, "2024/06/06 13:50:30", "2024/06/06 23:50:30", status[0]),
                new Category(70L, 70L, 6L, 15L, 18L, 12L, "2024/06/07 13:52:30", "2024/06/07 23:52:30", status[0]),
                new Category(71L, 71L, 6L, 14L, 20L, 10L, "2024/06/08 13:54:30", "2024/06/08 23:54:30", status[0]),
                new Category(72L, 72L, 6L, 13L, 18L, 8L, "2024/06/09 13:56:30", "2024/06/09 23:56:30", status[1]),
                new Category(73L, 73L, 3L, 12L, 16L, 5L, "2024/06/10 13:58:30", "2024/06/10 23:58:30", status[0]),
                new Category(74L, 74L, 3L, 11L, 14L, 3L, "2024/06/11 14:00:30", "2024/06/11 00:00:30", status[0]),
                new Category(75L, 75L, 3L, 10L, 12L, 10L, "2024/06/12 14:02:30", "2024/06/12 00:02:30", status[1]),
                new Category(76L, 76L, 3L, 9L, 10L, 8L, "2024/06/13 14:04:30", "2024/06/13 00:04:30", status[0]),
                new Category(77L, 77L, 3L, 8L, 8L, 5L, "2024/06/14 14:06:30", "2024/06/14 00:06:30", status[0]),
                new Category(78L, 78L, 3L, 7L, 6L, 12L, "2024/06/15 14:08:30", "2024/06/15 00:08:30", status[0]),
                new Category(79L, 79L, 3L, 6L, 4L, 10L, "2024/06/16 14:10:30", "2024/06/16 00:10:30", status[0]),
                new Category(80L, 80L, 3L, 5L, 2L, 8L, "2024/06/17 14:12:30", "2024/06/17 00:12:30", status[0]),
                new Category(81L, 81L, 3L, 4L, 4L, 5L, "2024/06/18 14:14:30", "2024/06/18 00:14:30", status[0]),
                new Category(82L, 82L, 3L, 3L, 6L, 2L, "2024/06/19 14:16:30", "2024/06/19 00:16:30", status[0]),
                new Category(83L, 83L, 3L, 2L, 8L, 10L, "2024/06/20 14:18:30", "2024/06/20 00:18:30", status[0]),
                new Category(84L, 84L, 3L, 1L, 10L, 8L, "2024/06/21 14:20:30", "2024/06/21 00:20:30", status[0]),
                new Category(85L, 85L, 8L, 18L, 12L, 10L, "2024/06/22 14:22:30", "2024/06/22 00:22:30", status[0]),
                new Category(86L, 86L, 8L, 17L, 14L, 8L, "2024/06/23 14:24:30", "2024/06/23 00:24:30", status[0]),
                new Category(87L, 87L, 8L, 16L, 16L, 5L, "2024/06/24 14:26:30", "2024/06/24 00:26:30", status[0]),
                new Category(88L, 88L, 8L, 15L, 18L, 12L, "2024/06/25 14:28:30", "2024/06/25 00:28:30", status[1]),
                new Category(89L, 89L, 8L, 14L, 20L, 10L, "2024/06/26 14:30:30", "2024/06/26 00:30:30", status[0]),
                new Category(90L, 90L, 8L, 13L, 18L, 8L, "2024/06/27 14:32:30", "2024/06/27 00:32:30", status[0]),
                new Category(91L, 91L, 8L, 12L, 16L, 5L, "2024/06/28 14:34:30", "2024/06/28 00:34:30", status[1]),
                new Category(92L, 92L, 8L, 11L, 14L, 3L, "2024/06/29 14:36:30", "2024/06/29 00:36:30", status[0]),
                new Category(93L, 93L, 8L, 10L, 12L, 10L, "2024/06/30 14:38:30", "2024/06/30 00:38:30", status[0]),
                new Category(94L, 94L, 8L, 9L, 10L, 8L, "2024/07/01 14:40:30", "2024/07/01 00:40:30", status[0]),
                new Category(95L, 95L, 8L, 8L, 8L, 5L, "2024/07/02 14:42:30", "2024/07/02 00:42:30", status[0]),
                new Category(96L, 96L, 8L, 7L, 6L, 12L, "2024/07/03 14:44:30", "2024/07/03 00:44:30", status[0]),
                new Category(97L, 97L, 7L, 6L, 4L, 10L, "2024/07/04 14:46:30", "2024/07/04 00:46:30", status[0]),
                new Category(98L, 98L, 7L, 5L, 2L, 8L, "2024/07/05 14:48:30", "2024/07/05 00:48:30", status[1]),
                new Category(99L, 99L, 7L, 4L, 4L, 5L, "2024/07/06 14:50:30", "2024/07/06 00:50:30", status[0]),
                new Category(100L, 100L, 7L, 3L, 6L, 2L, "2024/07/07 14:52:30", "2024/07/07 00:52:30", status[0]),
                new Category(101L, 101L, 7L, 2L, 8L, 10L, "2024/07/08 14:54:30", "2024/07/08 00:54:30", status[1]),
                new Category(102L, 102L, 7L, 1L, 10L, 8L, "2024/07/09 14:56:30", "2024/07/09 00:56:30", status[1]),
                new Category(103L, 103L, 7L, 18L, 12L, 10L, "2024/07/10 14:58:30", "2024/07/10 00:58:30", status[1]),
                new Category(104L, 104L, 7L, 17L, 14L, 8L, "2024/07/11 15:00:30", "2024/07/11 01:00:30", status[0]),
                new Category(105L, 105L, 7L, 16L, 16L, 5L, "2024/07/12 15:02:30", "2024/07/12 01:02:30", status[0]),
                new Category(106L, 106L, 7L, 15L, 18L, 12L, "2024/07/13 15:04:30", "2024/07/13 01:04:30", status[1]),
                new Category(107L, 107L, 7L, 14L, 20L, 10L, "2024/07/14 15:06:30", "2024/07/14 01:06:30", status[0])

        );
    }
    private static long getRandomLong(long max) {
        return 1L + (long) (Math.random() * (max - 1L + 1));
    }


    @Override
    public List<Object[]> getAllAuthorsTranslatorsPublicationsGenres() {
        return categoryRepository.findAllAuthorsTranslatorsPublicationsGenres();
    }

    @Override
    public List<CategoryDTO> getBook() {
        return categoryRepository.getBooks();
    }

}
