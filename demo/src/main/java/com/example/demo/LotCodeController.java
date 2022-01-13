package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class LotCodeController {

    private final LotCodeRepository lotCodeRepository;
    private final ComponentRepository componentRepository;

    @Autowired
    public LotCodeController(LotCodeRepository lotCodeRepository, ComponentRepository componentRepository) {
        this.lotCodeRepository = lotCodeRepository;
        this.componentRepository = componentRepository;
    }

    @PostMapping("/api/post")
    public void newLot(@RequestBody String string){

        Gson gson = new Gson();
        LotCode lc = gson.fromJson(string,LotCode.class);
        lotCodeRepository.saveAndFlush(lc);


        String string2 = gson.fromJson(string, JsonObject.class).get("components").toString();
        WineComponent[] components = gson.fromJson(string2,WineComponent[].class);

        for (WineComponent component: components){
            component.setLotcode(lc.getLotCode());
            System.out.println(component.toString());
            componentRepository.saveAndFlush(component);
        }
    }

    @GetMapping("/api/breakdown/{search_type}/{lc}")
    public JsonObject yearBreakdown(@PathVariable String search_type, @PathVariable String lc){

        WineComponent wineComponent = new WineComponent();
        wineComponent.setLotcode(lc);

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny().withIgnorePaths("percentage","year");
        Example<WineComponent> example = Example.of(wineComponent, exampleMatcher);
        List<WineComponent> components = componentRepository.findAll(example);

        HashMap<String,Integer> hashMap = new HashMap<>();
        String type = new String();

        for (WineComponent component:components){

            switch (search_type){
                case "year":
                    type = component.getYear();
                    break;
                case "variety":
                    type = component.getVariety();
                    break;
                case "region":
                    type = component.getRegion();
                    break;
                case "year-variety":
                    type = component.getYear()+" "+component.getVariety();
            }

            if (hashMap.containsKey(type)){
                hashMap.replace(type, component.getPercentage()+hashMap.get(type));
            }else{
                hashMap.put(type, component.getPercentage());
            }
        }

        List<String> keys = new ArrayList<>(hashMap.keySet());
        List<Integer> sorted_percentage = new ArrayList<>(hashMap.values());
        Collections.sort(sorted_percentage, Collections.reverseOrder());

        List<Integer> sorted_percentage_uk = sorted_percentage.stream().distinct().collect(Collectors.toList());

        String answer = new String();
        answer = answer.concat("{breakDownType: \"").concat(search_type).concat("\",breakdown: [");
        for (Integer percentage:sorted_percentage_uk){
            for (String key:keys){
                if (hashMap.get(key).equals(percentage)){
                    answer = answer.concat("{percentage: \"").concat(percentage.toString()).concat("\",");
                    answer = answer.concat("key: \"").concat(key).concat("\"},");
                }
            }
        }
        answer = answer.substring(0, answer.length()-1);
        answer = answer.concat("]}");

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(answer, JsonObject.class);

        return  jsonObject;























    }



}
