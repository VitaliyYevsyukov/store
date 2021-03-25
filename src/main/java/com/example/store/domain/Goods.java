package com.example.store.domain;

import lombok.*;

import java.time.Instant;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Goods {

    private Long id;
    private String name;
    private Double cost;
    private String manufacturer;
    private Instant dateOfManufacture;

    public Goods(String name, Double cost, String manufacturer, Instant dateOfManufacture) {
        this.name = name;
        this.cost = cost;
        this.manufacturer = manufacturer;
        this.dateOfManufacture = dateOfManufacture;
    }
}
