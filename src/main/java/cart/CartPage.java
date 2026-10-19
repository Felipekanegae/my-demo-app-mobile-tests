package cart;

import driver.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testData.ExcelTestData;

import java.math.BigDecimal;
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

    private final By plusButton = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/plusIV");

    private final By quantityProduct = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/noTV");

    private final By removeButton = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/removeBt");

    private final By productLabel = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/titleTV");

    private final By productPrice = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/priceTV");

    private final By totalItems = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/itemsTV");

    private final By totalPrice = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/totalPriceTV");

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

    public void plusProduct() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        int expectedQuantity = Integer.parseInt(
                testData.getStringOf("PRODUCT_QUANTITY"));

        int currentQuantity = Integer.parseInt(
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        quantityProduct)).getText());

        while (currentQuantity < expectedQuantity) {
            wait.until(ExpectedConditions.elementToBeClickable(plusButton)).click();

            int previousQuantity = currentQuantity;

            currentQuantity = Integer.parseInt(
                    wait.until(ExpectedConditions.textToBePresentInElementLocated(
                            quantityProduct, String.valueOf(previousQuantity + 1)))
                            ? driver.findElement(quantityProduct).getText()
                            : "0");
        }

        assertThat(currentQuantity).isEqualTo(expectedQuantity);
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

    public void validateQuantityOnCartPage() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(quantityProduct)).isDisplayed();

        String quantity = driver.findElement(quantityProduct).getText();
        assertThat(quantity).isEqualTo(testData.getStringOf("PRODUCT_QUANTITY"));
    }

    public void validateTotalPriceOnCartPage() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String valueText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(productPrice)).getText();

        String totalText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(totalPrice)).getText();

        String quantityText = testData.getStringOf("PRODUCT_QUANTITY");

        String cleanValue = valueText.replaceAll("[^0-9,.]", "").replace(",", ".");
        String cleanTotal = totalText.replaceAll("[^0-9,.]", "").replace(",", ".");

        BigDecimal price = new BigDecimal(cleanValue);
        BigDecimal quantity = new BigDecimal(quantityText.trim());
        BigDecimal expectedTotal = price.multiply(quantity);

        BigDecimal actualTotal = new BigDecimal(cleanTotal);

        assertThat(actualTotal).isEqualByComparingTo(expectedTotal);
    }
}