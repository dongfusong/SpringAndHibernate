package repository;

import com.huipay.oms.entity.CheckCode;
import com.huipay.oms.manager.CheckCodeManager;
import com.iit.common.hibernate3.HibernateBaseDao;
import model.ToolUser;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Thoughtworks on 15/8/27.
 */
@Component
@Transactional
public class ToolUserRepository extends HibernateBaseDao<ToolUser, Integer>{
//    @Autowired
//    SessionFactory sessionFactory;

    public void save(ToolUser user1){
        session().save(user1);
    }

    @Override
    protected Class<ToolUser> getEntityClass() {
        return ToolUser.class;
    }

    public void addCheckCode(CheckCode code){
        CheckCodeManager.getInstance().saveOrUpdate(code);
        session().save(code);
    }

    private Session session() {
        return getCurrentSession();
    }


    public void clear() {
        session().createQuery("delete from ToolUser").executeUpdate();
    }

    public ToolUser find(String name){
        String hqlString = "from ToolUser c where c.name = :userName";
        org.hibernate.Query query = session().createQuery(hqlString);
        query.setString("userName", name);
        System.out.println(query.getQueryString());
        return (ToolUser) query.list().get(0);
    }

    public ToolUser getByName(String name) {
        ToolUser user = find(name);
        return get(user.getId());
    }

    public void getAllUsers(){
        List<ToolUser> userList = getAll(ToolUser.class);
        for (ToolUser userItem : userList){
            System.out.println(userItem.toString());
        }
    }
}
