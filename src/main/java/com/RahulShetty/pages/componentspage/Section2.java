package com.RahulShetty.pages.componentspage;

import com.RahulShetty.pages.abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Set;


public class Section2 extends AbstractComponents {
WebDriver driver;
    By wind = By.xpath("//button[@id='openwindow']");
    By childlement =By.xpath("//a[.='Courses']/../..");
    By openwindow = By.xpath("//a[@id='opentab']");
    By alert  = By.xpath("//input[@value='Alert']");
    By alerttextbox = By.xpath("//input[@id='name']");

    public Section2(WebDriver driver, By sectionelem) {
        super(driver, sectionelem);
        this.driver = driver;
    }

    public void switchBetweenWindows() {
        String mainhandel = driver.getWindowHandle();
        String childwindow = null;
        WebDriverWait w = new WebDriverWait(driver,10);
        findElement(wind).click();
       Set<String> allhandels = driver.getWindowHandles();
       for(String windowhandel : allhandels){
            if(!mainhandel.equals(windowhandel)){
                childwindow = windowhandel;
            }
        }
       driver.switchTo().window(childwindow);
        w.until(ExpectedConditions.visibilityOfElementLocated(childlement));
        System.out.println("Title = " + driver.getTitle());
        driver.switchTo().window(mainhandel);
            System.out.println("Title = " + driver.getTitle());
    }

    public void switchToTab(){
        System.out.println("Title = " + driver.getTitle());
        String oldtab = driver.getWindowHandle();
        findElement(openwindow).click();
        ArrayList tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1).toString());
        System.out.println(driver.getTitle());
        driver.switchTo().window(oldtab);
        System.out.println(tabs.size());
    }

    @Test
    public void AlertCheck(String text){
        String expected = "Hello "+text+", share this practice page and share your knowledge" ;
        findElement(alerttextbox).sendKeys(text);
      findElement(alert).click();
        System.out.println(driver.switchTo().alert().getText());
      String actual = driver.switchTo().alert().getText();
      driver.switchTo().alert().accept();
      Assert.assertEquals(actual,expected);
    }
}
