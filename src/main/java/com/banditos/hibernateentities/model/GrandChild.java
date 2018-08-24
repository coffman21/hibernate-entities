package com.banditos.hibernateentities.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author kkharitonov
 * @date 24.08.2018
 */
@Entity
@Table(name = "grand_child")
@DiscriminatorValue("GrandChild")
public class GrandChild {

    public GrandChild() {};

    public GrandChild(Child child, String name) {
        this.child = child;
        this.name = name;
    }

    @NotNull
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Child child;

    private String name;

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
