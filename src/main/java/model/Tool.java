package model;

import org.hibernate.annotations.CollectionOfElements;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Thoughtworks on 15/9/3.
 */
@Entity
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    @Embedded
    private Address homeAddress;

    ////mapping collections
    @CollectionOfElements(
            targetElement = java.lang.String.class
    )
    @JoinTable(
            name = "tool_images",
            joinColumns = @JoinColumn(name = "tool_id")
    )
    @Column(name = "image", nullable = false)
    private Set<String> images = new HashSet<String>();
    ////mapping end


    @CollectionTable(name = "tool_maybeNames", joinColumns = {@JoinColumn(name = "tool_id")})
    @ElementCollection(targetClass = String.class)
    @Column(name = "name")
    private Set<String> mabeNames = new HashSet<String>();


    public void addImage(String imageName){
        images.add(imageName);
    }

    @ManyToOne
    @JoinColumn(name = "owner_id")
    ToolUser owner;

    public Tool() {

    }

    public Tool(String name) {
        this.name = name;
    }
}
