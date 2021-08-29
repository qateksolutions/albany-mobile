package step_definitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.CapabilitiesManager;
import utilities.ReadConfigFiles;
import utilities.ServerManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hooks {
    static AppiumDriver driver;
    ServerManager serverManager = new ServerManager();

    @Before
    public void initialize() throws MalformedURLException {
        serverManager.startAppiumServer();

        CapabilitiesManager caps = new CapabilitiesManager();
        URL url = new URL(ReadConfigFiles.getPropertyValues("appiumURL"));
        driver = new AndroidDriver(url, caps.getCaps());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void cleanup() {
        if(driver != null) {
            driver.quit();
        }
        serverManager.stopAppiumServer();
    }
}
