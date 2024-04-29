package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.dto.StoriesBookDTO;
import cdweb.sellstories.sellstories.entity.Category;
import cdweb.sellstories.sellstories.entity.StoriesBook;
import cdweb.sellstories.sellstories.mapper.StoriesBookMapper;
import cdweb.sellstories.sellstories.repository.StoriesBookRepository;
import cdweb.sellstories.sellstories.service.StoriesBookService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoriesBookImpl implements StoriesBookService {
    final StoriesBookRepository storiesBookRepository;





    // lưu thông tin mặc định trên DB
    @PostConstruct
    public void addDefaultStoriesBook() {
        storiesBookRepository.saveAll(generatestoriesBooks());
    }
    
    private List<StoriesBook> generatestoriesBooks() {
        String[] status = {"Hoạt động","Sắp ra mắt"};

   return 
                Arrays.asList(
                    new StoriesBook(
                            1L,
                            "Hành trình phiêu lưu của anh hùng",
                            "[URL hình ảnh truyện]",
                            50000,
                            "Truyện kể về cuộc hành trình của một anh hùng trẻ tuổi đi tìm kiếm khám phá và phiêu lưu trong thế giới rộng lớn, đầy nguy hiểm và bí ẩn.",
                            12,
                            status[0],
                            50,
                            "2024/04/22 12:20:30", 
                            "2024/04/22 23:20:30"
                            
                    ),
                    new StoriesBook(
                            2L,
                            "Thiên Địa Huyền Trân",
                            "[URL hình ảnh truyện]",
                            120000,
                            "Trong một thế giới đầy phép thuật, người anh hùng phải chiến đấu với bóng tối để bảo vệ hòa bình cho nhân loại.",
                            12,
                            status[0],
                            500,"2024/04/23 12:22:30", "2024/04/23 23:22:30"
                    ), new StoriesBook(
                            3L,
                            "Thiên Long Bát Bộ",
                            "[URL hình ảnh truyện]",
                            30000,
                            "Bốn anh hùng hội tụ, từng người mang một sức mạnh khác nhau, hợp tác nhau để chống lại thế lực hắc ám.",
                            12,
                            status[0],
                            640,
                                "2024/04/24 12:24:30", "2024/04/24 23:24:30"
                    ),
                    new StoriesBook(
                            4L,
                            "Tru Tiên",
                            "[URL hình ảnh truyện]",
                            150000,
                            "Câu chuyện về một thiếu niên từ thế giới thực nhập vào thế giới Tiên Ma, học được nghệ thuật tu luyện để trở thành một đấng sáng tạo mới.",
                            12,
                            status[1],
                            504, "2024/04/22 12:20:30", "2024/04/22 23:20:30"
                    ),
                    new StoriesBook(
                            5L,
                            "Thần Điêu Đại Hiệp",
                            "[URL hình ảnh truyện]",
                            780000,
                            "Hành trình của một thiếu niên trẻ tuổi, chiến đấu với quỷ dữ và học hỏi các bí kíp võ công.",
                            12,
                            status[1],
                            6450, "2024/04/23 12:22:30", "2024/04/23 23:22:30"
                    ),
                    new StoriesBook(
                            6L,
                            "Tam Quốc Chí",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Trong cuộc chiến tranh Tam Quốc, những anh hùng và bậc thầy võ thuật chiến đấu cho quyền lực và danh vọng của mình.",
                            12,
                            status[1],
                            7880, "2024/04/24 12:24:30", "2024/04/24 23:24:30"
                    ),
                    new StoriesBook(
                            7L,
                            "Kim Dung Kỳ Duyên",
                            "[URL hình ảnh truyện]",
                            670000,
                            " Một tác phẩm đặc sắc của Kim Dung, kể về cuộc đấu tranh giữa lương dân và quỷ dữ, với những pha hành động đầy kịch tính và những mối tình phức tạp.",
                            12,
                            status[1],
                            5670, "2024/04/25 12:26:30", "2024/04/25 23:26:30"
                    ),
                    new StoriesBook(
                            8L,
                            "Thiên Long Nội Công",
                            "[URL hình ảnh truyện]",
                            500000,
                            "Một truyền thuyết về sức mạnh bí ẩn của nội công thiên long, chỉ có người được chọn mới có thể khám phá được.",
                            12,
                            status[1],
                            540, "2024/04/26 12:28:30", "2024/04/26 23:28:30"
                    ),
                    new StoriesBook(
                            9L,
                            "Thiên Hạ Đệ Nhất Kiếm",
                            "[URL hình ảnh truyện]",
                            560000,
                            "Cuộc phiêu lưu của một kiếm khách tài ba, đi khắp thiên hạ để tìm kiếm bí mật của bậc đại thánh.",
                            12,
                            status[0],
                            6740, "2024/05/01 12:30:30", "2024/05/01 23:30:30"
                    ),
                    new StoriesBook(
                            10L,
                            "Thần Kiếm Bá Nghịch",
                            "[URL hình ảnh truyện]",
                            520000,
                            "Hành trình của một thiếu niên trẻ tuổi, chiến đấu với quỷ dữ và học hỏi các bí kíp võ công.",
                            12,
                            status[0],
                            4150, "2024/05/02 12:32:30", "2024/05/02 23:32:30"
                    ),
                    new StoriesBook(
                            11L,
                            "Thiên Kiếm Thiên Hạ",
                            "[URL hình ảnh truyện]",
                            670000,
                            "Truyện kể về một sát thủ giỏi nhất, nhưng muốn tìm lại chính bản thân mình và bắt đầu một cuộc sống mới.",
                            12,
                            status[1],
                            3520, "2024/05/03 12:34:30", "2024/05/03 23:34:30"
                    ),
                    new StoriesBook(
                            12L,
                            "Thiên Địa Vô Ngân",
                            "[URL hình ảnh truyện]",
                            120000,
                            "Sự trỗi dậy của một anh hùng từ thế kỷ thứ XXI, nhập vào thế giới tiên hiệp và trở thành một vị thần.",
                            12,
                            status[1],
                            6730, "2024/05/04 12:36:30", "2024/05/04 23:36:30"
                    ),
                    new StoriesBook(
                            13L,
                            "Thiên Cơ Hội Tụ",
                            "[URL hình ảnh truyện]",
                            250000,
                            "Một cô gái trẻ tài năng, có khả năng điều khiển các yếu tố tự nhiên, phải đối mặt với sự thử thách của số phận để bảo vệ thế giới.",
                            12,
                            status[0],
                            3210, "2024/05/05 12:38:30", "2024/05/05 23:38:30"
                    ),
                    new StoriesBook(
                            14L,
                            "Thiên Tôn Chiến Quốc",
                            "[URL hình ảnh truyện]",
                            150000,
                            "Trong thế giới đầy tranh đấu của Chiến Quốc, một thiên tôn mạnh mẽ nổi lên, chiến đấu để thống nhất thiên hạ.",
                            12,
                            status[0],
                            4520, "2024/05/06 12:40:30", "2024/05/06 23:40:30"
                    ),
                    new StoriesBook(
                            15L,
                            "Thiên Hạ Đệ Nhất Pháp Sư",
                            "[URL hình ảnh truyện]",
                            850000,
                            "Một pháp sư tài ba, sử dụng sức mạnh của pháp thuật để bảo vệ thế giới khỏi sự xâm lược của ác quỷ.",
                            12,
                            status[0],
                            3250, "2024/04/22 12:20:30", "2024/04/22 23:20:30"
                    ),
                    new StoriesBook(
                            16L,
                            "Thần Điêu Hiệp Lữ",
                            "[URL hình ảnh truyện]",
                            650000,
                            "Cuộc phiêu lưu của một thiếu niên từ thế giới hiện đại, nhập vào thế giới tiên hiệp và trở thành một trong những hiệp sĩ huyền thoại.",
                            12,
                            status[1],
                            3150, "2024/04/23 12:22:30", "2024/04/23 23:22:30"
                    ),
                    new StoriesBook(
                            17L,
                            "Thiên Kiếm Đồ Long",
                            "[URL hình ảnh truyện]",
                            670000,
                            " Hành trình của một kiếm sĩ tài ba, đi tìm kiếm danh vọng và sức mạnh trong thế giới đầy rẻo ràm và nguy hiểm.",
                            12,
                            status[0],
                            5130, "2024/04/24 12:24:30", "2024/04/24 23:24:30"
                    ),
                    new StoriesBook(
                            18L,
                            "Thiên Đạo Kỳ Duyên",
                            "[URL hình ảnh truyện]",
                            560000,
                            "Một câu chuyện về định mệnh và tình yêu, khi hai linh hồn gặp nhau trong cuộc đời này và tiếp tục hành trình của mình.",
                            12,
                            status[0],
                            3450, "2024/04/25 12:26:30", "2024/04/25 23:26:30"
                    ),
                    new StoriesBook(
                            19L,
                            "Thiên Hạ Đệ Nhất Tuyệt Sát",
                            "[URL hình ảnh truyện]",
                            890000,
                            "Với võ công tuyệt đỉnh, một tuyệt sát vô danh lang thang khắp thiên hạ, chống lại bất kỳ kẻ thù nào dám đứng trước mình.",
                            12,
                            status[0],
                            1232, "2024/04/26 12:28:30", "2024/04/26 23:28:30"
                    ),
                    new StoriesBook(
                            20L,
                            "Thần Kiếm Huyền Thoại",
                            "[URL hình ảnh truyện]",
                            670000,
                            "Truyện kể về một thanh kiếm huyền thoại, chỉ có người có tâm hồn trong sạch mới có thể sử dụng được.",
                            12,
                            status[0],
                            7540, "2024/04/27 12:30:30", "2024/04/27 23:30:30"
                    ),
                    new StoriesBook(
                            21L,
                            "Thiên Thần Chiến Quốc",
                            "[URL hình ảnh truyện]",
                            750000,
                            "Cuộc hành trình của một thiên thần từ thiên đàng xuống trần gian, chiến đấu để bảo vệ nhân loại khỏi thảm họa.",
                            12,
                            status[0],
                            3150, "2024/04/28 12:32:30", "2024/04/28 23:32:30"
                    ),
                    new StoriesBook(
                            22L,
                            "Thiên Hạ Đệ Nhất Vương Tử",
                            "[URL hình ảnh truyện]",
                            560000,
                            "Một vương tử tài năng, phải vượt qua nhiều thử thách để đạt được vị trí cao nhất trong triều đại.",
                            12,
                            status[0],
                            5420, "2024/04/29 12:34:30", "2024/04/29 23:34:30"
                    ),
                    new StoriesBook(
                            23L,
                            "Thiên Cơ Mộng Du",
                            "[URL hình ảnh truyện]",
                            850000,
                            "Cuộc phiêu lưu của một thiếu niên, đi tìm kiếm bí ẩn về nguồn gốc của bản thân và tiên kiếm.",
                            12,
                            status[0],
                            3250, "2024/04/30 12:36:30", "2024/04/30 23:36:30"
                    ),
                    new StoriesBook(
                            24L,
                            "Thiên Hạ Đệ Nhất Thần Tộc",
                            "[URL hình ảnh truyện]",
                            790000,
                            "Truyện kể về cuộc chiến giữa những thần tộc có sức mạnh phi thường, với những bí mật được giấu kín.",
                            12,
                            status[0],
                            5120, "2024/05/01 12:38:30", "2024/05/01 23:38:30"
                    ),
                    new StoriesBook(
                            25L,
                            "Thiên Tôn Lạc Vũ",
                            "[URL hình ảnh truyện]",
                            250000,
                            "Một thanh niên tài ba, sử dụng sức mạnh của thiên tôn để chiến đấu với bóng tối và bảo vệ thế giới.",
                            12,
                            status[0],
                            8750, "2024/05/02 12:40:30", "2024/05/02 23:40:30"
                    ),
                    new StoriesBook(
                            26L,
                            "Ngũ Thần Kiếm",
                            "[URL hình ảnh truyện]",
                            350000,
                            " Một câu chuyện về năm vị thần kiếm, mỗi người mang một sức mạnh riêng biệt, cùng hợp sức chiến đấu để đánh bại thế lực đen tối.",
                            12,
                            status[0],
                            5210, "2024/05/03 12:42:30", "2024/05/03 23:42:30"
                    ),
                    new StoriesBook(
                            27L,
                            "Kiếm Thánh Hành",
                            "[URL hình ảnh truyện]",
                            530000,
                            "Cuộc hành trình của một thanh kiếm huyền thoại, từ thời xưa đến hiện đại, truy tìm và giải mã những bí ẩn của thế giới.",
                            12,
                            status[0],
                            1350, "2024/05/04 12:44:30", "2024/05/04 23:44:30"
                    ),
                    new StoriesBook(
                            28L,
                            "Huyền Thoại Kiếm Hoa",
                            "[URL hình ảnh truyện]",
                            450000,
                            "Truyện kể về một cô gái trẻ tuổi, với khát vọng trở thành một kiếm sĩ vĩ đại và chiến đấu cho công lý và sự tự do.",
                            12,
                            status[0],
                            4320, "2024/05/05 12:46:30", "2024/05/05 23:46:30"
                    ),
                    new StoriesBook(
                            29L,
                            "Truyền Kỳ Kiếm Thánh",
                            "[URL hình ảnh truyện]",
                            560000,
                            " Một cuộc phiêu lưu đầy mạo hiểm của một đội kiếm sĩ, đi qua nhiều thử thách và đối mặt với nguy hiểm để bảo vệ thế giới.",
                            12,
                            status[0],
                            4240, "2024/05/06 12:48:30", "2024/05/06 23:48:30"
                    ),
                    new StoriesBook(
                            30L,
                            "Kiếm Vương Thần Tình",
                            "[URL hình ảnh truyện]",
                            430000,
                            "Kể về hành trình của một kiếm sĩ vĩ đại, tìm kiếm sự thật về người cha mất tích và giải cứu vương quốc khỏi sự thống trị của kẻ thù.",
                            12,
                            status[0],
                            3130, "2024/05/07 12:50:30", "2024/05/07 23:50:30"
                    ),
                    new StoriesBook(
                            31L,
                            "Thiên Kiếm Dị Tộc",
                            "[URL hình ảnh truyện]",
                            650000,
                            " Cuộc phiêu lưu của một kiếm sĩ tài ba, điều tra và chống lại các thế lực hắc ám từ thế giới dị tộc.",
                            12,
                            status[0],
                            3142, "2024/04/29 12:34:30", "2024/04/29 23:34:30"
                    ),
                    new StoriesBook(
                            32L,
                            "Thần Kiếm Truyền Kỳ",
                            "[URL hình ảnh truyện]",
                            530000,
                            " Truyện kể về một thanh kiếm có sức mạnh siêu nhiên, có thể đánh bại bất kỳ kẻ thù nào, và cuộc phiêu lưu của người sở hữu nó.",
                            12,
                            status[0],
                            5310, "2024/04/30 12:36:30", "2024/04/30 23:36:30"
                    ),
                    new StoriesBook(
                            33L,
                            "Vô Thượng Kiếm Tu",
                            "[URL hình ảnh truyện]",
                            430000,
                            " Một kiếm sĩ giỏi nhất, sau khi trải qua hàng trăm năm tu luyện, đã đạt được sức mạnh vô song và sử dụng kiếm thuật của mình để bảo vệ thiên hạ.",
                            12,
                            status[0],
                            5432, "2024/05/01 12:38:30", "2024/05/01 23:38:30"
                    ),
                    new StoriesBook(
                            34L,
                            "Thiên Kiếm Thánh Tông",
                            "[URL hình ảnh truyện]",
                            450000,
                            " Truyện kể về cuộc hành trình của một thiếu niên trẻ tuổi, được đào tạo để trở thành một trong những kiếm sĩ vĩ đại nhất trong lịch sử.",
                            12,
                            status[0],
                            6750, "2024/05/02 12:40:30", "2024/05/02 23:40:30"
                    ),
                    new StoriesBook(
                            35L,
                            "Thế Giới Điện Ảnh Huyền Bí",
                            "[URL hình ảnh truyện]",
                            320000,
                            "Một câu chuyện về cuộc hành trình của một nhóm diễn viên, bước vào thế giới của những câu chuyện huyền bí và siêu nhiên.",
                            12,
                            status[1],
                            5120, "2024/05/03 12:42:30", "2024/05/03 23:42:30"
                    ),
                    new StoriesBook(
                            36L,
                            "Cuộc Phiêu Lưu Trong Hang Động",
                            "[URL hình ảnh truyện]",
                            650000,
                            "Truyện kể về cuộc phiêu lưu của một nhóm dũng sĩ, khám phá các hang động bí ẩn và đối mặt với những thử thách nguy hiểm.",
                            12,
                            status[1],
                            2310, "2024/05/04 12:44:30", "2024/05/04 23:44:30"
                    ),
                    new StoriesBook(
                            37L,
                            "Kỳ Quan Thế Giới Bí Ẩn",
                            "[URL hình ảnh truyện]",
                            30000,
                            "Một loạt các kỳ quan thế giới, từ các ngôi đền cổ đến các khu rừng bí ẩn, đang chờ đợi được khám phá và giải mã.",
                            12,
                            status[0],
                            5120, "2024/05/05 12:46:30", "2024/05/05 23:46:30"
                    ),
                    new StoriesBook(
                            38L,
                            "Hành Trình Đến Vùng Đất Huyền Bí",
                            "[URL hình ảnh truyện]",
                            530000,
                            "Cuộc phiêu lưu của một nhóm dũng sĩ, đi tìm kiếm vùng đất huyền bí và khám phá những bí mật của nó.",
                            12,
                            status[0],
                            3210, "2024/05/06 12:48:30", "2024/05/06 23:48:30"
                    ),
                    new StoriesBook(
                            39L,
                            "Thành Phố Ma Quái",
                            "[URL hình ảnh truyện]",
                            42000,
                            "Truyện kể về một thành phố bị ma ám, nơi mà các linh hồn bất an lang thang và nguy hiểm luôn đe dọa mọi sinh mạng.",
                            12,
                            status[0],
                            3130, "2024/05/07 12:50:30", "2024/05/07 23:50:30"
                    ),
                    new StoriesBook(
                            40L,
                            "Bí Mật Cổ Xưa",
                            "[URL hình ảnh truyện]",
                            430000,
                            "Kể về cuộc hành trình của một nhóm khám phá, khám phá các bí mật cổ xưa và các di tích bí ẩn trên khắp thế giới.",
                            12,
                            status[0],
                            5420, "2024/05/08 12:52:30", "2024/05/08 23:52:30"
                    ),
                    new StoriesBook(
                            41L,
                            "Thiên Đàng Hay Địa Ngục",
                            "[URL hình ảnh truyện]",
                            540000,
                            " Truyện kể về cuộc hành trình của một nhóm người, đi qua những thế giới huyền bí và đối mặt với các thế lực siêu nhiên.",
                            12,
                            status[1],
                            5420, "2024/05/09 12:54:30", "2024/05/09 23:54:30"
                    ),
                    new StoriesBook(
                            42L,
                            "Ma Sơn Quỷ Thôn",
                            "[URL hình ảnh truyện]",
                            760000,
                            "Một ngôi làng bị ma ám, nơi mà các linh hồn bất an lang thang và sự tăm tối luôn hiện hữu, đang chờ đợi được giải cứu.",
                            12,
                            status[1],
                            2350, "2024/05/10 12:56:30", "2024/05/10 23:56:30"
                    ),
                    new StoriesBook(
                            43L,
                            "Bí Ẩn Huyền Bí",
                            "[URL hình ảnh truyện]",
                            120000,
                            "Một thám tử tài ba điều tra các vụ án kỳ lạ và hiện tượng siêu nhiên, đối mặt với sự huyền bí và nguy hiểm.",
                            12,
                            status[0],
                            3150, "2024/05/11 12:58:30", "2024/05/11 23:58:30"
                    ),
                    new StoriesBook(
                            44L,
                            "Đền Thờ Hắc Ám",
                            "[URL hình ảnh truyện]",
                            650000,
                            "Truyện kể về một đền thờ cổ xưa, nơi mà các linh hồn bị mắc kẹt và các hồn ma đang chờ đợi được giải thoát.",
                            12,
                            status[0],
                            5320, "2024/05/12 13:00:30", "2024/05/12 23:00:30"
                    ),
                    new StoriesBook(
                            45L,
                            "Ngôi Lâu Ma Quỷ",
                            "[URL hình ảnh truyện]",
                            210000,
                            "Bí mật về một ngôi lâu ma quỷ, nơi mà những sự kiện kỳ lạ và ma quỷ thường xuyên xảy ra, đang chờ đợi được khám phá.",
                            12,
                            status[0],
                            540, "2024/05/13 13:02:30", "2024/05/13 23:02:30"
                    ),
                    new StoriesBook(
                            46L,
                            "Thế Giới Bí Ẩn",
                            "[URL hình ảnh truyện]",
                            870000,
                            "Kể về cuộc phiêu lưu của một nhóm thanh niên trẻ, khám phá các bí ẩn và hiện tượng siêu nhiên trong thế giới đầy bí ẩn này.",
                            12,
                            status[0],
                            1120, "2024/05/14 13:04:30", "2024/05/14 23:04:30"
                    ),
                    new StoriesBook(
                            47L,
                            "Cuộc Phiêu Lưu Của Siêu Nhân Hài Hước",
                            "[URL hình ảnh truyện]",
                            430000,
                            "Kể về cuộc hành trình của một siêu nhân không bình thường, luôn gặp phải những tình huống hài hước và khó đỡ trong cuộc sống hàng ngày.",
                            12,
                            status[1],
                            3110, "2024/05/15 13:06:30", "2024/05/15 23:06:30"
                    ),
                    new StoriesBook(
                            48L,
                            "Thám Tử Hài Hước và Vụ Án Kỳ Quặc",
                            "[URL hình ảnh truyện]",
                            570000,
                            " Một câu chuyện về một thám tử tinh nghịch, luôn gặp phải những vụ án kỳ quặc và phải dùng trí thông minh và sự hài hước để giải quyết chúng.",
                            12,
                            status[1],
                            5430, "2024/05/16 13:08:30", "2024/05/16 23:08:30"
                    ),
                    new StoriesBook(
                            49L,
                            "Những Câu Chuyện Vui Nhộn Trong Lớp Học",
                            "[URL hình ảnh truyện]",
                            50000,
                            "Kể về cuộc sống học đường của một nhóm bạn thân, luôn gặp phải những tình huống hài hước và dễ thương trong lớp học và ngoài trời.",
                            12,
                            status[0],
                            50, "2024/05/17 13:10:30", "2024/05/17 23:10:30"
                    ),
                    new StoriesBook(
                            50L,
                            "Thế Giới Đùa Vui và Trò Đùa Hài Hước",
                            "[URL hình ảnh truyện]",
                            130000,
                            "Một cuộc phiêu lưu đầy hài hước của các nhân vật, tham gia vào các trò đùa và trò chơi vui nhộn trên khắp thế giới.",
                            12,
                            status[0],
                            5450, "2024/05/18 13:12:30", "2024/05/18 23:12:30"
                    ),
                    new StoriesBook(
                            51L,
                            "Siêu Anh Hùng Hài Hước và Kẻ Thù Quái Dị",
                            "[URL hình ảnh truyện]",
                            450000,
                            "Cuộc chiến giữa một siêu anh hùng hài hước và một kẻ thù quái dị, đầy tình huống hài hước và trớ trêu.",
                            12,
                            status[0],
                            5450, "2024/05/19 13:14:30", "2024/05/19 23:14:30"
                    ),
                    new StoriesBook(
                            52L,
                            "Cuộc Phiêu Lưu Vui Nhộn Trên Hành Tinh Xanh",
                            "[URL hình ảnh truyện]",
                            650000,
                            "Một nhóm nhân vật vui nhộn, tham gia vào cuộc phiêu lưu đầy hài hước trên một hành tinh xa xôi, gặp phải những tình huống dở khóc dở cười.",
                            12,
                            status[1],
                            4350, "2024/05/20 13:16:30", "2024/05/20 23:16:30"
                    ),
                    new StoriesBook(
                            53L,
                            "Cuộc Phiêu Lưu của Gấu Trúc Hài Hước",
                            "[URL hình ảnh truyện]",
                            50000,
                            "Kể về cuộc hành trình vui nhộn của một chú gấu trúc, luôn gặp phải những tình huống dở khóc dở cười trong mọi chuyến phiêu lưu.",
                            12,
                            status[1],
                            50, "2024/05/21 13:18:30", "2024/05/21 23:18:30"
                    ),
                    new StoriesBook(
                            54L,
                            "Trò Đùa Kỳ Quặc của Gấu Bắc Cực",
                            "[URL hình ảnh truyện]",
                            420000,
                            "Một câu chuyện về một chú gấu bắc cực thích đùa và tạo ra những trò đùa kỳ quặc, làm mọi người xung quanh cười không ngớt.",
                            12,
                            status[0],
                            5310, "2024/05/22 13:20:30", "2024/05/22 23:20:30"
                    ),
                    new StoriesBook(
                            55L,
                            "Những Câu Chuyện Hài Hước Của Chó Nhỏ",
                            "[URL hình ảnh truyện]",
                            540000,
                            " Cuộc sống hài hước của một chú chó nhỏ, luôn gây ra những tình huống dở khóc dở cười và mang lại tiếng cười cho mọi người.",
                            12,
                            status[0],
                            5120, "2024/05/24 13:24:30", "2024/05/24 23:24:30"
                    ),
                    new StoriesBook(
                            56L,
                            "Cuộc Phiêu Lưu Vui Nhộn Của Mèo Mập",
                            "[URL hình ảnh truyện]",
                            120000,
                            "Kể về cuộc phiêu lưu đầy hài hước của một chú mèo mập, luôn muốn khám phá thế giới xung quanh và gặp phải những tình huống khó đỡ.",
                            12,
                            status[1],
                            520, "2024/05/23 13:22:30", "2024/05/23 23:22:30"
                    ),
                    new StoriesBook(
                            57L,
                            "Trò Đùa Kinh Dị Của Con Ma Nhí",
                            "[URL hình ảnh truyện]",
                            120000,
                            "Một câu chuyện về một con ma nhí thích đùa giỡn và tạo ra những trò đùa kinh dị, nhưng lại mang tính hài hước và dễ thương.",
                            12,
                            status[0],
                            5310, "2024/05/25 13:26:30", "2024/05/25 23:26:30"
                    ),
                    new StoriesBook(
                            58L,
                            "Cuộc Phiêu Lưu Hài Hước Của Người Ngoài Hành Tinh",
                            "[URL hình ảnh truyện]",
                            890000,
                            "Cuộc hành trình vui nhộn của một nhóm người ngoài hành tinh, khám phá trái đất và gặp phải những tình huống dở khóc dở cười trong cuộc sống hàng ngày.",
                            12,
                            status[0],
                            4320, "2024/05/26 13:28:30", "2024/05/26 23:28:30"
                    ),
                    new StoriesBook(
                            59L,
                            "Phiêu Lưu Trên Đại Dương Xanh",
                            "[URL hình ảnh truyện]",
                            23000,
                            "Kể về cuộc hành trình của một thủy thủ đoàn, khám phá những vùng biển xa xôi và đối mặt với những cơn gió lớn và sóng to trên đại dương bao la.",
                            12,
                            status[1],
                            3210, "2024/05/27 13:30:30", "2024/05/27 23:30:30"
                    ), new StoriesBook(
                            60L,
                            "Truy Tìm Thành Phố Hoàng Kim",
                            "[URL hình ảnh truyện]",
                            50000,
                            "Một cuộc hành trình tìm kiếm thành phố huyền thoại, nơi mà vàng và kim cương rực rỡ, nhưng cũng ẩn chứa nguy hiểm và bí ẩn không lường trước.",
                            12,
                            status[0],
                            520, "2024/05/28 13:32:30", "2024/05/28 23:32:30"
                    ), new StoriesBook(
                            61L,
                            "Hành Trình Trong Hang Động Bí Ẩn",
                            "[URL hình ảnh truyện]",
                            120000,
                            "Kể về cuộc hành trình của một nhóm khám phá, khám phá những hang động bí ẩn và phải đối mặt với những thách thức và nguy hiểm trong bóng tối của hang động.",
                            12,
                            status[0],
                            4350, "2024/05/29 13:34:30", "2024/05/29 23:34:30"
                    ), new StoriesBook(
                            62L,
                            "Phiêu Lưu Trên Đỉnh Núi Tuyết",
                            "[URL hình ảnh truyện]",
                            540000,
                            "Truyện kể về cuộc phiêu lưu của một đội leo núi, vượt qua những thử thách của đỉnh núi tuyết nguy hiểm nhất thế giới và đối mặt với sự sống và cái chết.",
                            12,
                            status[0],
                            1230, "2024/05/30 13:36:30", "2024/05/30 23:36:30"
                    ), new StoriesBook(
                            63L,
                            "Vượt Biển Động Sâu: ",
                            "[URL hình ảnh truyện]",
                            430000,
                            "Một cuộc hành trình vượt qua biển động sâu, trải qua những cơn bão lớn và những con sóng khổng lồ, để đến đích và tìm kiếm kho báu huyền thoại ở hòn đảo xa xôi.",
                            12,
                            status[0],
                            3130, "2024/05/31 13:38:30", "2024/05/31 23:38:30"
                    ), new StoriesBook(
                            64L,
                            "Cuộc Hành Trình Qua Sa Mạc Cát",
                            "[URL hình ảnh truyện]",
                            50000,
                            "Kể về cuộc phiêu lưu của một nhóm nhân vật, đi qua sa mạc cát khổng lồ, đối mặt với những cơn bão cát và những thách thức khắc nghiệt của môi trường sa mạc.",
                            12,
                            status[0],
                            3220, "2024/06/01 13:40:30", "2024/06/01 23:40:30"
                    ), new StoriesBook(
                            65L,
                            "Cuộc Phiêu Lưu Trên Khắp Thế Giới",
                            "[URL hình ảnh truyện]",
                            430000,
                            "Một nhóm nhân vật, đi qua các châu lục và quốc gia khác nhau, trải qua những cuộc phiêu lưu đầy màu sắc và hấp dẫn trên khắp thế giới.",
                            12,
                            status[0],
                            1230, "2024/06/02 13:42:30", "2024/06/02 23:42:30"
                    ), new StoriesBook(
                            66L,
                            "Hành Trình Trên Biển Sâu",
                            "[URL hình ảnh truyện]",
                            320000,
                            "Kể về cuộc phiêu lưu của một thủy thủ đoàn, đi qua những biển lớn và đại dương sâu thẳm, khám phá những hòn đảo xa xôi và những vùng biển kỳ bí.",
                            12,
                            status[0],
                            1230, "2024/06/03 13:44:30", "2024/06/03 23:44:30"
                    ), new StoriesBook(
                            67L,
                            "Thám Hiểm Đảo Hoang",
                            "[URL hình ảnh truyện]",
                            50000,
                            "Một cuộc phiêu lưu đầy mạo hiểm của một nhóm thám hiểm, khám phá một đảo hoang bí ẩn và phải đối mặt với những nguy hiểm không ngờ.",
                            12,
                            status[0],
                            1230, "2024/06/04 13:46:30", "2024/06/04 23:46:30"
                    ), new StoriesBook(
                            68L,
                            "Phiêu Lưu Trong Rừng Sâu",
                            "[URL hình ảnh truyện]",
                            50000,
                            "Truyện kể về cuộc hành trình của một nhóm bạn trẻ, đi sâu vào rừng hoang để tìm kiếm kho báu cổ xưa và khám phá những bí ẩn của nó.",
                            12,
                            status[0],
                            350, "2024/06/05 13:48:30", "2024/06/05 23:48:30"
                    ), new StoriesBook(
                            69L,
                            "Hành Trình Trên Đỉnh Thế Giới",
                            "[URL hình ảnh truyện]",
                            31000,
                            "Một câu chuyện về một nhóm dũng sĩ, leo núi và chinh phục những đỉnh cao nhất thế giới, đối mặt với những thách thức đầy mạo hiểm và nguy hiểm.",
                            12,
                            status[0],
                            3120, "2024/06/06 13:50:30", "2024/06/06 23:50:30"
                    ), new StoriesBook(
                            70L,
                            "Cuộc Hành Trình Vượt Núi Sâu",
                            "[URL hình ảnh truyện]",
                            340000,
                            " Kể về cuộc phiêu lưu của một nhóm bạn trẻ, vượt qua những ngọn núi cao, rừng sâu và sông lớn để khám phá những địa điểm kỳ thú.",
                            12,
                            status[0],
                            6570, "2024/06/07 13:52:30", "2024/06/07 23:52:30"
                    ), new StoriesBook(
                            71L,
                            "Cuộc Phiêu Lưu Trên Đại Dương Sâu Thẳm",
                            "[URL hình ảnh truyện]",
                            310000,
                            "Một thủy thủ đoàn dũng cảm bắt đầu cuộc hành trình trên đại dương sâu thẳm, khám phá những bí ẩn và nguy hiểm của đại dương rộng lớn.",
                            15,
                            "Đang tiến hành",
                            220, "2024/06/08 13:54:30", "2024/06/08 23:54:30"
                    ),
                    new StoriesBook(
                            72L,
                            "Cuộc Hành Trình Trong Thế Giới Ma Thuật",
                            "[URL hình ảnh truyện]",
                            240000,
                            "Kể về cuộc hành trình của một pháp sư trẻ tuổi, học cách sử dụng ma thuật và phải đối mặt với những thử thách và nguy hiểm trong thế giới ma thuật.",
                            12,
                            status[0],
                            150, "2024/06/09 13:56:30", "2024/06/09 23:56:30"
                    )

                    ,
                    new StoriesBook(
                            73L,
                            "Hành Trình Tìm Kiếm Quyền Lực Tối Thượng",
                            "[URL hình ảnh truyện]",
                            290000,
                            "Kể về cuộc phiêu lưu của một anh hùng trẻ tuổi, đi tìm kiếm quyền lực tối thượng để bảo vệ thế giới khỏi sự tàn phá của thế lực tà ác.",
                            14,
                            "Đang tiến hành",
                            200, "2024/06/10 13:58:30", "2024/06/10 23:58:30"
                    )

                    ,
                    new StoriesBook(
                            74L,
                            "Cuộc Phiêu Lưu Trong Thế Giới Kỳ Ảo",
                            "[URL hình ảnh truyện]",
                            280000,
                            "Một nhóm bạn trẻ khám phá thế giới kỳ ảo, gặp gỡ những sinh vật vàng người và phải đối mặt với những thách thức khó khăn.",
                            12,
                            status[0],
                            180, "2024/06/11 14:00:30", "2024/06/11 00:00:30"
                    )

                    ,
                    new StoriesBook(
                            75L,
                            "Thám Tử Trẻ Tuổi Và Bí Ẩn Của Thành Phố",
                            "[URL hình ảnh truyện]",
                            260000,
                            "Kể về cuộc phiêu lưu của một đội thám tử trẻ tuổi, điều tra các vụ án bí ẩn trong thành phố và phá giải những bí ẩn kinh hoàng.",
                            13,
                            "Đang tiến hành",
                            120, "2024/06/12 14:02:30", "2024/06/12 00:02:30"
                    )
                    ,
                    new StoriesBook(
                            76L,
                            "Cuộc Hành Trình Tìm Kho Báu Cổ Xưa",
                            "[URL hình ảnh truyện]",
                            220000,
                            "Một nhóm bạn trẻ bắt đầu cuộc hành trình tìm kiếm kho báu cổ xưa, đối mặt với những hiểm nguy và thử thách trong hang động và rừng sâu.",
                            11,
                            "Đang tiến hành",
                            150, "2024/06/13 14:04:30", "2024/06/13 00:04:30"
                    )
                    , new StoriesBook(
                            77L,
                            "Vượt Qua Những Thử Thách Trong Trò Chơi Ảo",
                            "[URL hình ảnh truyện]",
                            200000,
                            "Truyện kể về cuộc phiêu lưu của một nhóm game thủ, đối mặt với những thử thách khó khăn và nguy hiểm trong thế giới ảo đầy kỳ bí.",
                            12,
                            status[0],
                            100, "2024/06/14 14:06:30", "2024/06/14 00:06:30"
                    )
                    ,new StoriesBook(
                            78L,
                            "Hành Trình Tìm Kiếm Linh Hồn Mất Tích",
                            "[URL hình ảnh truyện]",
                            270000,
                            "Kể về cuộc phiêu lưu của một nhóm anh hùng, đi tìm kiếm linh hồn mất tích của người thân và đối mặt với những thách thức kỳ bí.",
                            13,
                            status[0],
                            180, "2024/06/15 14:08:30", "2024/06/15 00:08:30"
                    ),new StoriesBook(
                            79L,
                            "Cuộc Chiến Chống Lại Quỷ Vương",
                            "[URL hình ảnh truyện]",
                            320000,
                            "Kể về cuộc chiến của một đội anh hùng, chiến đấu chống lại thế lực tà ác của một quỷ vương đang âm mưu thống trị thế giới.",
                            15,
                            "Đang tiến hành",
                            200, "2024/06/16 14:10:30", "2024/06/16 00:10:30"
                    ),new StoriesBook(
                            80L,
                            "Hành Trình Tìm Lại Kí Ức Mất Mát",
                            "[URL hình ảnh truyện]",
                            290000,
                            "Một câu chuyện về cuộc hành trình của một người mất trí nhớ, đi tìm lại kí ức và quá khứ mất mát của mình trong một thế giới kỳ lạ và đầy bí ẩn.",
                            14,
                            "Đang tiến hành",
                            120, "2024/06/17 14:12:30", "2024/06/17 00:12:30"
                    )

                   ,new StoriesBook(
                            81L,
                            "Cuộc Đua Xe Hơi Hấp Dẫn",
                            "[URL hình ảnh truyện]",
                            180000,
                            "Kể về cuộc đua xe hơi giữa các nhân vật tài năng và quyết tâm, cạnh tranh để đạt đến đích và giành lấy danh hiệu vô địch.",
                            10,
                            status[0],
                            80, "2024/06/18 14:14:30", "2024/06/18 00:14:30"
                    ), new StoriesBook(
                            82L,
                            "Thế Giới Ma Thuật của Pháp Sư",
                            "[URL hình ảnh truyện]",
                            250000,
                            "Một câu chuyện về cuộc sống của một pháp sư trẻ tuổi, học cách sử dụng ma thuật và phải đối mặt với những kẻ thù ma quỷ đáng sợ.",
                            13,
                            "Đang tiến hành",
                            150, "2024/06/19 14:16:30", "2024/06/19 00:16:30"
                    ), new StoriesBook(
                            83L,
                            "Cuộc Hành Trình Vượt Sóng",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Kể về cuộc phiêu lưu của một nhóm bạn trẻ, vượt qua những biển sóng lớn và nguy hiểm để khám phá những hòn đảo hoang sơ và bí ẩn.",
                            12,
                            status[0],
                            6570, "2024/06/20 14:18:30", "2024/06/20 00:18:30"
                    ), new StoriesBook(
                            84L,
                            "Những Bước Chân Trên Con Đường Hạnh Phúc",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Một câu chuyện về tình bạn và tình yêu, qua những bước chân trên con đường tìm kiếm hạnh phúc và ý nghĩa cuộc sống.",
                            12,
                            status[0],
                            6570, "2024/06/21 14:20:30", "2024/06/21 00:20:30"
                    ), new StoriesBook(
                            85L,
                            "Chuyến Phiêu Lưu Trong Rừng Sâu",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Kể về cuộc phiêu lưu của một nhóm bạn trẻ, khám phá và trải nghiệm cuộc sống trong rừng sâu, gặp gỡ và vượt qua các thử thách.",
                            12,
                            status[0],
                            6570, "2024/06/23 14:24:30", "2024/06/23 00:24:30"
                    ), new StoriesBook(
                            86L,
                            "Những Khoảnh Khắc Ngọt Ngào",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Một câu chuyện về tình yêu và những khoảnh khắc ngọt ngào của tuổi trẻ, khi hai con người gặp nhau và trải qua những giây phút đáng nhớ.",
                            12,
                            status[0],
                            6570, "2024/06/22 14:22:30", "2024/06/22 00:22:30"
                    ), new StoriesBook(
                            87L,
                            "Bước Chân Trên Con Đường Mơ Mộng",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Kể về hành trình của một cô gái trẻ, vượt qua những khó khăn và thách thức để theo đuổi giấc mơ của mình.",
                            12,
                            status[0],
                            6570, "2024/06/24 14:26:30", "2024/06/24 00:26:30"
                    ), new StoriesBook(
                            88L,
                            "Góc Khuất Của Trái Tim",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Một câu chuyện về tình yêu và sự hy sinh, khi hai con người phải đối diện với những thử thách và chia sẻ những cảm xúc sâu thẳm trong lòng.",
                            12,
                            status[0],
                            6570, "2024/06/25 14:28:30", "2024/06/25 00:28:30"
                    ), new StoriesBook(
                            89L,
                            "Cuộc Hành Trình Qua Miền Đất Mê Cung",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Một câu chuyện kỳ thú về cuộc phiêu lưu của nhóm bạn trẻ, khám phá và chinh phục những thử thách khó khăn trong miền đất mê cung bí ẩn.",
                            12,
                            status[0],
                            6570, "2024/06/26 14:30:30", "2024/06/26 00:30:30"
                    ), new StoriesBook(
                            90L,
                            "Những Ngày Hạnh Phúc Bên Nhau",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Một câu chuyện tình yêu ngọt ngào về hai người trẻ tuổi, trải qua những khoảnh khắc hạnh phúc và ý nghĩa bên nhau.",
                            12,
                            status[0],
                            6570, "2024/06/27 14:32:30", "2024/06/27 00:32:30"
                    ), new StoriesBook(
                            91L,
                            "Chân Trời Mơ Ước",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Kể về hành trình của một cô gái trẻ, vượt qua những chướng ngại và khám phá những ước mơ của mình trên con đường cuộc sống.",
                            12,
                            status[0],
                            6570, "2024/06/28 14:34:30", "2024/06/28 00:34:30"
                    ), new StoriesBook(
                            92L,
                            "Cuộc Phiêu Lưu Trong Vùng Đất Phép Thuật",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Một câu chuyện màu sắc về cuộc phiêu lưu của một cô gái trẻ, khám phá và sử dụng sức mạnh phép thuật trong thế giới bí ẩn.",
                            12,
                            status[0],
                            6570, "2024/06/29 14:36:30", "2024/06/29 00:36:30"
                    ), new StoriesBook(
                            93L,
                            "Những Khoảnh Khắc Đáng Nhớ",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Một câu chuyện về tình yêu và những khoảnh khắc đáng nhớ của tuổi trẻ, khi hai con người trải qua những biến cố và thăng trầm trong cuộc sống.",
                            12,
                            status[0],
                            6570, "2024/06/30 14:38:30", "2024/06/30 00:38:30"
                    ), new StoriesBook(
                            94L,
                            "Vượt Qua Những Biến Cố",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Kể về cuộc hành trình của một cô gái trẻ, vượt qua những khó khăn và thách thức, tìm kiếm ý nghĩa cuộc sống và tìm thấy bản thân.",
                            12,
                            status[0],
                            6570, "2024/07/01 14:40:30", "2024/07/01 00:40:30"
                    ), new StoriesBook(
                            95L,
                            "Hành Trình Tìm Lối Thoát Khỏi Vương Quốc Phù Thủy",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Kể về cuộc phiêu lưu của một nhóm anh hùng, vượt qua các thử thách của vương quốc phù thủy để tìm lối thoát và giải cứu vương quốc.",
                            12,
                            status[0],
                            6570, "2024/07/02 14:42:30", "2024/07/02 00:42:30"
                    ),

                    new StoriesBook(
                            96L,
                            "Cuộc Chiến Giữa Ánh Sáng và Bóng Tối",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Một câu chuyện đầy kịch tính về cuộc chiến giữa các lực lượng của ánh sáng và bóng tối, với sự xuất hiện của những anh hùng và phép thuật.",
                            12,
                            status[0],
                            6570, "2024/07/03 14:44:30", "2024/07/03 00:44:30"
                    ),
                    new StoriesBook(
                            97L,
                            "Thế Giới Ma Thuật và Cuộc Hành Trình Cứu Rỗi",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Một cuộc hành trình mạo hiểm của nhóm anh hùng, khám phá thế giới ma thuật và đối mặt với những nguy hiểm để cứu rỗi thế giới.",
                            12,
                            status[0],
                            6570, "2024/07/04 14:46:30", "2024/07/04 00:46:30"
                    ),
                    new StoriesBook(
                            98L,
                            "Cuộc Chiến Chống Lại Quỷ Vương",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Kể về cuộc chiến của các anh hùng chống lại sự xâm lược của quỷ vương và bảo vệ thế giới khỏi sự hủy diệt.",
                            12,
                            status[0],
                            6570, "2024/07/05 14:48:30", "2024/07/05 00:48:30"
                    ),
                    new StoriesBook(
                            99L,
                            "Hành Trình Tìm Lại Linh Hồn Mất Mát",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Một câu chuyện truyền thuyết về cuộc hành trình của một anh hùng, tìm kiếm và tái khám phá linh hồn mất mát của mình trong thế giới fantasy.",
                            12,
                            status[0],
                            6570, "2024/07/06 14:50:30", "2024/07/06 00:50:30"
                    ),
                    new StoriesBook(
                            100L,
                            "Thế Giới Phép Thuật và Cuộc Chiến Bảo Vệ",
                            "[URL hình ảnh truyện]",
                            340000,
                            "Kể về thế giới phép thuật và cuộc chiến của các anh hùng để bảo vệ thế giới khỏi sự tàn phá của lực lượng hắc ám.",
                            12,
                            status[0],
                            6570, "2024/07/07 14:52:30", "2024/07/07 00:52:30"
                    ),
                    new StoriesBook(
                            101L,
                            "Cuộc Hành Trình Tìm Lối Thoát Khỏi Vương Quốc Ma",
                            "[URL hình ảnh truyện]",
                            280000,
                            "Một cuộc phiêu lưu nghẹt thở của nhóm anh hùng, tìm kiếm lối thoát khỏi vương quốc ma đầy nguy hiểm và bí ẩn.",
                            13,
                            "Đang tiến hành",
                            100, "2024/07/08 14:54:30", "2024/07/08 00:54:30"
                    ),
                    new StoriesBook(
                            102L,
                            "Thế Giới Phép Thuật và Cuộc Chiến Chống Lại Quỷ",
                            "[URL hình ảnh truyện]",
                            320000,
                            "Kể về cuộc chiến gay cấn giữa những pháp sư và quỷ dữ, với mục tiêu bảo vệ thế giới khỏi sự xâm lược của hắc ám.",
                            14,
                            "Đang tiến hành",
                            120, "2024/07/09 14:56:30", "2024/07/09 00:56:30"
                    ),
                    new StoriesBook(
                            103L,
                            "Truyền Thuyết Về Vương Quốc Ma Thuật",
                            "[URL hình ảnh truyện]",
                            300000,
                            "Một câu chuyện truyền thuyết về vương quốc ma thuật, nơi những pháp sư và yêu ma đối đầu trong cuộc chiến giữa ánh sáng và bóng tối.",
                            15,
                            status[0],
                            200, "2024/07/10 14:58:30", "2024/07/10 00:58:30"
                    ),
                    new StoriesBook(
                            104L,
                            "Cuộc Hành Trình Giải Cứu Công Chúa Mất Tích",
                            "[URL hình ảnh truyện]",
                            350000,
                            "Kể về cuộc phiêu lưu của một anh hùng, giải cứu công chúa mất tích khỏi bàn tay của kẻ ác và khám phá bí mật của vương quốc.",
                            12,
                            status[0],
                            150, "2024/07/11 15:00:30", "2024/07/11 01:00:30"
                    ),
                    new StoriesBook(
                            105L,
                            "Huyền Thoại Về Báu Vật Cổ Đại",
                            "[URL hình ảnh truyện]",
                            290000,
                            "Một câu chuyện huyền thoại về cuộc săn lùng báu vật cổ đại, nơi mọi người tham gia vào cuộc hành trình nguy hiểm và kỳ thú.",
                            16,
                            "Đang tiến hành",
                            180, "2024/07/12 15:02:30", "2024/07/12 01:02:30"
                    ),
                    new StoriesBook(
                            106L,
                            "Thế Giới Ma Thuật và Cuộc Chiến Bảo Vệ Thế Giới",
                            "[URL hình ảnh truyện]",
                            330000,
                            "Một cuộc hành trình của các anh hùng, bảo vệ thế giới khỏi sự tàn phá của các lực lượng ma thuật đen tối.",
                            13,
                            status[0],
                            220, "2024/07/13 15:04:30", "2024/07/13 01:04:30"
                    ),
                    new StoriesBook(
                            107L,
                            "Cuộc Hành Trình Tìm Lại Bí Mật Cổ Đại",
                            "[URL hình ảnh truyện]",
                            310000,
                            "Kể về cuộc phiêu lưu của một nhóm anh hùng, khám phá và tái khám phá bí mật cổ đại đầy kỳ bí và nguy hiểm.",
                            14,
                            "Đang tiến hành",
                            190, "2024/07/14 15:06:30", "2024/07/14 01:06:30"
                    )


            );
    }
    @Override
    public List<StoriesBookDTO> getAllStoriesBook() {
        return storiesBookRepository.findAll()
                .stream()
                .map(StoriesBookMapper::storiesBookToStoriesBookDTO)
                .collect(Collectors.toList());
    }
}
