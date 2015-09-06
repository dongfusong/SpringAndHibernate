package repository;

import com.iit.common.hibernate3.HibernateBaseDao;
import model.Node;
import model.Tool;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Thoughtworks on 15/9/5.
 */
@Transactional
@Repository
public class ToolRepository extends HibernateBaseDao<Tool,Integer> {

    public void save(Tool tool){
        getCurrentSession().save(tool);
    }

    @Override
    protected Class<Tool> getEntityClass() {
        return Tool.class;
    }
}
