package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage extends BaseClass {

//    WebDriver driver;

    public AddNewCustomerPage(WebDriver driver) {
        BaseClass.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//span[normalize-space()='PIM']")
    WebElement pim;

    @FindBy(name = "firstName")
    WebElement firstname;

    @FindBy(name = "middleName")
    WebElement MiddleName;

    @FindBy(name = "lastName")
    WebElement LastName;


    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement EmployeeId;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveBtn;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addBtn;


    public void clickOnPIM() {
        pim.click();
    }

    public void clickOnAddBtn() {
        addBtn.click();
    }

    public void enterFirstName(String fname) {
        firstname.sendKeys(fname);
    }

    public void enterMiddleName(String mName) {
        MiddleName.sendKeys(mName);
    }

    public void enterLastName(String lName) {
        LastName.sendKeys(lName);

    }

    public void enterEmployeeid(String empid) {
        EmployeeId.clear();
        EmployeeId.sendKeys(empid);
    }

    public void clickOnSaveBtn() {
        saveBtn.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
