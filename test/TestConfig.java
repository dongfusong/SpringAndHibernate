import model.AppConfiguration;
import org.junit.Before;
import org.junit.Test;
import repository.ErrorInfo;

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

    @Test
    public void testEnum(){
        System.out.print("===" + ErrorInfo.request_checkcode_too_soon.getContent());
    }


}
