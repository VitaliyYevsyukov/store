package com.example.store.repositories;

import com.example.store.domain.Goods;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GoodsRepository {

    Optional<Goods> getById(Long id);
    List<Goods> getAll();
    Optional<Goods> createGoods(Goods goods);
    void delete(Long id);
    Optional<Goods> update(Goods goods);
    Set<String> getNames();

}
