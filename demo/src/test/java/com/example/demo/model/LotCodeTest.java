package com.example.demo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LotCodeTest {

    @Test
    public void test_a(){
        LotCode l = new LotCode("lotcode_test",
                500.01,
                "description_test",
                "tankcode_test",
                "productstate_test",
                "ownername_test");

        Assertions.assertEquals("lotcode_test", l.getLotCode());
        Assertions.assertEquals(500.01, l.getVolume());
        Assertions.assertEquals("tankcode_test", l.getTankCode());
        Assertions.assertEquals("productstate_test", l.getProductState());
        Assertions.assertEquals("ownername_test", l.getOwnerName());
        Assertions.assertNull(l.getComponents());
    }



}
