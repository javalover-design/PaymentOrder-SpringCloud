import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

/**
 * @author binbin
 * @date 2022年06月27日  下午10:21
 */
@Slf4j
@SpringBootTest
public class GetTime {
    @Test
    public void getTime(){
            ZonedDateTime now = ZonedDateTime.now();
            System.out.println(now);

        }

}
