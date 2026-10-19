package checkout;

import driver.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testData.ExcelTestData;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;


public class CheckoutPage {


    private final DriverManager driverManager;
    private final ExcelTestData testData;

    public CheckoutPage(DriverManager driverManager,
                        ExcelTestData testData) {
        this.driverManager = driverManager;
        this.testData = testData;

    }

    // ===ELEMENTS===

    private final By checkoutButton = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/cartBt");

    private final By fullNameField = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/fullNameET");

    private final By addressFieldOne = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/address1ET");

    private final By cityField = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/cityET");

    private final By zipCodeField = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/zipET");

    private final By countryField = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/countryET");

    private final By toPaymentButton = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/paymentBtn");

    private final By addressErrorMessage = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/address1ErrorTV");


    //===ACTIONS===

    public void proceedToCheckout() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public void checkout() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        fillCheckoutForm();
        wait.until(ExpectedConditions.elementToBeClickable(toPaymentButton)).click();
    }

    //===FORM FILLING===
    private void fillCheckoutForm() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(fullNameField))).sendKeys(
                testData.getStringOf("FULL_NAME"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addressFieldOne))).sendKeys(
                testData.getStringOf("ADDRESS"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(cityField))).sendKeys(
                testData.getStringOf("CITY"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(zipCodeField))).sendKeys(
                testData.getStringOf("ZIPCODE"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(countryField))).sendKeys(
                testData.getStringOf("COUNTRY"));
    }

    //===VALIDATIONS===

    public void validateAddressError(String message) {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addressErrorMessage)));
        String errorMessage = driver.findElement(addressErrorMessage).getText();
        assertThat(errorMessage).isEqualTo(message);

    }

}
