package cart;

import driver.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import products.ProductsPage;
import testData.ExcelTestData;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage {

    private final DriverManager driverManager;
    private final ExcelTestData testData;

    public CartPage(DriverManager driverManager,
                    ExcelTestData testData) {
        this.driverManager = driverManager;
        this.testData = testData;
    }

    // ===ELEMENTS===

    private final By cartButton = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/cartIV");

    private final By addButton = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/cartBt");

    private final By removeButton = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/removeBt");

    private final By productLabel = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/titleTV");

    private final By productColor = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/colorIV");

    private final By cartNoItemsMessage = AppiumBy.androidUIAutomator(
            "new UiSelector().text(" +
                    "\"Oh no! Your cart is empty. Fill it up with swag to complete your purchase.\")");


    //===ACTIONS===
    public void addProduct() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

    }

    public void removeProduct() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();

    }

    public void openCart() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
    }

    //===VALIDATIONS===
    public void validateProductOnCartPage() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(productLabel));
        String productName = driver.findElement(productLabel).getText();
        assertThat(productName).isEqualTo(testData.getStringOf("PRODUCT_NAME"));

    }

    public void validateProductColorOnCartPage() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                productColor)).isDisplayed()).isTrue();

    }

    public void validateCartEmpty() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                cartNoItemsMessage)).isDisplayed()).isTrue();
    }
}