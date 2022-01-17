package com.example.demo;

import java.util.ArrayList;

public class BreakdownResult {

    private String breakDownType;

    public BreakdownResult(String breakDownType) {
        this.breakDownType = breakDownType;
    }

    private class Pair{
        int percentage;
        String key;

        Pair(int percentage, String key){
            this.percentage = percentage;
            this.key = key;
        }

        public int getPercentage() {
            return percentage;
        }

        public void setPercentage(int percentage) {
            this.percentage = percentage;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    ArrayList<Pair> breakdown = new ArrayList<>();


    public void addNewPair(int percentage, String key){
        breakdown.add(new Pair(percentage, key));
    }

    public String getBreakDownType() {
        return breakDownType;
    }

    public void setBreakDownType(String breakDownType) {
        this.breakDownType = breakDownType;
    }

    public ArrayList<Pair> getBreakdown() {
        return breakdown;
    }

    public void setBreakdown(ArrayList<Pair> breakdown) {
        this.breakdown = breakdown;
    }
}
