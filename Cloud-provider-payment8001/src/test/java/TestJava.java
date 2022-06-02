import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.sql.SQLException;
/**
 * @author binbin
 * @date 2022年06月02日  下午11:51
 */
@SpringBootTest
public class TestJava {

    @Resource
    private Environment env;
    @Test
    public void getDataSource() throws SQLException {
        System.out.println(env.getProperty("spring.datasource.url"));
    }
}
