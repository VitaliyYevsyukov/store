package com.example.store.listeners;

import com.example.store.domain.Goods;
import com.example.store.domain.Store;
import com.example.store.dtos.StoreDto;
import com.example.store.repositories.GoodsRepository;
import com.example.store.repositories.StoreRepository;
import com.example.store.services.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class ApplicationReadyListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyListener.class);
    //private final StoreRepository storeRepository;
    //private final GoodsRepository goodsRepository;
    private final StoreService storeService;

    public ApplicationReadyListener(StoreService storeService){
        this.storeService = storeService;
    }
    /*public ApplicationReadyListener(StoreRepository storeRepository, GoodsRepository goodsRepository) {
        this.storeRepository = storeRepository;
        this.goodsRepository = goodsRepository;
    }*/

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReadyHandler(){

        //storeService.create(new StoreDto(new Store("Posad", "+380984567534", "grocery", 34, false)));

        StoreDto storeDto = storeService.getById(21L);

        storeService.delete(17l);

        /*Store store = storeRepository.getById(17L).get();
        //storeRepository.create(new Store("Posad", "+380984567534", "grocery", 5, false));  // uncomment
        //storeRepository.delete(19L);      // uncomment
        //store.setCashboxCount(7);
        //storeRepository.update(store);
        List<Store> storeList = storeRepository.getAll();
        Set<String> storeSet = storeRepository.getNames();
        LOGGER.info("Store = {}", store);
        LOGGER.info("All stores {}", storeList);
        LOGGER.info("All stores names {}", storeSet);

        Goods goods = goodsRepository.getById(3L).get();
        goodsRepository.create(new Goods("jalousie", 450.3, "Bella Vita", null), store.getId());
        //goodsRepository.delete(24L);
        //goods.setCost(32.75);
        //goodsRepository.update(goods);
        List<Goods> goodsList = goodsRepository.getAll();
        Set<String> goodsSet = goodsRepository.getNames();
        LOGGER.info("Goods = {}", goods);
        LOGGER.info("All goods {}", goodsList);
        LOGGER.info("All goods names {}", goodsSet);*/
    }

}
