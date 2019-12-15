package com.marchello.hotel.hunter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelsPage extends AbstractPage {

    final static String XPATH_OF_MESSAGE_NO_HOTELS = "//*[@id=\"SearchResultsHolder\"]/p/strong";
    private WebElement messageNoHotels;

    protected HotelsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return this;
    }

    public String getMessageNoHotels() {
        this.messageNoHotels = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_MESSAGE_NO_HOTELS)));
        logger.info("Get error message");
        return this.messageNoHotels.getText();
    }
}
