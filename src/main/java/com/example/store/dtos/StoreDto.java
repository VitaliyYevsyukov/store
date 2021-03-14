package com.example.store.dtos;

import com.example.store.domain.Goods;
import com.example.store.domain.Store;
import lombok.*;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
public class StoreDto {

    private Long id;
    private String name;
    private String phone;
    private String type;
    private Integer cashboxCount;
    private boolean isDelivery;
    private List<GoodsDto> goodsDtoList;

    public StoreDto(Store store, List<Goods> goods) {
        this.id = store.getId();
        this.name = store.getName();
        this.phone = store.getPhone();
        this.type = store.getType();
        this.cashboxCount = store.getCashboxCount();
        this.isDelivery = store.isDelivery();
        this.goodsDtoList = !CollectionUtils.isEmpty(goods) ?
                goods.stream().map(GoodsDto::new)
                .collect(Collectors.toList()) : Collections.emptyList();
    }

    public StoreDto(Store store) {
        this(store, null);
    }

    public static Store convertToDomain(StoreDto storeDto) {
        return new Store(storeDto.getId(), storeDto.getName(),
                storeDto.getPhone(), storeDto.getType(), storeDto.getCashboxCount(), storeDto.isDelivery,
                storeDto.getGoodsDtoList().stream()
                        .map(goods -> GoodsDto.convertToDomain(goods)).collect(Collectors.toList()));
    }

    public static StoreDto convertToDto(Store store){
        return new StoreDto(store);
    }


}
