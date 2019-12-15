package com.marchello.hotel.hunter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlacePage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"HC_DateSelection_checkin_1\"]/div[2]/label/select")
    private WebElement inputDateCheckInMonth;
    @FindBy(xpath = "//*[@id=\"hc_f_id_checkin_1\"]")
    private WebElement inputDateCheckInDay;
    @FindBy(xpath = "//*[@id=\"hc_findAHotel\"]/div/div[2]/form/fieldset/div[8]/a")
    private WebElement buttonSubmit;
    final static String XPATH_OF_PICK_MONTH = "//*[@id=\"HC_DateSelection_checkin_1\"]/div[2]/label/select/option[14]";
    private WebElement pickMonth;
    final static String XPATH_OF_PICK_DAY = "//*[@id=\"hc_f_id_checkin_1\"]/option[30]";
    private WebElement pickDay;
    final static String XPATH_OF_MESSAGE_DATE_MORE_YEAR = "//*[@id=\"hc_findAHotel\"]/div/div[2]/form/fieldset/p/em";
    private WebElement messageDateMoreYear;

    public PlacePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public PlacePage openPage() {
        return this;
    }

    public String getUrl() {
        return this.driver.getCurrentUrl();
    }

    public String searchDateMoreYear() {
        this.inputDateCheckInDay.click();
        this.pickDay = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_PICK_DAY)));
        this.pickDay.click();
        logger.info("Day picked");
        this.inputDateCheckInMonth.click();
        this.pickMonth = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_PICK_MONTH)));
        this.pickMonth.click();
        logger.info("Month picked");
        this.buttonSubmit.click();
        logger.info("Search...");
        this.messageDateMoreYear = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_MESSAGE_DATE_MORE_YEAR)));
        logger.info("Get error message");
        return this.messageDateMoreYear.getText();
    }
}
