package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thoughtworks on 15/8/27.
 */

@Entity
public class ToolUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    List<Tool> arrayList = new ArrayList<Tool>();

    public void addTool(Tool tool){
        arrayList.add(tool);
    }

    public ToolUser(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ToolUser() {
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ToolUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
