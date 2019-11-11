package com.marchello.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private static final String ONE_TWO_TRIP_URL = "https://www.onetwotrip.com/ru/";
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public HomePage openHomePage() {
        this.webDriver.get(ONE_TWO_TRIP_URL);
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public HotelsPage goToTheHotelsPage() {
        WebElement hotelsTab = this.webDriver.findElement(By.xpath("//a[@class='K0Mi2']"));
        hotelsTab.click();
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new HotelsPage(this.webDriver);
    }
}
