package com.RahulShetty.pages.componentspage;

import com.RahulShetty.pages.abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Section4 extends AbstractComponents {

    By Mousehover = By.xpath("//legend[.='Mouse Hover Example']");
     By mouseHoverbtn= By.xpath("//button[@id='mousehover']");
     By hoverelements = By.xpath("//button[@id='mousehover']/..//a");

    public Section4(WebDriver driver, By sectionelem) {
        super(driver, sectionelem);
    }


    public void mouseHoverAndPerformAction(String actiontoPerform) throws InterruptedException {
        scrollToElement(findElement(Mousehover));
        moveToElement(findElement(mouseHoverbtn));
       List<WebElement> elements =  findElements(hoverelements);
          for(WebElement element : elements){
              if(element.getText().equalsIgnoreCase(actiontoPerform)){
                  clickElementUsingJS(element);
                  break;
              }
          }
    }
}
