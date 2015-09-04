import com.alibaba.fastjson.JSON;
import config.HibernateConfig;
import config.WebConfig;
import model.Node;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import service.RaiwaySystem;

import static org.junit.Assert.assertEquals;

/**
 * Created by Thoughtworks on 15/9/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {HibernateConfig.class, WebConfig.class})
@Configuration
public class TestRailwaySystem {

    @Autowired
    RaiwaySystem railwaySystem;


    @Before
    public void setUp(){
        railwaySystem.clearAll();
    }


    @Test
    public void testAddPath(){
        railwaySystem.addPath("A", "B", 30);
        railwaySystem.addPath("B", "C", 40);
        railwaySystem.addPath("C", "D", 20);
        railwaySystem.addPath("C", "F", 20);

        assertEquals(2, railwaySystem.getEdgeCnt("C"));
    }


    void insertNode(int cnt){
        for (int i = 0; i < cnt; i++){
            railwaySystem.addNode(new String(i + "_node"));
        }
    }
    @Test
    public void testPage(){
        insertNode(100);
        int cnt = 10;
        int pageNo = 2;
        String result = railwaySystem.getAllNodesToJson(pageNo, cnt);
        System.out.print(result);
    }
    @Test
    public void testJson(){
        Node node = new Node("dfs");
        System.out.println(JSON.toJSONString(node));
    }

}
