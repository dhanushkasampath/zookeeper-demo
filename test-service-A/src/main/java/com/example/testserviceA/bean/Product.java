package com.example.testserviceA.bean;

public class Product {
    private int id;
    private String name;
    private String serialNumber;
    private String expiryDate;

    public Product(int id, String name, String serialNumber, String expiryDate){
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.expiryDate = expiryDate;
    }

    public Product(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}