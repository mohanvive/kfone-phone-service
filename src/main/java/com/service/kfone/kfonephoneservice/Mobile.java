package com.service.kfone.kfonephoneservice;

public class Mobile {
    String brand;
    String name;
    double ratePerMonth;
    double price;

    public Mobile(String brand, String name, double ratePerMonth, double price) {
        this.brand = brand;
        this.name = name;
        this.ratePerMonth = ratePerMonth;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRatePerMonth() {
        return ratePerMonth;
    }

    public void setRatePerMonth(double ratePerMonth) {
        this.ratePerMonth = ratePerMonth;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
