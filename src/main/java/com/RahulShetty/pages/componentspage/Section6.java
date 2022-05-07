package com.RahulShetty.pages.componentspage;

import com.RahulShetty.pages.abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.List;

public class Section6 extends AbstractComponents {
WebDriver driver;

    By sections = By.xpath("//div[@id='gf-BIG']//tr/td");
    By allLinks = By.xpath("//div[@id='gf-BIG']//tr/td//a");
    By singlesection = By.xpath("//div[@id='gf-BIG']//tr/td[1]//a");

    public Section6(WebDriver driver, By sectionelem) {
        super(driver, sectionelem);
        this.driver =driver;}


    public void checkvalidlinks() throws InterruptedException, IOException {
        scrollToElement(driver.findElement(sections));
       List<WebElement> urls =  findElements(allLinks);
       checkURL(urls);

    }
    public void getLinkHeads() throws InterruptedException {
        scrollToElement(findElement(sections));
     List<WebElement> heads = findElements(sections);
        System.out.println("Total heads ->" + heads.size());
        for(int i=1;i<=heads.size();i++){
             System.out.println( i +" -> " +findElement(By.xpath("//div[@id='gf-BIG']//tr/td["+i+"]//a")).getText());
         }
    }

    public void getLinkheadsAndSublinks() throws InterruptedException {
        List<WebElement> heads = findElements(sections);
        for(int i =1;i<heads.size();i++){
            System.out.println("Head > "+ heads.get(i).findElement(By.xpath("//div[@id='gf-BIG']//tr/td["+i+"]//h3/a")).getText());
            List<WebElement> sublinks = heads.get(i).findElements(By.xpath("//div[@id='gf-BIG']//tr/td["+i+"]//a"));
            System.out.println("Contains following sublinks:");
            for(int j=1;j<sublinks.size();j++){
                System.out.println(sublinks.get(j).getText());
            }
        }
    }

    public void getsublinkCount(String expectedhead){
        List<WebElement> heads = findElements(sections);
        for(int i =1;i<heads.size();i++) {
            if (heads.get(i).findElement(By.xpath("//div[@id='gf-BIG']//tr/td[" + i + "]//h3/a")).getText().equalsIgnoreCase(expectedhead)) {
                List<WebElement> sublinks = heads.get(i).findElements(By.xpath("//div[@id='gf-BIG']//tr/td[" + i + "]//a"));
                System.out.println("Contains total sublinks:" + sublinks.size());
                for (int j = 1; j < sublinks.size(); j++) {
                    System.out.println(sublinks.get(j).getText());
                }
            }
        }
    }
}
