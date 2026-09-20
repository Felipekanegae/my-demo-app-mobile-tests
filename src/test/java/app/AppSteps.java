package app;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AppSteps {

    private final DriverManager driverManager;

    public AppSteps(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Given("the application is open")
    public void theApplicationIsOpen() {

    }

    @When("I open the cart")
    public void iOpenTheCart() {
        AppPage appPage = new AppPage(driverManager.getDriver());
        appPage.openCart();
    }

}