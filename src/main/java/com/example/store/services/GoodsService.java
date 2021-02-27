package com.example.store.services;

import com.example.store.domain.Goods;

import java.util.List;

public interface GoodsService {

    Goods getById(Long id);
    List<Goods> getAll();
    Goods addGoods(Goods goods);
    void delete(Long id);
    Goods update(Goods goods);

}
