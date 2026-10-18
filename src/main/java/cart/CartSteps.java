package cart;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import products.ProductsPage;
import login.LoginPage;

public class CartSteps {

    private CartPage cart;
    private ProductsPage products;
    private LoginPage login;


    public CartSteps(CartPage cart,
                     ProductsPage products,
                     LoginPage login) {
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
        products.selectProductColor();
        cart.addProduct();

    }

    @Then("the product should be in the cart")
    public void the_product_should_be_in_the_cart() {
        cart.openCart();
        cart.validateProductOnCartPage();

    }

    @Then("the product color should be displayed in the cart")
    public void the_product_color_should_be_displayed_in_the_cart() {
        cart.openCart();
        cart.validateProductColorOnCartPage();

    }

    @Given("I am on the cart page")
    public void i_am_on_the_cart_page() {
        products.openProductPage();
        cart.addProduct();
        cart.openCart();
    }

    @When("I remove a product from the cart")
    public void i_remove_a_product_from_the_cart() {
        cart.removeProduct();
    }

    @Then("the product should be removed from the cart")
    public void the_product_should_be_removed_from_the_cart() {
        cart.validateCartEmpty();
    }

    @Given("I have added multiple units of a product to the cart")
    public void i_have_added_multiple_units_of_a_product_to_the_cart() {
        products.openProductPage();
        cart.plusProduct();
        cart.addProduct();
    }

    @When("I open the cart page")
    public void i_open_the_cart_page() {
        cart.openCart();
    }

    @Then("the total should be displayed correctly")
    public void the_total_should_be_displayed_correctly() {
        cart.validateQuantityOnCartPage();
        cart.validateTotalPriceOnCartPage();
    }
}