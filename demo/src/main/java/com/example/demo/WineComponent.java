package com.example.demo;

import javax.persistence.*;


@Entity
@Table(name = "wine_component")
public class WineComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String lotcode;
    private int percentage;
    private String year;
    private String variety;
    private String region;

    public WineComponent() {
    }

    public WineComponent(String lotcode, int percentage, String year, String variety, String region) {
        this.lotcode = lotcode;
        this.percentage = percentage;
        this.year = year;
        this.variety = variety;
        this.region = region;
    }

    public String getByString(String s){
        String string_to_return = null;

        switch (s){
            case "year":
                string_to_return = this.year;
                break;
            case "variety":
                string_to_return = this.variety;
                break;
            case "region":
                string_to_return = this.region;
                break;
            case "year-variety":
                string_to_return = this.year + " " + this.variety;
                break;
        }

        return string_to_return;
    }

    public void setLotcode(String lotcode) {
        this.lotcode = lotcode;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "WineComponent{" +
                "ID=" + ID +
                ", lotcode='" + lotcode + '\'' +
                ", percentage=" + percentage +
                ", year=" + year +
                ", variety='" + variety + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}

