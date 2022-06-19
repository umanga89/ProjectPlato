package PageObjects;

import Util.SeleniumUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage {

public WebDriver driver;

public LandingPage(WebDriver driver){
this.driver = driver;
    PageFactory.initElements(driver, this);
}

@FindBy(xpath = "(//div[contains(@class,'sidebar')]//a[contains(text(),'Introduction')])[1]")
@CacheLookup
    WebElement link_introduction;

@FindBy(xpath = "//article//main//h1")
WebElement title_each_page;

    @FindBy(xpath = "//h1[contains(text(),'Welcome to the Documentation')]")
    @CacheLookup
    WebElement title_introduction;

    @FindBy(xpath = "(//div[contains(@class,'sidebar')]//a[contains(text(),'Didcomm')])[1]")
    @CacheLookup
    WebElement link_didcomm;

    @FindBy(xpath = "//h1[contains(text(),'DIDComm Messaging')]")
    @CacheLookup
    WebElement title_didcomm;

    @FindBy(xpath = "(//div[contains(@class,'sidebar')]//a[contains(text(),'Self Sovereign Identity')])[1]")
    @CacheLookup
    WebElement link_self_sovereign_identity;

    @FindBy(xpath = "//h1[contains(text(),'Self-sovereign identity (SSI)')]")
    @CacheLookup
    WebElement title_self_sovereign_identity;

    @FindBy(xpath = "//nav//input[@type='search']")
    @CacheLookup
    WebElement textbox_searchBar;

    @FindBy(xpath = "//a[contains(@class,'block no-underline')]//li")
    @CacheLookup
    List<WebElement> label_search_criteria;

    public void click_link_introduction(){
        link_introduction.click();
    }

    public void click_link_didcomm(){
        link_didcomm.click();
    }

    public void click_link_self_sovereign_identity(){
        link_self_sovereign_identity.click();
    }

    public boolean isUserInLandingPage(WebDriver driver){
        if(SeleniumUtil.WaitForElementToBeDisplayed(driver,title_introduction, 10)) {
            return title_introduction.isDisplayed();
        }else{
            return false;
        }
    }

    public boolean isUserInDidcommPage(WebDriver driver){
        if(SeleniumUtil.WaitForElementToBeDisplayed(driver,title_didcomm, 10)) {
            return title_didcomm.isDisplayed();
        }else{
            return false;
        }
    }

    public boolean isUserInSelfSovereignIdentityPage(WebDriver driver){
        if(SeleniumUtil.WaitForElementToBeDisplayed(driver,title_didcomm, 10)) {
            return title_self_sovereign_identity.isDisplayed();
        }else{
            return false;
        }
    }

    public String getPageTitle(WebDriver driver){
        if(SeleniumUtil.WaitForElementToBeDisplayed(driver, title_each_page, 10)) {
            return title_each_page.getText();
        }else{
            return null;
        }
    }

    public void type_search_bar(String text){
        textbox_searchBar.sendKeys(text);
    }

    public int getSearchBarSuggestions(){
        return label_search_criteria.size();
    }

    public void click_first_search_bar_suggestion(){
        label_search_criteria.get(0).click();
    }

    public String getSearchBarSuggestion(){
        return label_search_criteria.get(0).getText();
    }
}
