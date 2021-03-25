package com.example.store.services.impl;

import com.example.store.domain.Goods;
import com.example.store.dtos.GoodsDto;
import com.example.store.repositories.GoodsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class GoodsServiceImpTest {

    @InjectMocks
    private GoodsServiceImpl goodsService;

    @Mock
    private GoodsRepository goodsRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getById(){
        Long existedId = 12L;
        String name = "bread";
        Double cost = 21.4;
        String manufacturer = "Klass";
        Instant dateOfManufacture = Instant.now();

        when(goodsRepository.getById(existedId))
                .thenReturn(Optional.of(Goods.builder()
                        .id(existedId)
                        .name(name)
                        .cost(cost)
                        .manufacturer(manufacturer)
                        .dateOfManufacture(dateOfManufacture)
                .build()));

        GoodsDto goodsDto = goodsService.getById(existedId);

        assertNotNull(goodsDto);
        assertEquals(existedId, goodsDto.getId());
        assertEquals(name, goodsDto.getName());
        assertEquals(cost, goodsDto.getCost());
        assertEquals(manufacturer, goodsDto.getManufacturer());
        assertEquals(dateOfManufacture, goodsDto.getDateOfManufacture());
        verify(goodsRepository).getById(existedId);
    }

    @Test
    void delete(){
        Long existedId = 12L;

        when(goodsRepository.getById(existedId))
                .thenReturn(Optional.of(new Goods()));

        goodsRepository.delete(existedId);

        verify(goodsRepository).delete(existedId);
    }
}
