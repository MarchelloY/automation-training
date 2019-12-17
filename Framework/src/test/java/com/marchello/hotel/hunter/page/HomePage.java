package com.marchello.hotel.hunter.page;

import com.marchello.hotel.hunter.model.SearchQuery;
import com.marchello.hotel.hunter.service.DataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"hc_r_globalWrap\"]/header/div/div[2]/h1")
    private WebElement title;
    @FindBy(xpath = "//*[@id=\"hc_f_id_where_1\"]")
    private WebElement inputPlace;
    @FindBy(xpath = "//*[@id=\"hc_findAHotel\"]/div/div[2]/form/fieldset/div[2]")
    private WebElement inputDateCheckIn;
    @FindBy(xpath = "//*[@id=\"hc_findAHotel\"]/div/div[2]/form/fieldset/fieldset/legend/a")
    private WebElement moreOptions;
    @FindBy(xpath = "//*[@id=\"hc_findAHotel\"]/div/div[2]/form/fieldset/div[9]/a")
    private WebElement buttonSubmit;
    @FindBy(xpath = "//*[@id=\"hc_evt_settings_buttons\"]/ul/li[1]/a/span")
    private WebElement buttonLang;
    @FindBy(xpath = "//*[@id=\"hc_evt_settings_buttons\"]/ul/li[2]/a")
    private WebElement buttonCurrensy;
    @FindBy(xpath = "//*[@id=\"hc_topDest\"]/div/div[2]/div[1]/div/a")
    private WebElement topSity;
    @FindBy(xpath = "//*[@id=\"hc_r_globalWrap\"]/header/div/div[1]/a/img")
    private WebElement logo;
    final static String XPATH_OF_SELECT_CURRENSY = "//*[@id=\"hc_evt_settings_currency\"]/div[2]/div[2]/ul[1]/li[8]/a";
    private WebElement selectCurrensy;
    final static String XPATH_OF_SELECT_LANG = "//*[@id=\"hc_evt_settings_language\"]/div[2]/div[2]/ul[1]/li[2]/a";
    private WebElement selectLang;
    final static String XPATH_OF_RADIO_FIVE_STARS = "//*[@id=\"hc_f_filter_star_5\"]";
    private WebElement radioFiveStars;
    final static String XPATH_OF_RADIO_MIN_PRICE = "//*[@id=\"hc_findAHotel\"]/div/div[2]/form/fieldset/fieldset/fieldset[2]/div[1]/label/span[1]/span[1]/span[1]";
    private WebElement radioMinPrice;
    final static String XPATH_OF_SELECT_DATE = "//*[@id=\"ui-datepicker-div\"]/div/div[2]/div[1]/table/tbody/tr[5]/td[2]";
    private WebElement selectDate;
    final static String XPATH_OF_MESSAGE_EMPTY_PLACE = "//*[@id=\"hc_findAHotel\"]/div/div[2]/form/fieldset/p[1]/em";
    private WebElement messageEmptyPlace;
    final static String XPATH_OF_MESSAGE_EMPTY_DATE = "//*[@id=\"hc_findAHotel\"]/div/div[2]/form/fieldset/p[2]/em";
    private WebElement messageEmptyDate;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public HomePage openPage() {
        this.driver.navigate().to(DataReader.getData("url.home.page"));
        logger.info("Home Page opened");
        return this;
    }

    public String searchEmptyPlace() {
        this.buttonSubmit.click();
        this.messageEmptyPlace = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_MESSAGE_EMPTY_PLACE)));
        logger.info("Message empty place received");
        return this.messageEmptyPlace.getText();
    }

    public String searchEmptyDate() {
        this.buttonSubmit.click();
        this.messageEmptyDate = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_MESSAGE_EMPTY_DATE)));
        logger.info("Message empty date received");
        return this.messageEmptyDate.getText();
    }

    public String selectLang() {
        this.buttonLang.click();
        this.selectLang = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_SELECT_LANG)));
        this.selectLang.click();
        logger.info("Switch lang from EN to DE");
        return this.title.getText();
    }

    public String selectCurrensy() {
        this.buttonCurrensy.click();
        this.selectCurrensy = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_SELECT_CURRENSY)));
        this.selectCurrensy.click();
        this.moreOptions.click();
        this.radioMinPrice = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_RADIO_MIN_PRICE)));
        logger.info("Switch currensy from BYN to KN");
        return this.radioMinPrice.getText();
    }

    public SearchPage searchIncorrectPlace(SearchQuery searchQuery) {
        this.inputPlace.sendKeys(searchQuery.getPlace());
        this.buttonSubmit.click();
        logger.info("Incorrect place introduced");
        return new SearchPage(driver);
    }

    public SearchPage searchCorrectPlace(SearchQuery searchQuery) {
        this.inputPlace.sendKeys(searchQuery.getPlace());
        this.buttonSubmit.click();
        logger.info("Incorrect place introduced");
        return new SearchPage(driver);
    }

    public SearchPage searchNotExistHotel(SearchQuery searchQuery) {
        this.moreOptions.click();
        logger.info("Click more options");
        this.radioFiveStars = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_RADIO_FIVE_STARS)));
        this.radioFiveStars.click();
        logger.info("Select 5 stars");
        this.radioMinPrice = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_RADIO_MIN_PRICE)));
        this.radioMinPrice.click();
        logger.info("Select min price");
        this.inputPlace.sendKeys(searchQuery.getPlace());
        this.buttonSubmit.click();
        logger.info("Search...");
        return new SearchPage(driver);
    }

    public PlacePage requestOnPlacePage(){
        this.topSity.click();
        logger.info("Request to place page");
        return new PlacePage(driver);
    }

    public String clickLogo(){
        this.logo.click();
        logger.info("Click logo");
        return driver.getCurrentUrl();
    }

    public HomePage pickDate(){
        this.inputDateCheckIn.click();
        this.selectDate = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_SELECT_DATE)));
        this.selectDate.click();
        logger.info("Date selected");
        return this;
    }
}
