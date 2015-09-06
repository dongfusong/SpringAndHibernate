import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import config.WebConfig;
import controller.HomeController;
import model.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by Thoughtworks on 15/9/6.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class TestControllerDemo {

    private MockMvc mockMvc;

    @Autowired
    HomeController homeController;
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testParamFetch() throws Exception {

        String requestUrl = "/home";
        JSONObject childObj = new JSONObject();
        childObj.put("street", "anshanlu");
        childObj.put("zipCode", "12345");

        JSONObject object = new JSONObject();
        object.put("name", "dongfusong");
        object.put("address", childObj);
        System.out.println("======"+object.toJSONString());
        
        mockMvc.perform(post(requestUrl).content(object.toJSONString())
                .contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }
}
