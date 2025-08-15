package StepDefinitions;

import PageObject.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginSteps extends BaseClass {

    @Given("User Launch the chrome browser")
    public void user_launch_the_chrome_browser() {
        logger.info("user launch chrome browser");

    }

    @When("user opens URL  {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        logger.info("Navigating to login page...");
    }

    @When("user enters Username as {string} and Password as {string}")
    public void user_enters_username_as_and_password_as_admin(String userName, String password) {
        loginPg.enterUserName(userName);
        loginPg.enterPassword(password);
        logger.info("email and password entered");
    }

    @When("Click on Login")
    public void click_on_login() {
        loginPg.clickOnLoginButton();
        logger.info("login button clicked");

    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String ExpectedPageTitle) {
        String actTitle = driver.getTitle();
        if (actTitle.equals(ExpectedPageTitle)) {
            Assert.assertTrue(true); //pass
            logger.warn("Test passed:page title matched");
        } else {
            Assert.assertTrue(false); //fail
            logger.warn("Test failed:page title does not  matched");
        }
    }

    @Then("I click on the dropdown for logout")
    public void i_clik_On_The_Dropdown_For_Logout() {
        loginPg.clickOnUserDropdown();
        logger.info("clicked on logout dropdown");
    }


    @When("User click on logout link")
    public void user_click_on_logout_link() {

        loginPg.clickOnLogoutButton();
    }


    @Then("close browser")
    public void close_browser() {
        driver.close();
        driver.quit();
    }

    // Add new customer
    @Given("User can view dashboard")
    public void user_can_view_dashboard() {
        String actTitle = addNewCustomerPage.getPageTitle();
        String expTitle = "OrangeHRM";
        if (actTitle.equals(expTitle)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }


    @When("User click on PIM button fro the menu")
    public void user_click_on_pim_button_fro_the_menu() {
        addNewCustomerPage.clickOnPIM();
    }

    @When("User click on Add button")
    public void user_click_on_add_button() {
        addNewCustomerPage.clickOnAddBtn();
    }

    @When("User enter the customer info")
    public void user_enter_the_customer_info() {
        addNewCustomerPage.enterFirstName("Sunny");
        addNewCustomerPage.enterMiddleName("Kumar");
        addNewCustomerPage.enterLastName("Mishra");
        addNewCustomerPage.enterEmployeeid("0452");
    }

    @Then("User click on save button")
    public void user_click_on_save_button() {
        addNewCustomerPage.clickOnSaveBtn();

    }

    //Search customer
    @When("User enter the employee id")
    public void user_enter_the_employee_id() {
        serachCustomerPage.serachEmployeeId("0312");
    }

    @When("click on serach button")
    public void click_on_serach_button() {
        serachCustomerPage.clickOnSerachBtn();

    }

    @Then("User should found employee details in the search table")
    public void user_should_found_employee_details_in_the_search_table() {
        String expectedId = "0312";
        boolean actId = serachCustomerPage.searchCustomerById(expectedId);
        if (actId == true) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

    }

//    @BeforeStep
//    public void beforeStepDemo(){
//        System.out.println("this is before step");
//    }
//
//    @AfterStep
//    public void afterStepDemo(){
//        System.out.println("this is after step");
//    }
}