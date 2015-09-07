import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import config.WebConfig;
import controller.HomeController;
import org.springframework.test.context.web.WebAppConfiguration;
/**
 * Created by Thoughtworks on 15/9/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class TestCodeTemplate {

    private MockMvc mockMvc;

    @Autowired
    HomeController homeController;
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown(){

    }
}
