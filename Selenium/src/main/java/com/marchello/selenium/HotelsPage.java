package com.marchello.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage {
    private WebDriver webDriver;

    public HotelsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public HotelsPage incorrectSearchForHotels(String destinations) throws InterruptedException {
        WebElement inputTo = this.webDriver.findElement(By.xpath("//input[@name='to']"));
        inputTo.sendKeys(destinations);
        inputTo.click();
        WebElement submitButton = this.webDriver.findElement(By.xpath("//div[@class='_24VpF']"));
        submitButton.click();
        return this;
    }

    public HotelsPage requestOnSity() throws InterruptedException {
        WebElement hrefSity = this.webDriver.findElement(By.xpath("//div[@class='_2t0wR OpvOL _2_AOf _10Dsl']"));
        hrefSity.click();
        return this;
    }

    public String getUrl() {
        return this.webDriver.getCurrentUrl();
    }
}
