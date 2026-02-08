package org.example.minionsapi.patterns;

import org.example.minionsapi.dto.MinionRequest;
import org.example.minionsapi.model.Minion;

public class MinionFactory {

    public static Minion create(MinionRequest dto) {
        Minion minion = new Minion();
        minion.setType(dto.getType());
        return minion;
    }
}
