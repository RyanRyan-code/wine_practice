package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wine_lot_codes")
@JsonPropertyOrder({"lotCode", "volume", "description", "tankCode", "productState", "ownerName", "components"})
public class LotCode {

    @Id
    private String lotCode;

    private double volume;

    private String description;

    private String tankCode;

    private String productState;

    private String ownerName;

    @OneToMany(mappedBy = "lotcode", cascade = CascadeType.ALL)
    private List<WineComponent> components;





    public List<WineComponent> getComponents() {
        return components;
    }

    public void setComponents(List<WineComponent> components) {
        this.components = components;
    }

    public LotCode (String s){
        this.lotCode = s;
    }

    public LotCode(String lotCode, double volume, String description, String tankCode, String productState, String ownerName, List<WineComponent> components) {
        this.lotCode = lotCode;
        this.volume = volume;
        this.description = description;
        this.tankCode = tankCode;
        this.productState = productState;
        this.ownerName = ownerName;
        this.components = components;

    }

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

    public void setProductState(String productionState) {
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
