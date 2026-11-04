package com.pharmatech.inventory.model;

import java.util.Objects;

public final class Medicine {
    private final String code;
    private final String name;

    public Medicine(String code, String name) {
        this.code = requireText(code, "Medicine code").toUpperCase();
        this.name = requireText(name, "Medicine name");
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be blank.");
        }
        return value.trim();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Medicine medicine)) {
            return false;
        }
        return code.equals(medicine.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
