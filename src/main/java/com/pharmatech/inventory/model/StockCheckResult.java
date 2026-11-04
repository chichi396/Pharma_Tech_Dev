package com.pharmatech.inventory.model;

public final class StockCheckResult {
    private final Medicine medicine;
    private final int requestedQuantity;
    private final int availableQuantity;

    public StockCheckResult(Medicine medicine, int requestedQuantity, int availableQuantity) {
        if (medicine == null) {
            throw new IllegalArgumentException("Medicine is required.");
        }
        if (requestedQuantity <= 0) {
            throw new IllegalArgumentException("Requested quantity must be greater than zero.");
        }
        if (availableQuantity < 0) {
            throw new IllegalArgumentException("Available quantity cannot be negative.");
        }

        this.medicine = medicine;
        this.requestedQuantity = requestedQuantity;
        this.availableQuantity = availableQuantity;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public boolean isSufficient() {
        return availableQuantity >= requestedQuantity;
    }

    public int getShortfall() {
        return Math.max(0, requestedQuantity - availableQuantity);
    }
}
