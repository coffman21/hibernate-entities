package com.banditos.hibernateentities.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author kkharitonov
 * @date 24.08.2018
 */
@Entity
@Table(name = "parent")
@DiscriminatorValue("Parent")
public class Parent {

    public Parent() {};

    public Parent(List<Child> children, String name) {
        this.children = children;
        this.name = name;
    }

    @NotNull
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "parent")
    private List<Child> children;

    private String name;

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
