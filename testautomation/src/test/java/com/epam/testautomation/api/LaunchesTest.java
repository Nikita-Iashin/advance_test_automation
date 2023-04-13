package com.epam.testautomation.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

public class LaunchesTest extends BaseHttpComponent{

    @Value("")
    String url;

    @Autowired
    Steps steps;


    @Override
    protected Map<String, Runnable> defaultStubs() {
        return null;
    }



    @Test
    void someTest() {
        createDefaultStubsForAllEndpoints();

        //steps

    }

}
