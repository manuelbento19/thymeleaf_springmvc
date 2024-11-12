package com.bentoo.spring_mvc.model;

import java.util.UUID;

public class Product {
    public UUID id;
    public String name;
    public double price;

    public Product(){
        this.id = UUID.randomUUID();
    }

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }
}