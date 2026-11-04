package com.pharmacytracker.repository;

import com.pharmacytracker.model.Batch;
import java.util.ArrayList;
import java.util.List;

public class InMemoryStockRepository implements StockRepository {
    private final List<Batch> batches = new ArrayList<>();

    @Override
    public synchronized List<Batch> findAll() {
        return new ArrayList<>(batches);
    }

    @Override
    public synchronized void saveAll(List<Batch> newBatches) {
        batches.clear();
        batches.addAll(newBatches);
    }
}
