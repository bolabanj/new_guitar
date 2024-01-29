package edu.iu.bolabanj.c322spring2024homework2.model;

public class Guitar {
    private final String serialNumber;
    private double price;
    private final String builder;
    private final String model;
    private final String type;
    private final String backWood;
    private final String topWood;

    public Guitar(String serialNumber, double price,  String builder, String model, String type, String backWood, String topWood) {
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

    public String getBuilder() {
        return builder;
    }
    public String getModel() {
        return model;
    }
    public String getType() {
        return type;
    }
    public String getBackWood() {
        return backWood;
    }
    public String getTopWood() {
        return topWood;
    }
    public void setPrice(float newPrice) {
        this.price = newPrice;
    }
}
