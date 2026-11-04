package com.pharmatech.inventory.model;

import java.time.LocalDate;

public final class Batch {
    private final Medicine medicine;
    private final String batchNumber;
    private int quantityOnHand;
    private final LocalDate expiryDate;

    public Batch(Medicine medicine, String batchNumber, int quantityOnHand, LocalDate expiryDate) {
        if (medicine == null) {
            throw new IllegalArgumentException("Medicine is required.");
        }
        if (batchNumber == null || batchNumber.isBlank()) {
            throw new IllegalArgumentException("Batch number cannot be blank.");
        }
        if (expiryDate == null) {
            throw new IllegalArgumentException("Expiry date is required.");
        }

        this.medicine = medicine;
        this.batchNumber = batchNumber.trim();
        this.expiryDate = expiryDate;
        updateQuantityOnHand(quantityOnHand);
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void updateQuantityOnHand(int quantityOnHand) {
        if (quantityOnHand < 0) {
            throw new IllegalArgumentException("Quantity on hand cannot be negative.");
        }
        this.quantityOnHand = quantityOnHand;
    }
}
