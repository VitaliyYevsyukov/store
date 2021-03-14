package com.example.store.services;

import com.example.store.domain.Goods;
import com.example.store.dtos.GoodsDto;

import java.util.List;

public interface GoodsService {

    GoodsDto getById(Long id);
    List<GoodsDto> getAll();
    GoodsDto addGoods(GoodsDto goodsDto, Long id);
    void delete(Long id);
    GoodsDto update(GoodsDto goodsDto);

}
