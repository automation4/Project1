package com.RahulShetty.pages.abstractcomponents;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class  AbstractComponents {
    static WebElement section;
    static WebDriver driver;

    public AbstractComponents(WebDriver driver, By sectionelem){
        section = driver.findElement(sectionelem);
        this.driver = driver;
    }

    public static WebElement findElement(By findelementby){

        return section.findElement(findelementby);
    }

    public static List<WebElement> findElements(By findelementby){
        return section.findElements(findelementby);
    }

    public static String takeScreenshot(String methodName) throws IOException {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String formattedDate = sdf.format(d);
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenshotpath = "\\screenshots\\"+methodName+formattedDate+".png";
        File destination = new File(screenshotpath);
        FileUtils.copyFile(source,destination);
        return screenshotpath;
    }

    public void scrollToElement(WebElement element) throws InterruptedException {
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true);",element);
       Thread.sleep(2000);
    }

    public void clickElementUsingJS(WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
        Thread.sleep(2000);
    }


    public void moveToElement(WebElement element) throws InterruptedException {
       Actions a = new Actions(driver);
       a.moveToElement(element).build().perform();
       a.doubleClick().build().perform();
        Thread.sleep(2000);

    }

    public void checkURL(List<WebElement> elements) throws IOException {
        List<String> urlstocheck = new ArrayList<>();

        for(WebElement element:elements){
            urlstocheck.add(element.getAttribute("href"));
        }

        int count =0;
        Map<String,Map<String ,Integer>> invalidurl = new HashMap<>();

        for(String urltocheck : urlstocheck){
            URL url = new URL(urltocheck);
            HttpURLConnection  httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            httpURLConnection.setConnectTimeout(50000);

            if(httpURLConnection.getResponseCode()==200){

            }
            else {
                 Map<String,Integer> submap = new HashMap<>();
                 submap.put(httpURLConnection.getResponseMessage(),httpURLConnection.getResponseCode());
                invalidurl.put(urltocheck,submap);
                count++;
            }
        }
        System.out.println("Total invalid links : "+count);

        for(Map.Entry map : invalidurl.entrySet()){
            System.out.println(map.getKey() + " is invalid due to mssage -> "+ map.getValue().toString().replace("{","").replace("}","").split("=")[0]
                    + " and code is->" + map.getValue().toString().replace("{","").replace("}","").split("=")[1]);
        }
    }

}
