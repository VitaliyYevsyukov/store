package com.example.store.dtos;

import com.example.store.domain.Goods;
import com.example.store.domain.Store;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GoodsDto {

    private Long id;
    private String name;
    private Double cost;
    private String manufacturer;
    private Instant dateOfManufacture;
    private Store store;

    public GoodsDto(Goods goods){
        this.id = goods.getId();
        this.name = goods.getName();
        this.cost = goods.getCost();
        this.manufacturer = goods.getManufacturer();
        this.dateOfManufacture = goods.getDateOfManufacture();
        this.store = goods.getStore();
    }

    public static Goods convertToDomain(GoodsDto goodsDto){
        return new Goods(goodsDto.getId(), goodsDto.getName(), goodsDto.getCost(),
                goodsDto.getManufacturer(), goodsDto.getDateOfManufacture(), goodsDto.getStore());
    }

    public static GoodsDto convertToDto(Goods goods) {
        return new GoodsDto(goods);
    }

}
