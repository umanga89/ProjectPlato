package Util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseUtil{

    private BaseUtil base;
    public Hooks(BaseUtil base){
        this.base = base;
    }

    //@Parameters({"browser"})
    @Before
    public void setup(Scenario scenario) throws Exception {
        try {
            BaseUtil.webUrl = BaseUtil.configProperties.getProperty("web.url");

            //Navigating to URL
            this.base.setDriver();
            this.base.driver.get(BaseUtil.webUrl);

            base.message = scenario;
        } catch (Exception e) {
            throw e;
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                this.base.takeScreenShot(this.base.driver, scenario.getName());
            } catch (Exception e) {
throw e;
            }
        }
        base.driver.quit();
    }
}
