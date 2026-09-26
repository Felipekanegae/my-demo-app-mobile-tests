package products;

import driver.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testData.ExcelTestData;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;


public class ProductsPage {

    private final DriverManager driverManager;
    private final ExcelTestData testData;

    public ProductsPage(DriverManager driverManager, ExcelTestData testData) {
        this.driverManager = driverManager;
        this.testData = testData;

    }

    // ===ELEMENTS===

    private final By menuButton = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/menuIV");

    private final By catalogButton = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Catalog\")");

    private final By nameAscendingButton = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Name - Ascending\")");

    private final By nameDescendingButton = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Name - Descending\")");

    private final By priceAscendingButton = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Price - Ascending\")");

    private final By priceDescendingButton = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Price - Descending\")");

    private final By sortButton = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/sortIV");

    private final By productsLabel = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/productTV");

    private final By sortBox = AppiumBy.id(
            "new UiSelector().className(\"android.view.ViewGroup\").instance(0)");

    private final By tickNameAscending = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/tickNameAscIV");

    private final By tickNameDescending = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/tickNameDesIV");

    private final By tickPriceAscending = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/tickPriceAscIV");

    private final By tickPriceDescending = AppiumBy.id(
            "com.saucelabs.mydemoapp.android:id/tickPriceDscIV");


    //===ACTIONS===
    public void openCatalog() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(catalogButton)).click();

    }

    public void sortProducts() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(sortButton)).click();
        sortByProducts();

    }

    private void sortByProducts() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String sort = testData.getStringOf("SORT");

        switch (sort) {
            case "NAME_ASCENDING":
                wait.until(ExpectedConditions.elementToBeClickable(
                        nameAscendingButton)).click();
                break;

            case "NAME_DESCENDING":
                wait.until(ExpectedConditions.elementToBeClickable(
                        nameDescendingButton)).click();
                break;

            case "PRICE_ASCENDING":
                wait.until(ExpectedConditions.elementToBeClickable(
                        priceAscendingButton)).click();
                break;

            case "PRICE_DESCENDING":
                wait.until(ExpectedConditions.elementToBeClickable(
                        priceDescendingButton)).click();
                break;

            default:
                throw new IllegalArgumentException("Invalid sort option: " + sort);

        }

    }

    //===VALIDATIONS===

    public void validateProductsPage() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                productsLabel)).isDisplayed()).isTrue();

    }

    public void validateSortIsSelected() {
        AndroidDriver driver = driverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String sort = testData.getStringOf("SORT");

        wait.until(ExpectedConditions.elementToBeClickable(sortButton)).click();

        switch (sort) {
            case "NAME_ASCENDING":
                assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                        tickNameAscending)).isDisplayed()).isTrue();
                break;

            case "NAME_DESCENDING":
                assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                        tickNameDescending)).isDisplayed()).isTrue();
                break;

            case "PRICE_ASCENDING":
                assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                        tickPriceAscending)).isDisplayed()).isTrue();
                break;

            case "PRICE_DESCENDING":
                assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                        tickPriceDescending)).isDisplayed()).isTrue();
                break;

            default:
                throw new IllegalArgumentException("Invalid sort option: " + sort);

        }
    }

}
