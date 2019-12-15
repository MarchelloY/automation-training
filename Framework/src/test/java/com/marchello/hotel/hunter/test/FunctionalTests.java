package com.marchello.hotel.hunter.test;

import com.marchello.hotel.hunter.page.HomePage;
import com.marchello.hotel.hunter.service.DataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FunctionalTests extends CommonConditions {
    @Test
    public void switchLangTest() {
        String text = new HomePage(driver)
                .openPage()
                .selectLang();
        Assert.assertEquals(text, DataReader.getData("title.in.de.lang"));
    }
    @Test
    public void switchCurrensyTest() {
        String text = new HomePage(driver)
                .openPage()
                .selectCurrensy();
        Assert.assertEquals(text, DataReader.getData("currensy.kuna"));
    }
    //test
    @Test
    public void requestOnPlacePageTest() {
        String text = new HomePage(driver)
                .openPage()
                .requestOnPlacePage()
                .getUrl();
        Assert.assertTrue(text.contains(DataReader.getData("url.part.word")));
    }
    @Test
    public void logoButtonTest() {
        String url = new HomePage(driver)
                .openPage()
                .clickLogo();
        Assert.assertEquals(url, DataReader.getData("url.home.page"));
    }
}