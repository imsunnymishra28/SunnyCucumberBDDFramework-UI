package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
//    WebDriver driver;

    public LoginPage(WebDriver driver){
        BaseClass.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="username")
    WebElement userName;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//button[normalize-space()='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButton;

    @FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    WebElement userDropdown;

    public void enterUserName(String user){

        userName.sendKeys(user);
    }

    public void enterPassword(String pwd){
        password.sendKeys(pwd);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void clickOnLogoutButton(){
        logoutButton.click();
    }

    public void clickOnUserDropdown(){
        userDropdown.click();
    }

}
