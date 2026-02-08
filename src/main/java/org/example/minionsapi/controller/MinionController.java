package org.example.minionsapi.controller;

import org.example.minionsapi.dto.MinionRequest;
import org.example.minionsapi.model.Minion;
import org.example.minionsapi.service.MinionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minions")
@CrossOrigin(origins = "*")
public class MinionController {

    private final MinionService service;

    public MinionController(MinionService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Minion create(@RequestBody MinionRequest dto) {
        return service.create(dto);
    }

    // GET + FILTERS
    @GetMapping
    public List<Minion> getAll(
            @RequestParam(required = false) String skill,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String city
    ) {
        if (skill != null) {
            return service.getBySkill(skill);
        }
        if (type != null) {
            return service.getByType(type);
        }
        if (city != null) {
            return service.getByCity(city);
        }
        return service.getAll();
    }
}
