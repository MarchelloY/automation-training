package com.marchello.hotel.hunter.test;

import com.marchello.hotel.hunter.page.HomePage;
import com.marchello.hotel.hunter.service.DataReader;
import com.marchello.hotel.hunter.service.SearchQueryCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchHotelsTest extends CommonConditions {
    @Test
    public void searchHotelsWithEmptyPlace() {
        String errorText = new HomePage(driver)
                .openPage()
                .searchEmptyPlace();
        Assert.assertEquals(errorText, DataReader.getData("error.message.empty.place"));
    }
    @Test
    public void searchHotelsWithEmptyDate() {
        String errorText = new HomePage(driver)
                .openPage()
                .searchEmptyDate();
        Assert.assertEquals(errorText, DataReader.getData("error.message.empty.date"));
    }
    @Test
    public void searchHotelsWithIncorrectPlace() {
        String errorText = new HomePage(driver)
                .openPage()
                .pickDate()
                .searchIncorrectPlace(SearchQueryCreator.withIncorrectPlace())
                .getMessageNotFound();
        Assert.assertEquals(errorText, DataReader.getData("error.message.not.found"));
    }
    @Test
    public void searchHotelsWithNotExistHotel() {
        String errorText = new HomePage(driver)
                .openPage()
                .pickDate()
                .searchNotExistHotel(SearchQueryCreator.withCorrectPlace())
                .selectSity()
                .getMessageNoHotels();
        Assert.assertEquals(errorText, DataReader.getData("error.message.no.hotels"));
    }
    @Test
    public void searchHotelsWithDateMoreYear(){
        String errorText = new HomePage(driver)
                .openPage()
                .requestOnPlacePage()
                .searchDateMoreYear();
        Assert.assertEquals(errorText, DataReader.getData("error.message.date.more.year"));
    }
    @Test
    public void searchHotelsWithCorrectPlace() {
        String text = new HomePage(driver)
                .openPage()
                .pickDate()
                .searchCorrectPlace(SearchQueryCreator.withCorrectPlace())
                .getMessageCorrectFind();
        Assert.assertEquals(text, DataReader.getData("message.correct.find"));
    }
}
