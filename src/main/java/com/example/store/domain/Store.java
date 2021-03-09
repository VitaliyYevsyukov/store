package com.example.store.domain;

import java.util.Objects;

public class Store {

    private Long id;
    private String name;
    private String phone;
    private String type;
    private Integer cashboxCount;
    private boolean isDelivery;

    Store(){

    }

    public Store(String name, String phone, String type, Integer cashboxCount, boolean isDelivery) {
        this.name = name;
        this.phone = phone;
        this.type = type;
        this.cashboxCount = cashboxCount;
        this.isDelivery = isDelivery;
    }

    public Store(Long id, String name, String phone, String type, Integer cashboxCount, boolean isDelivery) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.type = type;
        this.cashboxCount = cashboxCount;
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

    public Integer getCashboxCount() {
        return cashboxCount;
    }

    public void setCashboxCount(Integer cashboxCount) {
        this.cashboxCount = cashboxCount;
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
        return isDelivery == store.isDelivery && Objects.equals(id, store.id) && Objects.equals(name, store.name) && Objects.equals(phone, store.phone) && Objects.equals(type, store.type) && Objects.equals(cashboxCount, store.cashboxCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, type, cashboxCount, isDelivery);
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                ", cashboxCount=" + cashboxCount +
                ", isDelivery=" + isDelivery +
                '}';
    }
}
