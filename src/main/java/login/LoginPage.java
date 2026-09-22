package login;

import driver.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testData.ExcelTestData;


import java.time.Duration;

public class LoginPage {

    private final DriverManager driverManager;
    private final ExcelTestData testData;


    public LoginPage(DriverManager driverManager, ExcelTestData testData) {
        this.driverManager = driverManager;
        this.testData = testData;

    }

    // ===ELEMENTS===
    private final By menuButton = AppiumBy.id("com.saucelabs.mydemoapp.android:id/menuIV");
    private final By loginButton = AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginBtn");
    private final By menuLogin = AppiumBy.androidUIAutomator("new UiSelector().text(\"Log In\")");
    private final By menuLogOut = AppiumBy.androidUIAutomator("new UiSelector().text(\"Log Out\")");
    private final By userNameFiled = AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET");
    private final By passwordFiled = AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordET");

    //===ACTIONS===

    public void openLoginPage() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(menuLogin)).click();

    }

    public void login(){
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        fillUserCredentials();
        driver.findElement(loginButton).click();

    }



    //===FORM FILLING===
    private void fillUserCredentials() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(userNameFiled))).sendKeys(
                testData.getStringOf("USER_NAME"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(passwordFiled))).sendKeys(
                testData.getStringOf("PASSWORD"));

    }

    //===VALIDATIONS===
    public void validateSuccessfulLogin() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
        assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(menuLogOut)).isDisplayed()).isTrue();

    }

}




