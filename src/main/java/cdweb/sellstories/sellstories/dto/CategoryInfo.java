package cdweb.sellstories.sellstories.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryInfo {
    public String storyAuthorName;
    public String storyTranslatorName;
    public String placePublicationName;

    public CategoryInfo(String storyAuthorName, String storyTranslatorName, String placePublicationName) {
        this.storyAuthorName = storyAuthorName;
        this.storyTranslatorName = storyTranslatorName;
        this.placePublicationName = placePublicationName;
    }

    public static Map<String, List<CategoryInfo>> groupCategoryByGenre(List<Object[]> category) {
        Map<String, List<CategoryInfo>> groupedCategories = new HashMap<>();

        for (Object[] entry : category) {
            String storyAuthorName = (String) entry[0];
            String storyTranslatorName = (String) entry[1];
            String placePublicationName = (String) entry[2];
            String storyGenre = (String) entry[3];

            // Kiểm tra xem map đã có key storyGenre chưa
            if (!groupedCategories.containsKey(storyGenre)) {
                // Nếu chưa có, tạo mới một danh sách rỗng và thêm vào map
                groupedCategories.put(storyGenre, new ArrayList<>());
            }
            groupedCategories.get(storyGenre).add(new CategoryInfo(storyAuthorName, storyTranslatorName, placePublicationName));
        }

        return groupedCategories;
    }
}
