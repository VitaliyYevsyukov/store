package com.example.store.services.impl;

import com.example.store.domain.Goods;
import com.example.store.dtos.GoodsDto;
import com.example.store.exceptions.ApplicationException;
import com.example.store.repositories.GoodsRepository;
import com.example.store.repositories.StoreRepository;
import com.example.store.services.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    private final StoreRepository storeRepository;
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
    public GoodsDto addGoods(GoodsDto goodsDto, Long id) {
        return goodsRepository.create(GoodsDto.convertToDomain(goodsDto), id)
                .map(goods -> new GoodsDto(goods))
                .orElseThrow(() -> new ApplicationException("Failed to add goods + " + goodsDto));
    }

    @Override
    public void delete(Long id) {
        goodsRepository.delete(id);
    }

    @Override
    public GoodsDto update(GoodsDto goodsDto) {
        Goods goods = goodsRepository.update(GoodsDto.convertToDomain(goodsDto))
                .orElseThrow(() -> new ApplicationException("Failed to update goods: " + goodsDto));
        return GoodsDto.convertToDto(goods);
    }
}
