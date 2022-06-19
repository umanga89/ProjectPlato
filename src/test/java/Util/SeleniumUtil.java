package Util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtil {
    public static boolean WaitForElementToBeDisplayed(WebDriver driver, WebElement element, int seconds)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver,seconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch(NoSuchElementException ex)
        {
            throw ex;
        }
    }
}
