package cart;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import products.ProductsPage;
import login.LoginPage;

public class CartSteps {

    private final DriverManager driverManager;
    private CartPage cart;
    private ProductsPage products;
    private LoginPage login;


    public CartSteps(DriverManager driverManager,
                     CartPage cart,
                     ProductsPage products,
                     LoginPage login) {
        this.driverManager = driverManager;
        this.cart = cart;
        this.products = products;
        this.login = login;
    }

    @Given("I am on the products page")
    public void i_am_on_the_products_page() {
        products.openProductPage();

    }

    @When("I add a product to the cart")
    public void i_add_a_product_to_the_cart() {
        cart.addProduct();

    }

    @Then("the product should be in the cart")
    public void the_product_should_be_in_the_cart() {
        cart.openCart();
        cart.validateProductsOnCartPage();

    }
}