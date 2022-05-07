package com.RahulShetty.tests;

import Utilities.Utils;
import com.RahulShetty.base.BrowserType;
import com.RahulShetty.base.DriverFactory;
import Utilities.TestListeners;
import com.RahulShetty.pages.basepage.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(TestListeners.class)
public class RahulShettySection5Test {
    WebDriver driver;
    public BasePage p;

    @BeforeClass(alwaysRun = true)
    public void initializeDriver() throws IOException {
        //DriverFactory.getInstance().createBrowser(BrowserType.CHROME);
        String browserName= System.getProperty("browser");
        DriverFactory.getInstance().createBrowser(browserName);
        driver = DriverFactory.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.get(Utils.getTestData("url"));
        p = new BasePage(driver);
    }


    @Test(groups = {"smoke","regression"})
    public void workingWithIframes() throws IOException, InterruptedException {
     p.getSection5().switchToFrame("Job Support");
    }

    @AfterClass(alwaysRun = true)
    public void ExitBrowser(){
        DriverFactory.getInstance().closeBrowser();
    }
}
