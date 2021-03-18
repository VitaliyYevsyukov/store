package com.example.store.services;

import com.example.store.dtos.StoreDto;

import java.util.List;

public interface StoreService {

    StoreDto getById(Long id);
    List<StoreDto> getAll();
    StoreDto create(StoreDto storeDto);
    void delete(Long id);
    StoreDto update(StoreDto storeDto, Long id);

}
