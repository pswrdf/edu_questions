package romanianNumbers;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FromArabianTest {
    Map<Integer, String> thousand;

    @BeforeEach
    void before() throws IOException {
        List<String> table = IOUtils.readLines(FromArabianTest.class.getResourceAsStream("table"),
                Charset.defaultCharset());
        thousand = table.stream().collect(Collectors.toMap(s -> Integer.valueOf(s.split(";")[0]),
                s -> s.split(";")[1]));
    }

    @Test
    void test() {
        assertEquals("I", FromArabian.toLatin(1));

        thousand.entrySet().stream().forEach(e->
            assertEquals(e.getValue(), FromArabian.toLatin(e.getKey()))
        );
    }
}

