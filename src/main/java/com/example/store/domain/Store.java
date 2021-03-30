package com.example.store.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "stores")
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String type;
    private Integer cashboxCount;
    private boolean delivery;
    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private List<Goods> goodsList;

    public Store(String name, String phone, String type, Integer cashboxCount, boolean delivery) {
        this.name = name;
        this.phone = phone;
        this.type = type;
        this.cashboxCount = cashboxCount;
        this.delivery = delivery;
    }

}
