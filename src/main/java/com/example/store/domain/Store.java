package com.example.store.domain;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
public class Store {

    private Long id;
    private String name;
    private String phone;
    private String type;
    private Integer cashboxCount;
    private boolean isDelivery;
    private List<Goods> goodsList;

    public Store(String name, String phone, String type, Integer cashboxCount, boolean isDelivery) {
        this.name = name;
        this.phone = phone;
        this.type = type;
        this.cashboxCount = cashboxCount;
        this.isDelivery = isDelivery;
    }
}
