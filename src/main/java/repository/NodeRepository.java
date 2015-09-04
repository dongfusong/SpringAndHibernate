package repository;

import com.iit.common.hibernate3.HibernateBaseDao;
import model.Node;
import model.PageFinder;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Thoughtworks on 15/9/3.
 */
@Transactional
@Repository
public class NodeRepository extends HibernateBaseDao<Node,Integer>{

    void addNode(Node node){
        getCurrentSession().save(node);
    }

    @Override
    protected Class<Node> getEntityClass() {
        return Node.class;
    }

    public Node GetOrCreate(String srcName) {
        Node node = findNodeByName(srcName);
        if (node == null){
            return createNode(srcName);
        }
        return node;
    }

    private List<Node> findList(String name){
        return  getCurrentSession().createQuery("from Node as c where c.name = :nodeName").
                setString("nodeName", name).list();
    }

    public List<Node> findAll(int pageNo, int cngOfPage){
        PageFinder finder = new PageFinder("Node", pageNo, cngOfPage);
        return finder.createQuery(getCurrentSession()).list();
    }

    public List<Node> findAll(){
        return getCurrentSession().createQuery("from Node").list();
    }

    public Node findNodeByName(String name){
        List<Node> nodeList = findList(name);
        if (nodeList.isEmpty()){
            return null;
        }
        return nodeList.get(0);
    }

    public Node createNode(String name){
        Node node = new Node(name);
        save(node);
        return node;
    }

    public void deleteAll() {
        for (Node node : findAll()){
            delete(node);
        }
    }
}
