package com.epam.testautomation.tests;

import com.epam.testautomation.page.LaunchesMainPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

@Epic("test epic")
@Feature("test feature")
public class LaunchesTests extends BaseTest{

    @Autowired
    private LaunchesMainPage launchesMainPage;

    @Test
    void initTest(){
        launchesMainPage.clickButton();
    }

}
