package com.furkan.tablepay.domain.model;

import com.furkan.tablepay.domain.valueobject.TableId;
import com.furkan.tablepay.domain.valueobject.TableStatus;

import java.time.Instant;

public class Table {
    private TableId id;
    private TableStatus status;
    private String number;
    private int capacity;
    private Instant createdAt;
    private Instant updatedAt;

    private Table(TableId id, TableStatus status, String number, int capacity) {
        this.id = id;
        this.status = status;
        this.number = number;
        this.capacity = capacity;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public static Table create(TableId id, String number, int capacity) {
        return new Table(id, TableStatus.AVAILABLE, number, capacity);
    }

    public TableId id() { return id; }
    public TableStatus status() { return status; }
    public String number() { return number; }
    public int capacity() { return capacity; }
    public Instant createdAt() { return createdAt; }
    public Instant updatedAt() { return updatedAt; }

    public Table occupy() {
        this.status = TableStatus.OCCUPIED;
        refreshUpdatedAt();
        return this;
    }

    public Table needCleaning() {
        this.status = TableStatus.NEEDS_CLEANING;
        refreshUpdatedAt();
        return this;
    }

    private void refreshUpdatedAt() {
        this.updatedAt = Instant.now();
    }
}
