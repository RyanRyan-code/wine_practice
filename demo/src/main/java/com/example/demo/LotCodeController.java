package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class LotCodeController {

    private final LotCodeRepository lotCodeRepository;
    private final ComponentRepository componentRepository;

    @Autowired
    public LotCodeController(LotCodeRepository lotCodeRepository, ComponentRepository componentRepository) {
        this.lotCodeRepository = lotCodeRepository;
        this.componentRepository = componentRepository;
    }

    //***Don't use this***
    /*

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

     */

    /*
    //don't use this
    @PostMapping("/api/post")
    public void newLot(@RequestBody LotCodeWithComponents lotCodeWithComponents){

        LotCode lotCode = new LotCode(lotCodeWithComponents);
        lotCodeRepository.saveAndFlush(lotCode);

        ArrayList<WineComponent> components = lotCodeWithComponents.getComponents();

        for(WineComponent component:components){
            component.setLotcode(lotCodeWithComponents.getLotCode());
            componentRepository.saveAndFlush(component);
        }

        LotCode lc;

    }

     */

    @PostMapping("/api/post")
    public void newLot(@RequestBody LotCode lc){

        lc.getComponents().stream().forEach(x-> x.setLotCode(new LotCode(lc.getLotCode())));

        lotCodeRepository.saveAndFlush(lc);


    }


    //***Don't use this***
    /*
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

     */

    //use this
    @GetMapping(value = "/api/breakdown/{search_type}/{lc}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public BreakdownResult wineBreakdown(@PathVariable String search_type, @PathVariable String lc) throws Exception {

        if (!SearchType.contains(search_type)){
            throw new Exception("search type is not valid!");
        }

        BreakdownResult breakdownResult = new BreakdownResult(search_type);

        List<WineComponent> components = lotCodeRepository.findById(lc)
                .orElseThrow(()->new Exception("lotcode does not exist! or something else"))
                .getComponents();

        List<String> keys = components.stream().map(x->x.getByString(search_type)).distinct().collect(Collectors.toList());

        List<Integer> percentages = new ArrayList<>();

        keys.forEach(x->percentages.
                add(components.stream()
                        .filter(c->c.getByString(search_type).equals(x))
                        .map(c->c.getPercentage())
                        .reduce(0, Integer::sum)));

        List<Integer> percentages_sorted = percentages.stream().sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList());

        for (Integer percentage : percentages_sorted){
            int[] indices = IntStream.range(0,keys.size())
                    .filter(i->percentages.get(i)==percentage)
                    .toArray();

            Arrays.stream(indices).forEach(i->breakdownResult.addNewPair(percentage, keys.get(i)));


        }





        return breakdownResult;
    }

}
