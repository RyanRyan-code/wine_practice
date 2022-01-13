package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "wine_lot_codes")
public class LotCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String lotCode;
    private double volume;
    private String description;
    private String tankCode;
    private String productState;
    private String ownerName;

    public LotCode() {
    }

    public LotCode(String lotCode, double volume, String description, String tankCode, String productionState, String ownerName) {

        this.lotCode = lotCode;
        this.volume = volume;
        this.description = description;
        this.tankCode = tankCode;
        this.productState = productionState;
        this.ownerName = ownerName;
    }

    public int getID() {
        return ID;
    }

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

    public String getProductionState() {
        return productState;
    }

    public void setProductionState(String productionState) {
        this.productState = productionState;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "LotCode{" +
                "ID=" + ID +
                ", lotCode='" + lotCode + '\'' +
                ", volume=" + volume +
                ", description='" + description + '\'' +
                ", tankCode='" + tankCode + '\'' +
                ", productState='" + productState + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
