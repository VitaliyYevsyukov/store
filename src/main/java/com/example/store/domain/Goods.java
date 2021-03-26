package com.example.store.domain;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@ToString(exclude = "store")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "goods")
@Entity
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double cost;
    private String manufacturer;
    private Instant dateOfManufacture;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public Goods(String name, Double cost, String manufacturer, Instant dateOfManufacture) {
        this.name = name;
        this.cost = cost;
        this.manufacturer = manufacturer;
        this.dateOfManufacture = dateOfManufacture;
    }

    public Goods(Long id, String name, Double cost, String manufacturer, Instant dateOfManufacture) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.manufacturer = manufacturer;
        this.dateOfManufacture = dateOfManufacture;
    }
}
