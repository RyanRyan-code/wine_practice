package com.example.demo.model.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class PercentageKeyPair{

    private int percentage;
    private String key;


    public PercentageKeyPair(int percentage, String key){
        this.percentage = percentage;
        this.key = key;
    }

    public PercentageKeyPair() {
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
