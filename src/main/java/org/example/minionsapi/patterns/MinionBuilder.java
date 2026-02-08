package org.example.minionsapi.patterns;

import org.example.minionsapi.model.Minion;

public class MinionBuilder {

    private final Minion minion;

    public MinionBuilder(Minion minion) {
        this.minion = minion;
    }

    public MinionBuilder name(String name) {
        minion.setName(name);
        return this;
    }

    public MinionBuilder age(int age) {
        minion.setAge(age);
        return this;
    }

    public MinionBuilder city(String city) {
        minion.setCity(city);
        return this;
    }

    public MinionBuilder skill(String skill) {
        minion.setSkill(skill);
        return this;
    }

    public Minion build() {
        return minion;
    }
}
