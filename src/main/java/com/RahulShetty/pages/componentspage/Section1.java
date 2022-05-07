package com.RahulShetty.pages.componentspage;

import com.RahulShetty.pages.abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Section1 extends AbstractComponents {
     private By radios1 = By.xpath("//input[@name= 'radioButton']");
     private By checkboxes1 = By.xpath("//input[@type= 'checkbox']");
     private By autocompletetextbox = By.xpath("//input[@id='autocomplete']");
     private By suggestions = By.xpath("//ul[@id='ui-id-1']/li");
     private  By dropdown = By.xpath("//select[@id='dropdown-class-example']");

     public Section1(WebDriver driver, By sectionElement){
          super(driver,sectionElement);

     }

     public void selectRadio(String radio2select){
          List<WebElement> radios = findElements(radios1);
          for(WebElement element : radios){
               if(element.getAttribute("value").equalsIgnoreCase(radio2select)){
                    if(!element.isSelected()){
                         element.click();
                    }
               }
          }
     }
     public void selectCheckbox(String checkbox2select){
          List<WebElement> checkboxes = findElements(checkboxes1);
          for(WebElement element : checkboxes){
               if(element.getAttribute("value").equalsIgnoreCase(checkbox2select)){
                    if(!element.isSelected()){
                         element.click();
                    }
               }
          }
     }

     public void selectAutocomplete(String partialcountry){
          findElement(autocompletetextbox).sendKeys(partialcountry);
          List<WebElement> autosuggestions = findElements(suggestions);
          for(WebElement element : autosuggestions){
               if(element.getText().equalsIgnoreCase("India")){
                    {  element.click();}
               }
          }
     }
     public void selectFromDropdown(String optiontoselect){
          Select sel = new Select(findElement(dropdown));
          List<WebElement> options = sel.getOptions();
          for(WebElement option : options){
               if(option.getText().equalsIgnoreCase(optiontoselect)){
                    option.click();
               }
          }
     }
}
