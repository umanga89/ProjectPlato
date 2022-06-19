package TestRunner;

import Util.BaseUtil;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features = {"src/test/java/Features"},
                glue = {"Steps","Util"},
                plugin = {"pretty","html:target/cucumber-report.html", "json:target/cucumber.json"})
public class TestNGRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setupBrowser(){
        System.out.println("Before Method print");
        BaseUtil.browser = "chrome";
    }
}
