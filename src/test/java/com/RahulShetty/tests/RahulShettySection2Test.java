package com.RahulShetty.tests;

import Utilities.Utils;
import com.RahulShetty.base.BrowserType;
import com.RahulShetty.base.DriverFactory;
import Utilities.TestListeners;
import com.RahulShetty.pages.basepage.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(TestListeners.class)
public class RahulShettySection2Test {
    public WebDriver driver;
    public BasePage p;


    @BeforeClass(alwaysRun = true)
    public void initializeDriver() throws IOException {
        String browserName= System.getProperty("browser");
        DriverFactory.getInstance().createBrowser(browserName);
        driver = DriverFactory.getInstance().getDriver();
        driver.get(Utils.getTestData("url"));
        p = new BasePage(driver);
    }
    @Test(groups = "regression")
    public void switchTOFrame() throws IOException {
        //p.getSection2().switchBetweenWindows();
    }

    @Test(groups = "regression")
    public void switchTOTabs() throws IOException {
        p.getSection2().switchToTab();
    }

    @Test(groups = "regression")
    public void switchTOAlert() throws IOException {
        p.getSection2().AlertCheck("Test");
    }

    @AfterClass(alwaysRun = true)
    public void ExitBrowser(){
        DriverFactory.getInstance().closeBrowser();
    }
}
