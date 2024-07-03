package com.backend.pizzaria.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EdgesTypes {
    FRANGO,
    FRANGO_CATUPIRY,
    CHEDDAR,
    CHOCOLATE,
    DOCE_DE_LEITE,
    LEITE_NINHO,
    SEM_BORDA;

    @JsonCreator
    public static EdgesTypes fromString(String value) {
        for (EdgesTypes edge : EdgesTypes.values()) {
            if (edge.name().equalsIgnoreCase(value)) {
                return edge;
            }
        }
        throw new IllegalArgumentException("Invalid edge type: " + value);
    }

    @JsonValue
    public String getValue() {
        return name();
    }
}
