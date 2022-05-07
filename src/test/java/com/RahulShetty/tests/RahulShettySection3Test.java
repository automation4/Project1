package com.RahulShetty.tests;

import Utilities.Utils;
import com.RahulShetty.base.BrowserType;
import com.RahulShetty.base.DriverFactory;
import Utilities.TestListeners;
import com.RahulShetty.pages.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(TestListeners.class)
public class RahulShettySection3Test {
WebDriver driver;
    public BasePage p;

    @BeforeClass(alwaysRun = true)
    public void initializeDriver() throws IOException {
        //DriverFactory.getInstance().createBrowser(BrowserType.CHROME);
        String browserName= System.getProperty("browser");
        DriverFactory.getInstance().createBrowser(browserName);
        driver = DriverFactory.getInstance().getDriver();
        driver.get(Utils.getTestData("url"));
        p = new BasePage(driver);
    }

    @Test(groups = {"smoke","regression"})
    public void getCourcesWithMatchingPrice() throws IOException {
    p.getSection3().getCourseWithPrice(23);
    }

    @Test(groups = {"smoke","regression"})
    public void getCourcesWithGreaterPrice() throws IOException {
        p.getSection3().getCourseWithMorePrice(30);
    }

    @Test(groups = {"smoke","regression"})
    public void hideAndShowElement() throws IOException, InterruptedException {
        p.getSection3().hideAndShow();
    }

    @Test
    public void matchSum() throws InterruptedException {
        p.getSection3().getSumAndMatch(2968);
    }

    @AfterClass(alwaysRun = true)
    public void ExitBrowser(){
        DriverFactory.getInstance().closeBrowser();
    }
}
