package com.example.store.domain;

import java.util.Objects;

public class Store {

    private Long id;
    private String name;
    private String phone;
    private String type;
    private Integer numberOfCashBox;
    private boolean isDelivery;

    Store(){

    }

    public Store(Long id, String name, String phone, String type, Integer numberOfCashBox, boolean isDelivery) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.type = type;
        this.numberOfCashBox = numberOfCashBox;
        this.isDelivery = isDelivery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumberOfCashBox() {
        return numberOfCashBox;
    }

    public void setNumberOfCashBox(Integer numberOfCashBox) {
        this.numberOfCashBox = numberOfCashBox;
    }

    public boolean isDelivery() {
        return isDelivery;
    }

    public void setDelivery(boolean delivery) {
        isDelivery = delivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return isDelivery == store.isDelivery && Objects.equals(id, store.id) && Objects.equals(name, store.name) && Objects.equals(phone, store.phone) && Objects.equals(type, store.type) && Objects.equals(numberOfCashBox, store.numberOfCashBox);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, type, numberOfCashBox, isDelivery);
    }
}
