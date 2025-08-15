package StepDefinitions;


//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

 //@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features/customer.feature","src/test/resources/Features/login.feature"},
//        features = "src/test/resources/Features/",
        glue = {"StepDefinitions"},
        monochrome = true,
        tags="@Sanity", // Scenarios under @Sanity tag will only execute
//        tags="@Sanity and @regression", // Scenarios under @Sanity tag will only execute
//        tags="@Sanity or @regression", // Scenarios under @Sanity tag will only execute
//        tags="@Sanity and not @regression", // Scenarios under @Sanity tag will only execute
        dryRun = false,
//        plugin = {"pretty","html:target/cucumber-reports/reports1.html"}
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//        plugin = {"pretty","junit:target/cucumber-reports/reports_xml.xml"}
//        plugin = {"pretty","json:target/cucumber-reports/reports_json.json"}

)
public class TestRunner extends AbstractTestNGCucumberTests {
    //This class will empty
}
