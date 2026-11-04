package com.pharmatech.inventory.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class PrescriptionRequest {
    private final String reference;
    private final Map<Medicine, Integer> requestedQuantities;

    public PrescriptionRequest(String reference, Map<Medicine, Integer> requestedQuantities) {
        if (reference == null || reference.isBlank()) {
            throw new IllegalArgumentException("Prescription reference cannot be blank.");
        }
        if (requestedQuantities == null || requestedQuantities.isEmpty()) {
            throw new IllegalArgumentException("At least one requested medicine is required.");
        }

        Map<Medicine, Integer> copy = new LinkedHashMap<>();
        requestedQuantities.forEach((medicine, quantity) -> {
            if (medicine == null) {
                throw new IllegalArgumentException("Requested medicine is required.");
            }
            if (quantity == null || quantity <= 0) {
                throw new IllegalArgumentException("Requested quantities must be greater than zero.");
            }
            copy.put(medicine, quantity);
        });

        this.reference = reference.trim();
        this.requestedQuantities = Collections.unmodifiableMap(copy);
    }

    public String getReference() {
        return reference;
    }

    public Map<Medicine, Integer> getRequestedQuantities() {
        return requestedQuantities;
    }
}
