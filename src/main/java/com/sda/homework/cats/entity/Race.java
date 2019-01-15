package com.sda.homework.cats.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany()
    private Collection<Cat> cats;

    public Race() {
    }
    public Race(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setCats(Collection<Cat> cats) {
        this.cats = cats;
    }
    public Collection<Cat> getCats() {
        return cats;
    }
}
