package login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testData.ExcelTestData;

public class LoginSteps {

    private final ExcelTestData testData;

    private LoginPage login;

    public LoginSteps(LoginPage login,
                      ExcelTestData testData) {

        this.testData = testData;
        this.login = login;

    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        login.openLoginPage();

    }

    @When("I login with email and password")
    public void i_login_with_email_and_password() {
        login.login();

    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        login.validateSuccessfulLogin();

    }

    @When("I login without email and password")
    public void i_login_without_email_and_password() {
        login.login();

    }

    @Then("the message {string} should be displayed")
    public void the_message_should_be_displayed(String message) {
        login.validateUserNameError(message);

    }

}