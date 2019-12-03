package com.epam.ta.page;

import com.epam.ta.model.SearchQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelsPage extends AbstractPage
{
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://www.onetwotrip.com/ru/hotels/";

    final static String XPATH_OF_MESSAGE_EMPTY_PLACE = "//label[@class='_2-Hmd _1MMYi _23qYw']/span[@class='_2QlIR']";
    private WebElement messageEmptyPlace;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[3]/div[2]/div/div/div[2]/form/div[5]/button")
    private WebElement buttonSearch;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[3]/div[2]/div/div/div[2]/form/div[2]/div/div/input")
    private WebElement placeInput;

    public HotelsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public HotelsPage openPage(){
        driver.navigate().to(PAGE_URL);
        logger.info("Hotels page opened");
        return this;
    }

    public HotelsPage searchHotelsWithEmptyPlace(SearchQuery searchQuery){
        buttonSearch.click();
        return this;
    }

    public String messageEmptyPlaceError(){
        messageEmptyPlace = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_MESSAGE_EMPTY_PLACE)));
        return messageEmptyPlace.getText();
    }

    public UnrealPlaceMessagePage searchHotelsWithUnrealPlace(SearchQuery searchQuery){
        placeInput.sendKeys(searchQuery.getPlace());
        buttonSearch.click();
        return new UnrealPlaceMessagePage(driver);
    }
}
