package com.example.store.services;

import com.example.store.dtos.GoodsDto;

import java.util.List;

public interface GoodsService {

    GoodsDto getById(Long id);
    List<GoodsDto> getAll();
    GoodsDto create(GoodsDto goodsDto, Long storeId);
    void delete(Long id);
    GoodsDto update(GoodsDto goodsDto, Long id);

}
