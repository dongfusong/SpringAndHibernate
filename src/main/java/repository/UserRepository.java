package repository;

import com.huipay.oms.entity.CheckCode;
import com.huipay.oms.manager.CheckCodeManager;
import model.User1;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by Thoughtworks on 15/8/27.
 */
@Component
@Transactional
public class UserRepository {
    @Autowired
    SessionFactory sessionFactory;

    public void save(User1 user1){
        sessionFactory.getCurrentSession().save(user1);
    }

    public void addCheckCode(CheckCode code){
        CheckCodeManager.getInstance().saveOrUpdate(code);
        sessionFactory.getCurrentSession().save(code);
    }
}
