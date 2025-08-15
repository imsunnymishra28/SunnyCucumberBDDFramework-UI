package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SerachCustomerPage extends BaseClass {
//    WebDriver driver;

    public SerachCustomerPage(WebDriver driver) {
        BaseClass.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]")
    WebElement EmployeeId;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchBtn;

    @FindBy(xpath = "//div[@role='table']")
    WebElement table;

    @FindBy(xpath = "//div[@class='oxd-table-body']/div")
    List<WebElement> tableRows;

    @FindBy(xpath = "//div[@class='oxd-table-row oxd-table-row--with-border']/div")
    List<WebElement> tableColumns;

    public void serachEmployeeId(String serachEmpid) {
        EmployeeId.sendKeys(serachEmpid);
    }

    public void clickOnSerachBtn() {
        searchBtn.click();
    }

    public boolean searchCustomerById(String id) {
        boolean found = false;

        //total number of rows;
        int trows = tableRows.size();


        for (int i = 1; i <= trows; i++) // to iterate all the rows of grid
        {
            WebElement webElementId = driver.findElement(By.xpath("//div[@class='oxd-table-body']/div/div/div[2]"));
            String actId = webElementId.getText();
            if (actId.contains(id)) {
                found = true;
            }

        }

        return found;


    }
}
