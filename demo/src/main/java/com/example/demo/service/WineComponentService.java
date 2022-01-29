package com.example.demo.service;

import com.example.demo.model.WineComponent;
import com.example.demo.model.result.PercentageKeyPair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface WineComponentService {

    public String getTypeByString(String s, WineComponent component);

    public List<String> getListDistinctKey(String search_type, List<WineComponent> components);

    public List<Integer> getListPercentageByDistinctKey(List<String> keys, String search_type, List<WineComponent> components);

    public ArrayList<PercentageKeyPair> getListPercentageKeyPair (String search_type, List<WineComponent> components);



}
