package com.example.store.repositories;

import com.example.store.domain.Store;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface StoreRepository {

    Optional<Store> getById(Long id);
    List<Store> getAll();
    Optional<Store> create(Store store);
    void delete(Long id);
    Optional<Store> update(Store store, Long id);
    Set<String> getNames();
}
