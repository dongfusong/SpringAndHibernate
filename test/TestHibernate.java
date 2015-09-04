import config.HibernateConfig;
import config.WebConfig;
import model.Tool;
import model.ToolUser;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.annotation.Configuration;
import repository.ToolUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Thoughtworks on 15/8/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {HibernateConfig.class, WebConfig.class})
@Configuration
public class TestHibernate {
    @Autowired
    private ToolUserRepository userRepository;


    @Before
    public void setUp(){
        userRepository.clear();
    }

    @After
    public void tearDown(){

    }

//
//    @Test
//    public void testNew(){
//        ToolUser user1 = new ToolUser("dongfusong");
//        userRepository.save(user1);
//    }
//
//    @Test
//    public void testCore(){
//        userRepository.addCheckCode(new CheckCode());
//    }
//
//    @Test
//    @Transactional
//    public void testCoreInTest(){
//        addCheckCode();
//    }
//
//    public void addCheckCode(){
//        CheckCodeManager.getInstance().saveOrUpdate(new CheckCode());
//    }


    @Test
    public void testFind(){
        userRepository.save(new ToolUser("dongfusong"));
        userRepository.save(new ToolUser("dongfupeng"));
        userRepository.save(new ToolUser("dongfuxx"));
        ToolUser user = userRepository.find("dongfusong");
        System.out.println(user.toString());
        ToolUser user1 = userRepository.getByName("dongfusong");
        user1.setName("dongfusong oh yes");
        System.out.println(user1.toString());

        userRepository.getAllUsers();
    }


    @Test
    public void testAddUser(){
        ToolUser user = new ToolUser();
        user.addTool(new Tool("dfs"));
        user.addTool(new Tool("dfp"));
        user.addTool(new Tool("dfc"));
        userRepository.save(user);
        userRepository.clear();
    }

}

