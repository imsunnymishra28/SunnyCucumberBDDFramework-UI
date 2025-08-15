package PageObject;

//Parent class

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static Logger logger;
    public static WebDriver driver;
    public static LoginPage loginPg;
    public static AddNewCustomerPage addNewCustomerPage;
    public static SerachCustomerPage serachCustomerPage;
    public static ConfigReader readConfig;


    public void initializeBrowser() throws Exception {
        logger = LogManager.getLogger(BaseClass.class);
        readConfig = new ConfigReader();
        String browser = readConfig.getBrowser();

        // 2️⃣ Then, start the browser
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "msedge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


}
