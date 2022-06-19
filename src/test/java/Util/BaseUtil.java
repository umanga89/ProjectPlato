package Util;

import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class BaseUtil {

    public WebDriver driver;
    public static String webUrl;
    public static String browser;
    public static String base_directory;
    public static Logger logger;
    public static Properties configProperties;
    public Scenario message;

    public void takeScreenShot(WebDriver driver,String label) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        message.attach(screenshot, "image/png",label);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver() throws Exception {
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", BaseUtil.base_directory + BaseUtil.configProperties.getProperty("chrome.driver.path"));
            ChromeOptions cOptions = new ChromeOptions();
            cOptions.addArguments("--ignore-certificate-errors");
            this.driver = new ChromeDriver(cOptions);
        }else {
            throw new Exception("Please check browser value");
        }
    }
}
