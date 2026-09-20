package cart;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CartPage {

    private final AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        this.driver = driver;

    }

    private final By cartButton = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV");

    public void openCart() {
        driver.findElement(cartButton).click();

    }


}