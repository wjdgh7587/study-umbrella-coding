import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

@Slf4j
public class TimeFormatTest {

    @Test
    @DisplayName("타임 포멧 테스트1")
    void timeFormatTest(){

        long minute = 20;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        log.info(LocalDateTime.now().minusMinutes(minute).format(formatter));

    }

    @Test
    @DisplayName("타임 포멧 테스트2")
    void timeFormat(){

        String timeA = "20221212000000";

        // Formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime localA = LocalDateTime.parse(timeA, formatter);

        log.info("-- 월말 테스트 --");
        log.info(String.valueOf(localA.getMonth().maxLength()));

    }

}
