import model.AppConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Thoughtworks on 15/9/5.
 */
public class TestConfig {
    private AppConfiguration appConfiguration;

    @Before
    public void setUp(){
        appConfiguration = new AppConfiguration();
    }
    @Test
    public void test(){
        appConfiguration.init();
    }
}
