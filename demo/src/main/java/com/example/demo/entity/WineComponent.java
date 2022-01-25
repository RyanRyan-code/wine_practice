package com.example.demo.entity;

import com.example.demo.util.SearchType;

import javax.persistence.*;


@Entity
@Table(name = "wine_component")
public class WineComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private int percentage;
    private String year;
    private String variety;
    private String region;

    @ManyToOne
    @JoinColumn(name = "lotcode")
    private LotCode lotCode;


    public LotCode getLotCode() {
        return lotCode;
    }

    public void setLotCode(LotCode lotCode) {
        this.lotCode = lotCode;
    }

    public WineComponent() {
    }


    public WineComponent(int percentage, String year, String variety, String region, LotCode lotCode) {

        this.percentage = percentage;
        this.year = year;
        this.variety = variety;
        this.region = region;
        this.lotCode = lotCode;
    }

    public WineComponent(int percentage, String year, String variety, String region) {

        this.percentage = percentage;
        this.year = year;
        this.variety = variety;
        this.region = region;
    }

    public String getByString(String s){
        String string_to_return = null;

        switch (SearchType.getTypeByString(s)){
            case YEAR:
                string_to_return = this.year;
                break;
            case VARIETY:
                string_to_return = this.variety;
                break;
            case REGION:
                string_to_return = this.region;
                break;
            case YEAR_VARIETY:
                string_to_return = this.year + " " + this.variety;
                break;
        }

        return string_to_return;
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
                "ID=" + ID + ", lotcode:" + getLotCode().getLotCode() +
                ", percentage=" + percentage +
                ", year=" + year +
                ", variety='" + variety + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
