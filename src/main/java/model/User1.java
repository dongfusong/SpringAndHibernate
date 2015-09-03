package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Thoughtworks on 15/8/27.
 */

@Entity
public class User1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;

    public User1(String name) {
        this.name = name;
    }

    public User1() {
    }

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
