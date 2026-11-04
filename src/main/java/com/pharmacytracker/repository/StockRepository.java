package com.pharmacytracker.repository;

import com.pharmacytracker.model.Batch;
import java.util.List;

public interface StockRepository {
    List<Batch> findAll();
    void saveAll(List<Batch> batches);
}
