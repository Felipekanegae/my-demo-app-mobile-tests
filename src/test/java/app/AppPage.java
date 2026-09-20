package app;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppPage {

    private final AndroidDriver driver;

    public AppPage(AndroidDriver driver) {
        this.driver = driver;

    }

    private final By cartButton = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV");

    public void openCart() {
        driver.findElement(cartButton).click();

    }


}