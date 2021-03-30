package com.example.store.services.impl;

import com.example.store.domain.Goods;
import com.example.store.domain.Store;
import com.example.store.dtos.GoodsDto;
import com.example.store.exceptions.ApplicationException;
import com.example.store.exceptions.ResourceNotFoundException;
import com.example.store.repositories.GoodsRepository;
import com.example.store.repositories.JpaGoodsRepository;
import com.example.store.repositories.JpaStoreRepository;
import com.example.store.repositories.StoreRepository;
import com.example.store.services.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final JpaStoreRepository jpaStoreRepository;
    private final JpaGoodsRepository jpaGoodsRepository;

    @Override
    public GoodsDto getById(Long id) {
        return jpaGoodsRepository.findById(id)
                .map(goods -> new GoodsDto(goods))
                .orElseThrow(() -> new ApplicationException("Failed to get goods by id " + id));
    }

    @Override
    public List<GoodsDto> getAll() {
        List<Goods> goodsList = jpaGoodsRepository.findAll();
        if(CollectionUtils.isEmpty(goodsList)){
            return Collections.emptyList();
        }
        return goodsList.stream().map(goods -> GoodsDto.convertToDto(goods))
                .collect(Collectors.toList());
    }

    @Override
    public GoodsDto create(GoodsDto goodsDto, Long storeId) {
        Store store = jpaStoreRepository.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("Store with id " + storeId + " is not found"));
        Goods goods = GoodsDto.convertToDomain(goodsDto);
        return GoodsDto.convertToDto(jpaGoodsRepository.save(goods));
    }

    @Override
    public void delete(Long id) {
        jpaGoodsRepository.deleteById(id);
    }

    @Override
    public GoodsDto update(GoodsDto goodsDto, Long storeId) {
        Goods goods = jpaGoodsRepository.save(GoodsDto.convertToDomain(goodsDto));
        return new GoodsDto(goods);
    }

    /*private final StoreRepository storeRepository;
    private final GoodsRepository goodsRepository;

    public GoodsServiceImpl(StoreRepository storeRepository, GoodsRepository goodsRepository) {
        this.storeRepository = storeRepository;
        this.goodsRepository = goodsRepository;
    }


    @Override
    public GoodsDto getById(Long id) {
        Goods goods = goodsRepository.getById(id)
                .orElseThrow(() -> new ApplicationException("Failed to get goods by id " + id));
        return GoodsDto.convertToDto(goods);
    }

    @Override
    public List<GoodsDto> getAll() {
        List<Goods> goodsList = goodsRepository.getAll();
        if(CollectionUtils.isEmpty(goodsList)){
            return Collections.emptyList();
        }
        return goodsList.stream().map(goods -> GoodsDto.convertToDto(goods))
                .collect(Collectors.toList());
    }

    @Override
    public GoodsDto create(GoodsDto goodsDto, Long storeId) {
        return goodsRepository.create(GoodsDto.convertToDomain(goodsDto), storeId)
                .map(goods -> new GoodsDto(goods))
                .orElseThrow(() -> new ApplicationException("Failed to add goods + " + goodsDto));
    }

    @Override
    public void delete(Long id) {
        goodsRepository.delete(id);
    }

    @Override
    public GoodsDto update(GoodsDto goodsDto, Long id) {
        Goods goods = goodsRepository.update(GoodsDto.convertToDomain(goodsDto), id)
                .orElseThrow(() -> new ApplicationException("Failed to update goods: " + goodsDto));
        return GoodsDto.convertToDto(goods);
    }*/
}
