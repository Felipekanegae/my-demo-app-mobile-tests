package hooks;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

public class Hooks {

    private final DriverManager driverManager;

    public Hooks(DriverManager driverManager) {
        this.driverManager = driverManager;

    }

    @Before
    public void beforeScenario() throws MalformedURLException {
        driverManager.selectDevice();

    }

    @After
    public void afterScenario() {
        driverManager.quitDriver();

    }
}