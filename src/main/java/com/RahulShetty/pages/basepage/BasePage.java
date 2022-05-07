package com.RahulShetty.pages.basepage;

import Utilities.Utils;
import com.RahulShetty.pages.componentspage.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BasePage {

    WebDriver driver;
    private By section1 = By.xpath(Utils.getLocator("section1"));
    private By section2 = By.xpath(Utils.getLocator("section2"));
    private By section3 = By.xpath(Utils.getLocator("section3"));
    private By section4 = By.xpath(Utils.getLocator("section4"));
    private By section5 = By.xpath(Utils.getLocator("section5"));


    public BasePage(WebDriver driver) throws IOException {
        this.driver = driver;
    }
    public Section1 getSection1(){ return new Section1(driver,section1);}
    public Section2 getSection2(){ return new Section2(driver,section2);}
    public Section3 getSection3(){
        return new Section3(driver,section3);
    }
    public Section4 getSection4(){
        return new Section4(driver,section4);
    }
    public Section5 getSection5(){
        return new Section5(driver,section5);
    }
    public Section6 getSection6(){
        return new Section6(driver,section5);
    }

}
