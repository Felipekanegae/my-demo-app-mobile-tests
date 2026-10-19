package checkout;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import products.ProductsPage;
import login.LoginPage;
import cart.CartPage;

public class CheckoutSteps {

    private final CheckoutPage checkout;
    private final CartPage cart;
    private final LoginPage login;
    private final ProductsPage products;

    public CheckoutSteps(CheckoutPage checkout,
                         CartPage cart,
                         LoginPage login,
                         ProductsPage products) {
        this.checkout = checkout;
        this.cart = cart;
        this.login = login;
        this.products = products;

    }

    @Given("I am on the checkout page")
    public void i_am_on_the_checkout_page() {
        products.openProductPage();
        cart.addProduct();
        cart.openCart();
        checkout.proceedToCheckout();
        login.login();
    }

    @When("I try to continue without entering an address")
    public void i_try_to_continue_without_entering_an_address() {
        checkout.checkout();

    }

    @Then("the message {string} should be displayed on the checkout page")
    public void the_message_should_be_displayed_on_the_checkout_page(String message) {
        checkout.validateAddressError(message);
    }

}
