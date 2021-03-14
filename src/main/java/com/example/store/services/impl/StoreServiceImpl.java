package com.example.store.services.impl;

import com.example.store.domain.Goods;
import com.example.store.domain.Store;
import com.example.store.dtos.GoodsDto;
import com.example.store.dtos.StoreDto;
import com.example.store.exceptions.ApplicationException;
import com.example.store.exceptions.ResourceNotFoundException;
import com.example.store.repositories.GoodsRepository;
import com.example.store.repositories.StoreRepository;
import com.example.store.services.StoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.store.dtos.GoodsDto.convertToDomain;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final GoodsRepository goodsRepository;

    public StoreServiceImpl(StoreRepository storeRepository, GoodsRepository goodsRepository) {
        this.storeRepository = storeRepository;
        this.goodsRepository = goodsRepository;
    }

    @Override
    public StoreDto create(StoreDto storeDto) {
        Store store = StoreDto.convertToDomain(storeDto);
        List<Goods> goodsList = storeDto.getGoodsDtoList()
                .stream()
                .map(goodsDto -> {
                    Goods goods = convertToDomain(goodsDto);
                    goodsRepository.create(goods, store.getId());
                    return goods;
                }).collect(Collectors.toList());
        store.setGoodsList(goodsList);
        storeRepository.create(store);

        StoreDto convertStoreDto = StoreDto.convertToDto(store);
        convertStoreDto.setGoodsDtoList(store.getGoodsList()
                .stream()
                .map(goods -> GoodsDto.convertToDto(goods))
                .collect(Collectors.toList()));

        return convertStoreDto;

    }

    @Override
    public StoreDto getById(Long id) {
        return storeRepository.getById(id)
                .map(store -> new StoreDto(store, goodsRepository.getAllByStoreId(id)))
                .orElseThrow(() -> new ResourceNotFoundException("Store with id " + id + " is not found"));
    }

    @Override
    public List<StoreDto> getAll() {
        List<Store> storeList = storeRepository.getAll();
        if(CollectionUtils.isEmpty(storeList)){
            return Collections.emptyList();
        }
        return storeList.stream()
                .map(store -> StoreDto.convertToDto(store))
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {
        goodsRepository.deleteAllByStoreId(id);
        storeRepository.delete(id);
    }

    @Override
    public StoreDto update(StoreDto storeDto) {
        Store store = storeRepository.update(StoreDto.convertToDomain(storeDto))
                .orElseThrow(() -> new ApplicationException("Failed to update store store " + storeDto));
        return StoreDto.convertToDto(store);
    }
}
