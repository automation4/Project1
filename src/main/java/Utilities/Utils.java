
package Utilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class Utils{

    public static String getLocator(String key) throws IOException {
        FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\locator.properties");
        Properties prop = new Properties();
        prop.load(fis1);
        return prop.getProperty(key);
    }

    public static String getTestData(String key) throws IOException {
        FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\testdata.properties");
        Properties prop = new Properties();
        prop.load(fis2);
        return prop.getProperty(key);
    }

}

