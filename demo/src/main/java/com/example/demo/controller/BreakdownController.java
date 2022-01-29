package com.example.demo.controller;

import com.example.demo.model.result.BreakdownResult;
import com.example.demo.model.LotCode;
import com.example.demo.model.SearchType;
import com.example.demo.model.WineComponent;
import com.example.demo.model.result.PercentageKeyPair;
import com.example.demo.repository.ComponentRepository;
import com.example.demo.repository.LotCodeRepository;
import com.example.demo.service.WineComponentService;
import com.example.demo.service.WineComponentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class BreakdownController {

    private final LotCodeRepository lotCodeRepository;
    private final ComponentRepository componentRepository;
    private final WineComponentService wineComponentService;

    @Autowired
    public BreakdownController(LotCodeRepository lotCodeRepository,
                               ComponentRepository componentRepository,
                               WineComponentServiceImpl wineComponentService) {
        this.lotCodeRepository = lotCodeRepository;
        this.componentRepository = componentRepository;
        this.wineComponentService = wineComponentService;
    }


    @PostMapping("/api/post")
    public void newLot(@RequestBody LotCode lc){

        //set the lotcode of each component to the same lotcode. otherwise, it's null.
        lc.getComponents().forEach(x -> x.setLotcode(lc.getLotCode()));

        //persist data to both tables
        lotCodeRepository.saveAndFlush(lc);

    }


    @GetMapping(value = "/api/breakdown/{search_type}/{lc}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public BreakdownResult wineBreakdown(@PathVariable String search_type, @PathVariable String lc) throws Exception {

        //validate search_type
        if (!SearchType.contains(search_type)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "search type is not valid!");
        }


        //validate lot_code and get components
        List<WineComponent> components = lotCodeRepository.findById(lc)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "lotcode does not exist! or something else"))
                .getComponents();


        //get business logic result
        ArrayList<PercentageKeyPair> pairs = wineComponentService.getListPercentageKeyPair(search_type, components);


        //work on the response content
        BreakdownResult breakdownResult = new BreakdownResult();
        breakdownResult.setBreakDownType(search_type);
        breakdownResult.setBreakdown(pairs);

        return breakdownResult;
    }


    @GetMapping(value = "/api/search/{lc}")
    @ResponseBody
    public LotCode basicSearch(@PathVariable String lc){
        LotCode l = lotCodeRepository.findById(lc)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "lotcode does not exist! or something else"));
        return l;
    }


    @DeleteMapping(value = "/api/delete/lotcode/{lc}")
    public void deleteOne(@PathVariable String lc){
        LotCode l = lotCodeRepository.findById(lc)
                    .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "lotcode does not exist! or something else"));
        lotCodeRepository.delete(l);

    }


    @DeleteMapping(value = "/api/delete/all")
    public void deleteAll(){

        lotCodeRepository.deleteAll();

    }
}
