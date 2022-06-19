package Steps;

import PageObjects.LandingPage;
import Util.BaseUtil;
import Util.PropertiesUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LandingPageSteps extends BaseUtil {

    private BaseUtil base;
    LandingPage landingPage;

    public LandingPageSteps(BaseUtil base){
this.base = base;
landingPage = new LandingPage(this.base.driver);
    }
    @Given("user is in landing page")
    public void user_is_in_landing_page() throws Exception {
        try{
            Assert.assertTrue(landingPage.isUserInLandingPage(this.base.driver),"User is not in landing page");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @When("user clicks on page {string}")
    public void user_clicks_on_each(String pageName) throws Exception {
        try{
            switch (pageName){
                case "Introduction": landingPage.click_link_introduction();
                break;
                case "Didcomm": landingPage.click_link_didcomm();
                break;
                case "Self Sovereign Identity": landingPage.click_link_self_sovereign_identity();
                    break;
                default: throw new Exception("cannot find given page name");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Then("user should be navigated to page and see {string} and {string} for {string}")
    public void user_should_be_navigated_to_each_page_and_see_and(String pageTitle, String pageUrl, String pageName) throws Exception {
        try{
            switch (pageName){
                case "Introduction":
                    Assert.assertEquals(landingPage.getPageTitle(this.base.driver),pageTitle,"Page title mismatch!");
                    Assert.assertEquals(this.base.driver.getCurrentUrl(),pageUrl,"Url mismatch!");
                    break;
                case "Didcomm":
                    Assert.assertEquals(landingPage.getPageTitle(this.base.driver),pageTitle,"Page title mismatch!" );
                    Assert.assertEquals(this.base.driver.getCurrentUrl(),pageUrl,"Url mismatch!");
                    break;
                case "Self Sovereign Identity":
                    Assert.assertEquals(landingPage.getPageTitle(this.base.driver),pageTitle,"Page title mismatch!");
                    Assert.assertEquals(this.base.driver.getCurrentUrl(), pageUrl, "Url mismatch!");
                    break;
                default: throw new Exception("cannot find given page name");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @When("user search for {string} page and select it")
    public void user_search_for_page_and_select_it(String pageName) {
        try{
            landingPage.type_search_bar(pageName);
            Assert.assertEquals(1,landingPage.getSearchBarSuggestions(),"Found more than one suggestion");
            landingPage.click_first_search_bar_suggestion();
        }catch (Exception e){
            throw e;
        }
    }
    @Then("user is able to navigate to the page")
    public void user_is_able_to_navigate_to_the_page() {
        try{
            Assert.assertEquals(landingPage.getPageTitle(this.base.driver),"DIDComm Messaging","Page title mismatch!");
        }catch (Exception e){
            throw e;
        }
    }
}
