package com.example.store.repositories;

import com.example.store.domain.Goods;

import java.util.List;

public interface GoodsRepository {

    Goods getById(Long id);
    List<Goods> getAll();
    void saveGoods(Goods goods);
    void delete(Long id);
    void update(Goods goods);

}
