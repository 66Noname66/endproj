package org.example.minionsapi.repository;

import org.example.minionsapi.model.Minion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MinionRepository extends JpaRepository<Minion, Long> {
    List<Minion> findBySkill(String skill);

    List<Minion> findByType(String type);

    List<Minion> findByCity(String city);
}