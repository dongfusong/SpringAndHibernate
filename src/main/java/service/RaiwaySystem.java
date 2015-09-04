package service;

import model.Edge;
import model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.NodeRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Thoughtworks on 15/9/3
 */
@Service
@Transactional
public class RaiwaySystem {

    @Autowired
    NodeRepository nodeRepository;

    public void addPath(String srcName, String dstName, int distance){
        Node src = nodeRepository.GetOrCreate(srcName);
        Node dst = nodeRepository.GetOrCreate(dstName);
        src.addEdge(new Edge(dst, distance));
    }

    public int getEdgeCnt(String name){
        Node node = nodeRepository.findNodeByName(name);
        return node.edgeCnt();
    }


    public void addNode(String name){
        nodeRepository.createNode(name);
    }

    public void clearAll() {
        nodeRepository.deleteAll();
    }

    public String getAllNodesToJson(int pageNo, int cnt) {
        List<Node> nodeList = nodeRepository.findAll(pageNo, cnt);
        return com.alibaba.fastjson.JSONArray.toJSONString(nodeList);
    }
}
