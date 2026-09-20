package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private AndroidDriver driver;

    UiAutomator2Options options = new UiAutomator2Options();

    public void selectDevice() throws MalformedURLException {
        options.setUdid("emulator-5554");
        options.setAppPackage("com.saucelabs.mydemoapp.android");
        options.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

    }

    public AndroidDriver getDriver() {
        return driver;

    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
