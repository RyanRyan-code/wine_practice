package com.example.demo.service;

import com.example.demo.model.SearchType;
import com.example.demo.model.WineComponent;
import com.example.demo.model.result.PercentageKeyPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class WineComponentServiceImpl implements WineComponentService{

    @Override
    public String getTypeByString(String search_type, WineComponent component) {

        String string_to_return = null;

        switch (SearchType.getTypeByString(search_type)){
            case YEAR:
                string_to_return = component.getYear();
                break;
            case VARIETY:
                string_to_return = component.getVariety();
                break;
            case REGION:
                string_to_return = component.getRegion();
                break;
            case YEAR_VARIETY:
                string_to_return = component.getYear() + " " + component.getVariety();
                break;
        }

        return string_to_return;
    }

    @Override
    public List<String> getListDistinctKey(String search_type, List<WineComponent> components) {

        List<String> keys = components.stream()
                .map(component->getTypeByString(search_type, component))
                .distinct()
                .collect(Collectors.toList());

        return  keys;
    }

    @Override
    public List<Integer> getListPercentageByDistinctKey(List<String> keys, String search_type, List<WineComponent> components) {

        List<Integer> percentages = new ArrayList<>();

        keys.forEach(x->percentages.
                add(components.stream()
                        .filter(component->getTypeByString(search_type, component).equals(x))
                        .map(WineComponent::getPercentage)
                        .reduce(0, Integer::sum)));

        return percentages;
    }

    @Override
    public ArrayList<PercentageKeyPair> getListPercentageKeyPair(String search_type, List<WineComponent> components) {

        ArrayList<PercentageKeyPair> ans = new ArrayList<>();

        //the following two lists correspond one-to-one
        List<String> keys = getListDistinctKey(search_type, components);
        List<Integer> percentages = getListPercentageByDistinctKey(keys, search_type, components);

        List<Integer> percentages_sorted = percentages.stream().sorted(Comparator.reverseOrder()).distinct().toList();

        for (Integer percentage : percentages_sorted){
            int[] indices = IntStream.range(0,keys.size())
                    .filter(i->percentages.get(i)==percentage)
                    .toArray();

            Arrays.stream(indices).forEach(i->ans.add(new PercentageKeyPair(percentage, keys.get(i))));

        }

        return ans;
    }

}
