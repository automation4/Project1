package com.RahulShetty.pages.componentspage;

import com.RahulShetty.pages.abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Section3 extends AbstractComponents {
    By tablesection = By.xpath("(//table[@id='product']/..)[1]//tr");
    By elementdisplaydexample = By.xpath("//legend[.='Element Displayed Example']");
    By hidbutton = By.xpath("//legend[.='Element Displayed Example']/following-sibling::input[1]");
    By showbutton = By.xpath("//legend[.='Element Displayed Example']/following-sibling::input[2]");
    By elementtocheck = By.xpath("//legend[.='Element Displayed Example']/following-sibling::input[3]");
    By tablesection2 = By.xpath("//legend[.='Web Table Fixed header']");
    By tablesection2rows = By.xpath("(//legend[.='Web Table Fixed header']//following-sibling::div)[1]//tr");

    WebDriver driver;

    public Section3(WebDriver driver, By sectionelem) {
        super(driver, sectionelem);
        this.driver = driver;
    }

    public void getCourseWithPrice(int price) {
        int count = 0;
        List<WebElement> elements = findElements(tablesection);
        for (int i = 2; i <= elements.size(); i++) {
            WebElement row = driver.findElement(By.xpath("(//table[@id='product']/..)[1]//tr[" + i + "]"));
            if (Integer.parseInt(row.findElement(By.xpath("(//table[@id='product']/..)[1]//tr[" + i + "]/td[3]")).getText()) == price) {
                String coursename = row.findElement(By.xpath("(//table[@id='product']/..)[1]//tr[" + i + "]/td[2]")).getText();
                System.out.println("Course ->" + coursename + " is matching with price >" + price);
                count = count + 1;
            }
        }
        if(count==0){
            System.out.println("No such cources available");
            return;
        }
        System.out.println("Total courses -> " + count);
    }

    public void getCourseWithMorePrice(int price) {
        int count = 0;
        List<WebElement> elements = findElements(tablesection);
            for (int i = 2; i <= elements.size(); i++) {
                WebElement row = driver.findElement(By.xpath("(//table[@id='product']/..)[1]//tr[" + i + "]"));
                if (Integer.parseInt(row.findElement(By.xpath("(//table[@id='product']/..)[1]//tr[" + i + "]/td[3]")).getText()) > price) {
                    String coursename = row.findElement(By.xpath("(//table[@id='product']/..)[1]//tr[" + i + "]/td[2]")).getText();
                    System.out.println("Course ->" + coursename + " has price :" + row.findElement(By.xpath("(//table[@id='product']/..)[1]//tr[" + i + "]/td[3]")).getText());
                    count = count + 1;
                }
            }
            if(count==0){
                System.out.println("No such cources available");
                return;
            }
            System.out.println("Total courses -> " + count);
    }

    public void hideAndShow() throws InterruptedException {
        scrollToElement(findElement(elementdisplaydexample));
        findElement(hidbutton).click();
        if(!findElement(elementtocheck).isDisplayed()){
            System.out.println("element successfully hidden");
        }
        findElement(showbutton).click();
        if(findElement(elementtocheck).isDisplayed()){
            System.out.println("element is back to visible mode");
        }
    }

    public void getSumAndMatch(Integer expected) throws InterruptedException {
        int totalsum = 0;
        scrollToElement(findElement(tablesection2));
        List<WebElement> elements = findElements(tablesection2rows);
        for (int i = 1; i <elements.size(); i++) {
            String actual = driver.findElement(By.xpath("(//legend[.='Web Table Fixed header']//following-sibling::div)[1]//tr["+i+"]/td[4]")).getText();
            totalsum = totalsum + Integer.parseInt(actual);
        }

        if (totalsum == expected) {
            System.out.println("Sum match since Total calculated ->"+totalsum +" and expected is ->" + expected);

        }
else{
    Assert.fail("Sum doesn't match since Total calculated ->"+totalsum +" and expected is ->" + expected);
     }
       }
      }
