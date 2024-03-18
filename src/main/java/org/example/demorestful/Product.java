package org.example.demorestful;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
    private Long id;
    private String name;
    private double price;
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}