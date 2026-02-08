package org.example.minionsapi.service;


import org.example.minionsapi.dto.MinionRequest;
import org.example.minionsapi.model.Minion;
import org.example.minionsapi.patterns.MinionBuilder;
import org.example.minionsapi.patterns.MinionFactory;
import org.example.minionsapi.repository.MinionRepository;
import org.example.minionsapi.utils.TypeValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinionService {

    private final MinionRepository repository;

    public MinionService(MinionRepository repository) {
        this.repository = repository;
    }

    public Minion create(MinionRequest dto) {
        TypeValidator.validate(dto.getType());

        Minion minion = MinionFactory.create(dto);

        return repository.save(
                new MinionBuilder(minion)
                        .name(dto.getName())
                        .age(dto.getAge())
                        .city(dto.getCity())
                        .skill(dto.getSkill())
                        .build()
        );
    }

    public List<Minion> getAll() {
        return repository.findAll();
    }

    public List<Minion> getBySkill(String skill) {
        return repository.findBySkill(skill);
    }

    public List<Minion> getByType(String type) {
        return repository.findByType(type);
    }

    public List<Minion> getByCity(String city) {
        return repository.findByCity(city);
    }
}