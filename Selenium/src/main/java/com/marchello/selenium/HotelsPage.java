package com.marchello.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HotelsPage {
    private WebDriver webDriver;

    public HotelsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public HotelsPage incorrectSearchForHotels(String destinations) throws InterruptedException {
        Thread.sleep(5000);
        WebElement inputTo = this.webDriver.findElement(By.xpath("//input[@name='to']"));
        inputTo.sendKeys(destinations);
        Thread.sleep(5000);
        inputTo.click();
        Thread.sleep(5000);
        WebElement submitButton = this.webDriver.findElement(By.xpath("//div[@class='_24VpF']"));
        submitButton.click();
        return this;
    }

    public HotelsPage requestOnSity() throws InterruptedException {
        Thread.sleep(5000);
        WebElement hrefSity = this.webDriver.findElement(By.xpath("//div[@class='_2t0wR OpvOL _2_AOf _10Dsl']"));
        hrefSity.click();
        return this;
    }

    public String getUrl() {
        return this.webDriver.getCurrentUrl();
    }
}
