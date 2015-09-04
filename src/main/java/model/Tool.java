package model;

import javax.persistence.*;

/**
 * Created by Thoughtworks on 15/9/3.
 */
@Entity
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    ToolUser owner;

    public Tool() {

    }

    public Tool(String name) {
        this.name = name;
    }
}
