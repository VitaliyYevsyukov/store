package com.example.store.repositories;

import com.example.store.domain.Goods;

import java.util.List;

public interface GoodsRepository {

    Goods getById(Long id);
    List<Goods> getAll();
    Goods saveGoods(Goods goods);
    void delete(Long id);
    Goods update(Goods goods);

}
