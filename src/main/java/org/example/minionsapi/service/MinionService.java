package org.example.minionsapi.service;

import org.example.minionsapi.dto.MinionRequest;
import org.example.minionsapi.model.Minion;
import org.example.minionsapi.patterns.MinionBuilder;
import org.example.minionsapi.patterns.MinionFactory;
import org.example.minionsapi.repository.MinionRepository;
import org.example.minionsapi.utils.TypeValidator;
import org.example.minionsapi.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinionService {

    private final MinionRepository repository;
    private final CacheManager cacheManager;

    private static final String ALL_MINIONS_KEY = "all_minions";

    public MinionService(MinionRepository repository) {
        this.repository = repository;
        this.cacheManager = CacheManager.getInstance();
    }

    // CREATE
    public Minion create(MinionRequest dto) {
        TypeValidator.validate(dto.getType());

        Minion minion = MinionFactory.create(dto);

        Minion saved = repository.save(
                new MinionBuilder(minion)
                        .name(dto.getName())
                        .age(dto.getAge())
                        .city(dto.getCity())
                        .skill(dto.getSkill())
                        .build()
        );

        cacheManager.remove(ALL_MINIONS_KEY);
        return saved;
    }

    // READ
    public List<Minion> getAll() {

        if (cacheManager.contains(ALL_MINIONS_KEY)) {
            System.out.println("Returning from CACHE");
            return cacheManager.get(ALL_MINIONS_KEY);
        }

        System.out.println("Fetching from DATABASE");
        List<Minion> minions = repository.findAll();

        cacheManager.put(ALL_MINIONS_KEY, minions);
        return minions;
    }

    // UPDATE
    public Minion update(Long id, MinionRequest dto) {

        Minion existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Minion not found"));

        existing.setName(dto.getName());
        existing.setAge(dto.getAge());
        existing.setCity(dto.getCity());
        existing.setSkill(dto.getSkill());

        Minion updated = repository.save(existing);

        cacheManager.remove(ALL_MINIONS_KEY);

        return updated;
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
        cacheManager.remove(ALL_MINIONS_KEY);
    }

    public void clearCache() {
        cacheManager.clear();
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
