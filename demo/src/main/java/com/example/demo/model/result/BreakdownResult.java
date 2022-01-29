package com.example.demo.model.result;

import org.springframework.stereotype.Component;

import java.util.ArrayList;


public class BreakdownResult {




    private String breakDownType;

    ArrayList<PercentageKeyPair> breakdown = new ArrayList<>();


    public BreakdownResult() {

    }

    public void addNewPair(int percentage, String key){
        breakdown.add(new PercentageKeyPair(percentage, key));
    }

    public String getBreakDownType() {
        return breakDownType;
    }

    public void setBreakDownType(String breakDownType) {
        this.breakDownType = breakDownType;
    }

    public ArrayList<PercentageKeyPair> getBreakdown() {
        return breakdown;
    }

    public void setBreakdown(ArrayList<PercentageKeyPair> breakdown) {
        this.breakdown = breakdown;
    }

}
