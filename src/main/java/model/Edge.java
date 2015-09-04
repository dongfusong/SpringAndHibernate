package model;

import javax.persistence.*;

/**
 * Created by Thoughtworks on 15/9/3.
 */
@Entity
public class Edge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne
    @JoinColumn(name = "next_node")
    private Node nextNode;
    int distance;

    public Edge() {
    }

    public Edge(Node dst, int distance) {
        this.nextNode = dst;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "id=" + id +
                ", nextNode=" + nextNode +
                ", distance=" + distance +
                '}';
    }
}
