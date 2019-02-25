package com.banditos.hibernateentities.model;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

/**
 * @author kkharitonov
 * @date 24.08.2018
 */
@Entity
@Table(name = "parent")
@DiscriminatorValue("Parent")
public class Parent {

    public Parent() {};

    public Parent(Set<Child> children, String name) {
        this.children = children;
        this.name = name;
    }

    @NotNull
    @Id
    @GeneratedValue
    private long id;

//    @RestResource(exported=false)
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Child> children;

    private String name;

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
