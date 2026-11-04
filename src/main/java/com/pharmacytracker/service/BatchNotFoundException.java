package com.pharmacytracker.service;

public class BatchNotFoundException extends RuntimeException {
    public BatchNotFoundException(String id) {
        super("No batch was found with ID " + id + ".");
    }
}
