package com.example.store.repositories;

import com.example.store.domain.Store;

import java.util.List;

public interface StoreRepository {

    Store getById(Long id);
    List<Store> getAll();
    Store addStore(Store store);
    void delete(Long id);
    Store update(Store store);

}
