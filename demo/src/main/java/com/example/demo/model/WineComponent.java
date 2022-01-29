package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;


@Entity
@Table(name = "wine_component")
@JsonPropertyOrder({"id", "lotcode", "percentage", "year", "variety", "region"})
public class WineComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String lotcode;

    private int componentPercentage;

    private String componentYear;

    private String componentVariety;

    private String componentRegion;




    public WineComponent() {
    }

    public WineComponent(int percentage, String year, String variety, String region, String lotCode) {

        this.componentPercentage = percentage;
        this.componentYear = year;
        this.componentVariety = variety;
        this.componentRegion = region;
        this.lotcode = lotcode;
    }

    public WineComponent(int percentage, String year, String variety, String region) {

        this.componentPercentage = percentage;
        this.componentYear = year;
        this.componentVariety = variety;
        this.componentRegion = region;
    }


    public int getID(){
        return this.id;
    }

    public String getLotcode() {
        return lotcode;
    }

    public void setLotcode(String lotcode) {
        this.lotcode = lotcode;
    }

    public int getPercentage() {
        return componentPercentage;
    }

    public void setPercentage(int percentage) {
        this.componentPercentage = percentage;
    }

    public String getYear() {
        return componentYear;
    }

    public void setYear(String year) {
        this.componentYear = year;
    }

    public String getVariety() {
        return componentVariety;
    }

    public void setVariety(String variety) {
        this.componentVariety = variety;
    }

    public String getRegion() {
        return componentRegion;
    }

    public void setRegion(String region) {
        this.componentRegion = region;
    }

    @Override
    public String toString() {
        return "WineComponent{" +
                "ID=" + id + ", lotcode:" + getLotcode() +
                ", percentage=" + componentPercentage +
                ", year=" + componentYear +
                ", variety='" + componentVariety + '\'' +
                ", region='" + componentRegion + '\'' +
                '}';
    }
}

