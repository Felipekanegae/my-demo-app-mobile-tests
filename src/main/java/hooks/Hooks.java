package hooks;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testData.ExcelTestData;

import java.net.MalformedURLException;

public class Hooks {

    private final DriverManager driverManager;
    private final ExcelTestData testData;

    public Hooks(DriverManager driverManager, ExcelTestData testData) {
        this.driverManager = driverManager;
        this.testData = testData;
    }

    @Before
    public void beforeScenario(Scenario scenario) throws MalformedURLException {

        String ct = scenario.getSourceTagNames()
                .stream()
                .filter(tag -> tag.startsWith("@CT"))
                .findFirst()
                .orElse("@CT1")
                .replace("@CT", "");

        System.out.println("[TEST] Tags do cenário: " + scenario.getSourceTagNames());
        System.out.println("[TEST] CT usado: " + ct);

        driverManager.selectDevice();

        testData.loadTestData(
                "src/test/resources/testData/testData.xlsx",
                "testData", ct);

    }

    @After
    public void afterScenario() {

        driverManager.quitDriver();
    }
}