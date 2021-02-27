package com.example.store.services;

import com.example.store.domain.Store;

import java.util.List;

public interface StoreService {
    Store getById(Long id);
    List<Store> getAll();
    Store addStore(Store store);
    void delete(Long id);
    Store update(Store store);

}
