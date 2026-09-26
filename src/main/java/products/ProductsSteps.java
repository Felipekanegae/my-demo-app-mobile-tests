package products;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testData.ExcelTestData;

public class ProductsSteps {

    private ProductsPage products;

    public ProductsSteps(ProductsPage products) {
        this.products = products;

    }

    @Given("I am on the products page")
    public void i_am_on_the_products_page() {
        products.validateProductsPage();

    }

    @When("I sort the products by name - ascending")
    public void i_sort_the_products_by_name_ascending() {
        products.sortProducts();

    }

    @Then("the name ascending sort option should be selected")
    public void then_the_name_ascending_sort_option_should_be_selected() {
        products.validateSortIsSelected();

    }

    @When("I sort the products by name - descending")
    public void i_sort_the_products_by_name_descending() {
        products.sortProducts();
    }

    @Then("the name descending sort option should be selected")
    public void the_name_descending_sort_option_should_be_selected() {
        products.validateSortIsSelected();

    }

}
