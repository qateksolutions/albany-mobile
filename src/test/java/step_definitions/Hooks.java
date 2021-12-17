package step_definitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.DriverFactory;

import java.util.concurrent.TimeUnit;

public class Hooks {
    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);    
    static AppiumDriver driver;

    @Before
    public void initialize(Scenario scenario) {
        LOGGER.info(String.format("------Scenario: %s--------", scenario.getName()));
        driver = DriverFactory.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void cleanup() {
        DriverFactory.getInstance().removeDriver();
    }
}
