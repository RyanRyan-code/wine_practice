package com.example.demo;

import java.util.Arrays;

public enum SearchType {

    YEAR ("year"),
    VARIETY ("variety"),
    REGION ("region"),
    YEAR_VARIETY ("year-variety");

    private String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    SearchType(){

    }

    SearchType(String s){
        this.s = s;
    }

    public static boolean contains(String t){
        for (SearchType type:SearchType.values()){
            if (type.getS().equals(t)){
                return true;
            }
        }
        return false;
    }




}
