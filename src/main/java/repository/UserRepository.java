package repository;

import com.huipay.oms.entity.CheckCode;
import com.huipay.oms.manager.CheckCodeManager;
import model.User1;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
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

    public void clear() {
        sessionFactory.getCurrentSession().clear();
    }

    public User1 find(String name){
        String hqlString = "from User1 as c where c.name = :userName";
        org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hqlString);
        query.setString("userName", name);
        return (User1) query.list().get(0);
    }
}
