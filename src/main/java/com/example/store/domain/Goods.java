package com.example.store.domain;

import lombok.*;

import java.time.Instant;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
public class Goods {

    private Long id;
    private String name;
    private Double cost;
    private String Manufacturer;
    private Instant dateOfManufacture;

    public Goods(String name, Double cost, String manufacturer, Instant dateOfManufacture) {
        this.name = name;
        this.cost = cost;
        Manufacturer = manufacturer;
        this.dateOfManufacture = dateOfManufacture;
    }
}
