package org.example.minionsapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "minions")
public class Minion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String city;
    private String skill;
    private String type;

    // ОБЯЗАТЕЛЬНО public
    public Minion() {}

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setType(String type) {
        this.type = type;
    }

    // getters (нужны для JSON)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getSkill() {
        return skill;
    }

    public String getType() {
        return type;
    }
}
