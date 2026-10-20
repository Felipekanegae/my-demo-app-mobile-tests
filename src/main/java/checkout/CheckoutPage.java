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

    private final By fullNamePaymentField = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/nameET");

    private final By cardNumberField = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/cardNumberET");

    private final By expirationField = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/expirationDateET");

    private final By securityCodeField = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/securityCodeET");

    private final By reviewOrderButton = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/paymentBtn");

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

    private final By placeOrderButton = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/paymentBtn");

    private final By addressErrorMessage = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/address1ErrorTV");

    private final By paymentErrorMessage = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/expirationDateErrorTV");

    private final By thankYouMessage = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/thankYouTV");


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

    public void payment() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        fillPaymentForm();
        wait.until(ExpectedConditions.elementToBeClickable(reviewOrderButton)).click();
    }

    public void placeOrder() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    //===FORM FILLING===
    private void fillCheckoutForm() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameField)).sendKeys(
                testData.getStringOf("FULL_NAME"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressFieldOne)).sendKeys(
                testData.getStringOf("ADDRESS"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityField)).sendKeys(
                testData.getStringOf("CITY"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeField)).sendKeys(
                testData.getStringOf("ZIPCODE"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryField)).sendKeys(
                testData.getStringOf("COUNTRY"));
    }

    private void fillPaymentForm() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNamePaymentField)).sendKeys(
                testData.getStringOf("FULL_NAME"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberField)).sendKeys(
                testData.getStringOf("CARD_NUMBER"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(expirationField)).sendKeys(
                testData.getStringOf("EXPIRATION_DATE"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(securityCodeField)).sendKeys(
                testData.getStringOf("SECURITY_CODE"));

    }

    //===VALIDATIONS===

    public void validateAddressError(String message) {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(addressErrorMessage));
        String errorMessage = driver.findElement(addressErrorMessage).getText();
        assertThat(errorMessage).isEqualTo(message);

    }

    public void validatePaymentError(String message) {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentErrorMessage));
        String errorMessage = driver.findElement(paymentErrorMessage).getText();
        assertThat(errorMessage).isEqualTo(message);

    }

    public void validateThankYouMessage(String message) {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouMessage));
        String thanksMessage = driver.findElement(thankYouMessage).getText();
        assertThat(thanksMessage).isEqualTo(message);
    }

}
