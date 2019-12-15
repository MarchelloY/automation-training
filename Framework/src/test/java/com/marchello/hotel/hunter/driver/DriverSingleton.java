package com.marchello.hotel.hunter.driver;

import com.marchello.hotel.hunter.service.DataReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver() {
        if (null == driver) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(new ChromeOptions().setBinary(DataReader.getData("path.chrome.browser")));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        //driver.quit();
        driver = null;
    }
}
