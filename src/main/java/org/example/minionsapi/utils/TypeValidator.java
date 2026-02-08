package org.example.minionsapi.utils;

public class TypeValidator {

    public static void validate(String type) {
        if (!type.equals("WARRIOR")
                && !type.equals("SCOUT")
                && !type.equals("MAGE")) {
            throw new IllegalArgumentException("Invalid minion type: " + type);
        }
    }
}