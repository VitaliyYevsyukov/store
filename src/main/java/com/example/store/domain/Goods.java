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

}
