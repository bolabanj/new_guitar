package edu.iu.bolabanj.c322spring2024homework2.model;

import edu.iu.bolabanj.c322spring2024homework2.enums.Builder;
import edu.iu.bolabanj.c322spring2024homework2.enums.Type;
import edu.iu.bolabanj.c322spring2024homework2.enums.Wood;

public class Guitar {
    private final String serialNumber;
    private double price;
    private final Builder builder;
    private final String model;
    private final Type type;
    private final Wood backWood;
    private final Wood topWood;

    public Guitar(String serialNumber, double price,  Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.backWood = backWood;
        this.builder = builder;
        this.model = model;
        this.price = price;
        this.serialNumber = serialNumber;
        this.topWood = topWood;
        this.type = type;

    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public Builder getBuilder() {
        return builder;
    }
    public String getModel() {
        return model;
    }
    public Type getType() {
        return type;
    }
    public Wood getBackWood() {
        return backWood;
    }
    public Wood getTopWood() {
        return topWood;
    }
    public void setPrice(float newPrice) {
        this.price = newPrice;
    }
}
