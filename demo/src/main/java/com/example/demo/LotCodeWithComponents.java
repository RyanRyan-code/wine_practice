package com.example.demo;

import java.util.ArrayList;

public class LotCodeWithComponents {

    private String lotCode;
    private double volume;
    private String description;
    private String tankCode;
    private String productState;
    private String ownerName;

    ArrayList<WineComponent> components = new ArrayList<>();

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTankCode() {
        return tankCode;
    }

    public void setTankCode(String tankCode) {
        this.tankCode = tankCode;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public ArrayList<WineComponent> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<WineComponent> components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return "LotCodeWithComponents{" +
                "lotCode='" + lotCode + '\'' +
                ", volume=" + volume +
                ", description='" + description + '\'' +
                ", tankCode='" + tankCode + '\'' +
                ", productState='" + productState + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", components=" + components +
                '}';
    }
}


