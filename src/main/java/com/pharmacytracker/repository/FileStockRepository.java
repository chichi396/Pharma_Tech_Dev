package com.pharmacytracker.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pharmacytracker.model.Batch;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileStockRepository implements StockRepository {
    private static final Type BATCH_LIST_TYPE = new TypeToken<List<Batch>>() {}.getType();
    private final Path file;
    private final Gson gson = new Gson();

    public FileStockRepository(Path file) {
        this.file = file;
    }

    @Override
    public synchronized List<Batch> findAll() {
        if (!Files.exists(file)) return new ArrayList<>();
        try {
            List<Batch> batches = gson.fromJson(Files.readString(file), BATCH_LIST_TYPE);
            return batches == null ? new ArrayList<>() : new ArrayList<>(batches);
        } catch (IOException | RuntimeException exception) {
            throw new IllegalStateException("Could not read saved batches from " + file, exception);
        }
    }

    @Override
    public synchronized void saveAll(List<Batch> batches) {
        try {
            Path parent = file.getParent();
            if (parent != null) Files.createDirectories(parent);
            Files.writeString(file, gson.toJson(batches));
        } catch (IOException exception) {
            throw new IllegalStateException("Could not save batches to " + file, exception);
        }
    }
}
