package com.example.store.repositories;

import com.example.store.domain.Goods;
import com.example.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaGoodsRepository extends JpaRepository<Goods, Long> {

    void deleteAllByStore(Store store);
}
