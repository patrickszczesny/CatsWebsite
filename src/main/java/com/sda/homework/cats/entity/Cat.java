package com.sda.homework.cats.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Owner owner;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Race race;

    public Cat() {
    }
    public Cat(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public Race getRace() {
        return race;
    }
    public void setRace(Race race) {
        this.race = race;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name) &&
                Objects.equals(owner.getName(), cat.owner.getName()) &&
                Objects.equals(race.getName(), cat.race.getName());
    }

}
