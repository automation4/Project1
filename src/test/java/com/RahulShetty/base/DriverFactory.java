package com.RahulShetty.base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class DriverFactory {
    private static DriverFactory instance = new DriverFactory();
    private DriverFactory(){}

    public static DriverFactory getInstance() {
        return instance;
    }

     private ThreadLocal<WebDriver> driver = new ThreadLocal();


    public void createBrowser(String browserName){
        switch (browserName){

            case CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disabled-notification");
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                options.setAcceptInsecureCerts(true);
                options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\driver\\chromedriverv99.exe");
                driver.set(new ChromeDriver(options));
                break;
            case FIREFOX:
                FirefoxOptions options1 = new FirefoxOptions();
                options1.addArguments("--disabled-notification");
                options1.setPageLoadStrategy(PageLoadStrategy.EAGER);
                options1.setAcceptInsecureCerts(true);
                options1.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\driver\\geckodriver.exe");
                driver.set(new FirefoxDriver(options1));
                break;
                default:
                break;
        }
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    public void closeBrowser(){
        getDriver().quit();
    }
}
