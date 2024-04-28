package cdweb.sellstories.sellstories.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LocalDateTimeUtils {

    public static LocalDateTime parseDateString(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return LocalDateTime.parse(dateString, formatter);
    }
}
