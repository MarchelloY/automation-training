package com.marchello.hotel.hunter.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"hc_r_3b\"]/div[1]/div/div[1]/h1")
    private WebElement messageNotFound;

    @FindBy(xpath = "//*[@id=\"hc_r_3b\"]/div[1]/div/div[1]/h1/span")
    private WebElement messageCorrectFind;

    @FindBy(xpath = "//*[@id=\"hc_usr\"]/div[1]")
    private WebElement sityItem;

    protected SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return this;
    }

    public String getMessageNotFound() {
        logger.info("Get error message");
        return this.messageNotFound.getText();
    }

    public String getMessageCorrectFind() {
        logger.info("Get message");
        return this.messageCorrectFind.getText();
    }

    public HotelsPage selectSity() {
        this.sityItem.click();
        logger.info("Select sity");
        return new HotelsPage(driver);
    }
}
