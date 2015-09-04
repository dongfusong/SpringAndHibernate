package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thoughtworks on 15/9/3.
 */

@Entity
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private String name;

    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL)
    List<Edge> edges = new ArrayList<Edge>();

    public void addEdge(Edge edge){
        edges.add(edge);
    }

    public int edgeCnt(){
        return edges.size();
    }

    public String getName() {
        return name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", edges=" + edges +
                '}';
    }
}
