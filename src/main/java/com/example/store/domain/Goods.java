package com.example.store.domain;

import java.time.Instant;
import java.util.Objects;

public class Goods {

    private Long id;
    private String name;
    private Double cost;
    private String Manufacturer;
    private Instant dateOfManufacture;

    Goods(){

    }

    public Goods(Long id, String name, Double cost, String manufacturer, Instant dateOfManufacture) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        Manufacturer = manufacturer;
        this.dateOfManufacture = dateOfManufacture;
    }

    public Goods(String name, Double cost, String manufacturer, Instant dateOfManufacture) {
        this.name = name;
        this.cost = cost;
        Manufacturer = manufacturer;
        this.dateOfManufacture = dateOfManufacture;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public Instant getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Instant dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(id, goods.id) && Objects.equals(name, goods.name) && Objects.equals(cost, goods.cost) && Objects.equals(Manufacturer, goods.Manufacturer) && Objects.equals(dateOfManufacture, goods.dateOfManufacture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost, Manufacturer, dateOfManufacture);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", Manufacturer='" + Manufacturer + '\'' +
                ", dateOfManufacture=" + dateOfManufacture +
                '}';
    }
}
