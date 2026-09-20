package cart;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CartSteps {

    private final DriverManager driverManager;

    public CartSteps(DriverManager driverManager) {
        this.driverManager = driverManager;

    }

    @Given("the application is open")
    public void theApplicationIsOpen() {

    }

    @When("I open the cart")
    public void iOpenTheCart() {
        CartPage cartPage = new CartPage(driverManager.getDriver());
        cartPage.openCart();

    }

}