package com.banditos.hibernateentities.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author kkharitonov
 * @date 24.08.2018
 */
@Entity
@Table(name = "child")
@DiscriminatorValue("Child")
public class Child {

    public Child() {};

    public Child(Set<GrandChild> grandChildren, Parent parent, String name) {
        this.grandChildren = grandChildren;
        this.parent = parent;
        this.name = name;
    }

    @NotNull
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<GrandChild> grandChildren;

    @ManyToOne(fetch = FetchType.LAZY)
    private Parent parent;

    private String name;

    public Child(Parent parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public Set<GrandChild> getGrandChildren() {
        return grandChildren;
    }

    public void setGrandChildren(Set<GrandChild> grandChildren) {
        this.grandChildren = grandChildren;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
