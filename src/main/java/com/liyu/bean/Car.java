package com.liyu.bean;

import lombok.Data;

@Data
public class Car {

    private String carName;
    private Double price;
    private Integer years;

    public Car() {
    }

    public Car(String carName, Double price) {
        this.carName = carName;
        this.price = price;
    }

    public Car(String carName, Integer years) {
        this.carName = carName;
        this.years = years;
    }

    public Car(String carName, Double price, Integer years) {
        this.carName = carName;
        this.years = years;
        this.price = price;
    }
}
