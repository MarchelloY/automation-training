package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnrealPlaceMessagePage extends AbstractPage{

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div[2]/div/div[2]/div[1]")
    private WebElement unrealPlaceMessage;

    public UnrealPlaceMessagePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public UnrealPlaceMessagePage openPage(){
        return this;
    }

    public String unrealPlaceMessageError(){
        return unrealPlaceMessage.getText();
    }
}
