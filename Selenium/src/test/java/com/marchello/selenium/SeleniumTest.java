package com.marchello.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest {
    private static final String URL_ONETWOTRIP_HOTELS = "https://www.onetwotrip.com/ru/hotels/";
    private static final String URL_HOTELS_MOSCOW = "https://www.onetwotrip.com/ru/hotels/search/russia/moscow";
    private static final String INCORRECT_DESTINATIONS = "кеывапаоыоылш";
    private static final String PATH_DRIVER_CHROME = "E:/chromedriver.exe";
    private static final String PATH_CHROME_APP = "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe";
    private WebDriver webDriver;

    @BeforeMethod
    public void browserStart() {
        System.setProperty("webdriver.chrome.driver", PATH_DRIVER_CHROME);
        ChromeOptions options = new ChromeOptions();
        this.webDriver = new ChromeDriver(options.setBinary(PATH_CHROME_APP));
    }

    @AfterMethod
    public void browserExit() {
        this.webDriver.quit();
        this.webDriver = null;
    }

    @Test
    public void incorrectSearchForHotels() throws InterruptedException {
        String url = new HomePage(this.webDriver)
                .openHomePage()
                .goToTheHotelsPage()
                .incorrectSearchForHotels(INCORRECT_DESTINATIONS)
                .getUrl();
        Assert.assertEquals(url, URL_ONETWOTRIP_HOTELS);
    }

    @Test
    public void requestOnPopularDirect() throws InterruptedException {
        String url = new HomePage(this.webDriver)
                .openHomePage()
                .goToTheHotelsPage()
                .requestOnSity()
                .getUrl();
        Assert.assertTrue(url.contains(URL_HOTELS_MOSCOW));
    }
}
