package com.example.demo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WineComponentTest {

    @Test
    public void test_a(){

        WineComponent c = new WineComponent(50, "year_test", "variety_test", "region_test");

        Assertions.assertEquals(50, c.getPercentage());
        Assertions.assertEquals(0, c.getID());

        WineComponent d = new WineComponent(60, "year_test", "variety_test", "region_test");
        Assertions.assertEquals(0, d.getID());



    }


}
