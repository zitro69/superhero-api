package com.jortizc.superheroapi.model;

import javax.persistence.*;

@Entity
@Table(name = "superhero")
public class Superhero {
    private @Id @GeneratedValue Long id;

    @Column(name = "name")
    private String name;

    public Superhero() {
    }

    public Superhero(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
