package com.RahulShetty.tests;

import Utilities.Utils;
import com.RahulShetty.base.BrowserType;
import com.RahulShetty.base.DriverFactory;
import Utilities.TestListeners;
import com.RahulShetty.pages.basepage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners(TestListeners.class)
public class RahulShettySection1Test {
    private BasePage p;
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initializeDriver() throws IOException {
        String browserName= System.getProperty("browser");
        DriverFactory.getInstance().createBrowser(browserName);
        driver = DriverFactory.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(6 ,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebDriverWait w = new WebDriverWait(driver,6);
       // w.until(ExpectedConditions.visibilityOfElementLocated("Loj"));
        driver.get(Utils.getTestData("url"));
        p = new BasePage(driver);
    }

    @Test(groups = "regression")
    public void goTORahulShettySection5() throws IOException, InterruptedException {
        p.getSection1().selectRadio("radio1");
        Thread.sleep(3000);
    }

    @Test(groups = {"regression"})
    public void clickChekbox() throws IOException {
        p.getSection1().selectCheckbox("option2");
    }

    @Test(groups = "regression")
    public void autoSuggestion(){
        p.getSection1().selectAutocomplete("ind");
    }

    @Test(groups = {"regression", "smoke"})
    public void selectDropdown(){
        p.getSection1().selectFromDropdown("option1");
    }


    @AfterClass(alwaysRun = true)
    public void ExitBrowser(){
        DriverFactory.getInstance().closeBrowser();
    }
}
