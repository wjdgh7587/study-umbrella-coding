package utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@SpringBootTest(classes = DateFormatUtilsTest.class)
@Slf4j
public class DateFormatUtilsTest {

    @Test
    @DisplayName("특정 Date Format의 파싱 테스트")
    @Description("Test 여부 - [O]")
    void testExecute(){

        String timeA = "Fri Aug 05 18:39:17 KST 2022";
        String format = "yyyyMMddHHmmss";

        String targetDate = timeA.replace("KST", "GMT+09:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(targetDate,
                DateTimeFormatter.ofPattern("EEE MMM d H:m:s ZZZZ u", Locale.ENGLISH));
        System.out.println(offsetDateTime);

        // Parsing format
        String targetParsingResult = offsetDateTime.format(DateTimeFormatter.ofPattern(format, Locale.ENGLISH));
        log.info("[Target Format Change Result] : {}", targetParsingResult);
    }

    @Test
    @DisplayName("현재 시간의 날짜를 원하는 타입으로 추출")
    @Description("Test 여부 - [O]")
    void getDateString(){

        // Parameter 로서 String format 받아서 설정

        String pattern = "yyyyMMddHHmmss";
        String pattern2 = "yyyy-MM-dd";
        String pattern3 = "yyyy-MM-dd HH:mm:ss";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.now();

        String result = localDateTime.format(dateTimeFormatter);
        log.info("[DateTime.now() with pattern Result] : {}", result);
    }
}
