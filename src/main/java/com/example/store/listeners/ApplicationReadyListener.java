package com.example.store.listeners;

import com.example.store.domain.Goods;
import com.example.store.domain.Store;
import com.example.store.repositories.GoodsRepository;
import com.example.store.repositories.StoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class ApplicationReadyListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyListener.class);
    private final StoreRepository storeRepository;
    private final GoodsRepository goodsRepository;

    public ApplicationReadyListener(StoreRepository storeRepository, GoodsRepository goodsRepository) {
        this.storeRepository = storeRepository;
        this.goodsRepository = goodsRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReadyHandler(){
        Store store = storeRepository.getById(17L);
        //storeRepository.saveStore(new Store("Posad", "+380984567534", "grocery", 5, false));  // uncomment
        storeRepository.delete(18L);      // uncomment
        store.setCashboxCount(7);
        storeRepository.update(store);
        List<Store> storeList = storeRepository.getAll();
        LOGGER.info("Store = {}", store);
        LOGGER.info("All stores {}", storeList);

        Goods goods = goodsRepository.getById(3L);
        //goodsRepository.saveGoods(new Goods("jalousie", 450.3, "Bella Vita", null));
        //goodsRepository.delete(24L);
        goods.setCost(32.75);
        goodsRepository.update(goods);
        List<Goods> goodsList = goodsRepository.getAll();
        LOGGER.info("Goods = {}", goods);
        LOGGER.info("All goods {}", goodsList);
    }

}
