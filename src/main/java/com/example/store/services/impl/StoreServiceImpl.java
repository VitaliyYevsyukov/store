package com.example.store.services.impl;

import com.example.store.domain.Goods;
import com.example.store.domain.Store;
import com.example.store.dtos.GoodsDto;
import com.example.store.dtos.StoreDto;
import com.example.store.exceptions.ApplicationException;
import com.example.store.exceptions.ResourceNotFoundException;
import com.example.store.repositories.GoodsRepository;
import com.example.store.repositories.JpaGoodsRepository;
import com.example.store.repositories.JpaStoreRepository;
import com.example.store.repositories.StoreRepository;
import com.example.store.services.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.store.dtos.GoodsDto.convertToDomain;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final JpaStoreRepository jpaStoreRepository;
    private final JpaGoodsRepository jpaGoodsRepository;

    @Override
    public StoreDto getById(Long id) {
        return jpaStoreRepository.findById(id)
                .map(store -> new StoreDto(store))
                .orElseThrow(() -> new ResourceNotFoundException("Store with id " + id + " is not found"));
    }

    @Override
    public List<StoreDto> getAll() {
        List<Store> storeList = jpaStoreRepository.findAll();
        if(CollectionUtils.isEmpty(storeList)){
            return Collections.emptyList();
        }
        return storeList.stream()
                .map(store -> StoreDto.convertToDto(store))
                .collect(Collectors.toList());
    }

    @Override
    public StoreDto create(StoreDto storeDto) {
        Store store = jpaStoreRepository.save(StoreDto.convertToDomain(storeDto));
        return new StoreDto(store);
    }

    @Override
    public void delete(Long id) {
        jpaStoreRepository.findById(id).map(store -> {
            jpaGoodsRepository.deleteAllByStore(store);
            jpaStoreRepository.deleteById(id);
            return store;
        }).orElseThrow(() -> new ResourceNotFoundException("Store with id " + id + " is not found"));
    }

    @Override
    public StoreDto update(StoreDto storeDto, Long id) {
        Store store = jpaStoreRepository.save(StoreDto.convertToDomain(storeDto));
        return new StoreDto(store);
    }



    /*private final StoreRepository storeRepository;
    private final GoodsRepository goodsRepository;

    public StoreServiceImpl(StoreRepository storeRepository, GoodsRepository goodsRepository) {
        this.storeRepository = storeRepository;
        this.goodsRepository = goodsRepository;
    }

    @Override
    public StoreDto update(StoreDto storeDto, Long id) {
        Store store = storeRepository.update(StoreDto.convertToDomain(storeDto), id)
                .orElseThrow(() -> new ApplicationException("Failed to update store " + storeDto));
        return StoreDto.convertToDto(store);
    }

    @Override
    public StoreDto create(StoreDto storeDto) {
        Store store = StoreDto.convertToDomain(storeDto);
        Store createdStore = storeRepository.create(store)
                .orElseThrow(() -> new ApplicationException("Failed to create store"));
        List<Goods> createdGoodsList = goodsRepository.create(storeDto.getGoodsDtoList()
                .stream().map(GoodsDto::convertToDomain)
                .collect(Collectors.toList()), createdStore.getId());
        return new StoreDto(createdStore, createdGoodsList);

        // EQUALS
        Store store = storeRepository.create(StoreDto.convertToDomain(storeDto))
                .orElseThrow(() -> new ResourceNotFoundException("Failed to create store " + storeDto));
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
    }*/

    /*@Override
    @SneakyThrows
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
        storeRepository.getById(id).map(store -> {
            goodsRepository.deleteAllByStoreId(id);
            storeRepository.delete(id);
            return store;
        }).orElseThrow(() -> new ResourceNotFoundException("Store with id " + id + " is not found"));
    }*/


}
