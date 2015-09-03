import com.huipay.oms.entity.CheckCode;
import com.huipay.oms.manager.CheckCodeManager;
import config.HibernateConfig;
import config.WebConfig;
import model.User1;
import org.junit.Before;
import org.springframework.context.annotation.Configuration;
import repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

/**
 * Created by Thoughtworks on 15/8/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {HibernateConfig.class, WebConfig.class})
@Configuration
public class TestHibernate {
    @Autowired
    private UserRepository userRepository;


    @Before
    public void setUp(){
        userRepository.clear();
    }

    @Test
    public void testNew(){
        User1 user1 = new User1("dongfusong");
        userRepository.save(user1);
    }

    @Test
    public void testCore(){
        userRepository.addCheckCode(new CheckCode());
    }

    @Test
    @Transactional
    public void testCoreInTest(){
        addCheckCode();
    }

    public void addCheckCode(){
        CheckCodeManager.getInstance().saveOrUpdate(new CheckCode());
    }


    @Test
    public void testFind(){
        userRepository.save(new User1("dongfusong"));
        userRepository.save(new User1("dongfupeng"));
        userRepository.save(new User1("dongfuxx"));
        User1 user = userRepository.find("dongfusong");
        System.out.println(user.toString());
    }
}

