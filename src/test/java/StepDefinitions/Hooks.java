package StepDefinitions;

import PageObject.AddNewCustomerPage;
import PageObject.BaseClass;
import PageObject.LoginPage;
import PageObject.SerachCustomerPage;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Hooks extends BaseClass {
    @Before
    public void setup() throws Exception {
        initializeBrowser();
        loginPg = new LoginPage(driver);
        addNewCustomerPage = new AddNewCustomerPage(driver);
        serachCustomerPage = new SerachCustomerPage(driver);

    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {


            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}
