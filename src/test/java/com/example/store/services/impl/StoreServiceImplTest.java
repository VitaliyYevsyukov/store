package com.example.store.services.impl;

import com.example.store.domain.Store;
import com.example.store.dtos.StoreDto;
import com.example.store.exceptions.ResourceNotFoundException;
import com.example.store.repositories.GoodsRepository;
import com.example.store.repositories.StoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class StoreServiceImplTest {

    @InjectMocks
    private StoreServiceImpl storeService;

    @Mock
    private StoreRepository storeRepository;
    @Mock
    private GoodsRepository goodsRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
    }

    @Test
    void getById() {
        Long existedId = 6L;
        String storeName = "ATB";
        String phone = "+380987654321";
        String type = "grocery";
        Integer cashboxCount = 10;

        when(storeRepository.getById(existedId))
                .thenReturn(Optional.of(Store.builder()
                        .id(existedId)
                        .name(storeName)
                        .phone(phone)
                        .type(type)
                        .cashboxCount(cashboxCount)
                        .delivery(true)
                        .build()));

        StoreDto storeDto = storeService.getById(existedId);

        assertNotNull(storeDto);
        assertEquals(existedId, storeDto.getId());
        assertEquals(storeName, storeDto.getName());
        assertEquals(phone, storeDto.getPhone());
        assertEquals(type, storeDto.getType());
        assertEquals(cashboxCount, storeDto.getCashboxCount());
        assertEquals(true, storeDto.isDelivery());
        assertNotNull(storeDto.getGoodsDtoList());
        assertEquals(storeDto.getGoodsDtoList().size(), 0);
        verify(storeRepository).getById(existedId);

    }

    @Test
    void getById_notExistedStore_shouldThrowResourceNotFoundException() {
        Long existedId = 6L;

        when(storeRepository.getById(anyLong()))
                .thenReturn(Optional.empty());

        ResourceNotFoundException resourceNotFoundException =
                assertThrows(ResourceNotFoundException.class, () -> storeService.getById(existedId));
        assertEquals("Store with id " + existedId + " is not found", resourceNotFoundException.getMessage());

    }

    @Test
    void getAll() {
    }

    @Test
    void delete() {
        Long existedId = 4L;

        when(storeRepository.getById(existedId))
                .thenReturn(Optional.of(new Store()));

        storeRepository.delete(existedId);

        verify(storeRepository).delete(existedId);
        verify(goodsRepository).deleteAllByStoreId(existedId);

    }

    @Test
    void delete_notExistedStore_shouldThrowResourceNotException() {
        Long existedId = 4L;

        when(storeRepository.getById(anyLong()))
                .thenReturn(Optional.empty());

        ResourceNotFoundException resourceNotFoundException =
                assertThrows(ResourceNotFoundException.class, () -> storeRepository.delete(existedId));

        assertEquals("Store with id " + existedId + " is not found", resourceNotFoundException.getMessage());
        verify(storeRepository, times(0)).delete(anyLong());
        verify(goodsRepository, times(0)).deleteAllByStoreId(anyLong());

    }

    @Test
    void update() {
    }
}