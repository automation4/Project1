package com.RahulShetty.pages.componentspage;

import com.RahulShetty.pages.abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Section5 extends AbstractComponents {
WebDriver driver;

    By frame1 = By.xpath("//iframe[@id='courses-iframe']");
    By childframe = By.xpath("(//ul[@class='navigation clearfix'])[1]//li[@routerlinkactive='current']");
    By main = By.xpath("//h1[.='Practice Page']");

    public Section5(WebDriver driver, By sectionelem) {
        super(driver, sectionelem);
        this.driver =driver;
    }


    public void switchToFrame(String sectiontoclick) throws InterruptedException {
        scrollToElement(findElement(frame1));
        try{
            driver.switchTo().frame("courses-iframe");
        }catch (StaleElementReferenceException se){
            driver.findElement(By.xpath("findElement(frame1"));
            driver.switchTo().frame("courses-iframe");
        }
        System.out.println(driver.findElement(By.xpath("(//ul[@class='navigation clearfix'])[1]//li//a[.='Home']")).getText());
        System.out.println("successfully go to child frame");
        driver.switchTo().defaultContent();
        System.out.println(findElement(main).getText());
        System.out.println("successfully back to main frame");
    }
}
