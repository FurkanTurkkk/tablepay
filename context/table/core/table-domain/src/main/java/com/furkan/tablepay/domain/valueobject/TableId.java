package com.furkan.tablepay.domain.valueobject;

import com.furkan.tablepay.domain.exception.InvalidTableIdException;

import java.util.Objects;
import java.util.UUID;

public final class TableId {

    private final String value;

    private TableId(String value) {
        this.value = value;
    }

    public static TableId random() {
        return new TableId(UUID.randomUUID().toString());
    }

    public static TableId of(String value) {
        validate(value);
        return new TableId(value);
    }

    private static void validate(String value) {
        if(value == null) {
            throw new InvalidTableIdException("Table Id can not be null");
        }
        if(value.isEmpty()) {
            throw new InvalidTableIdException("Table Id can not be empty");
        }
    }

    public String asString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TableId tableId = (TableId) o;
        return Objects.equals(value, tableId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
