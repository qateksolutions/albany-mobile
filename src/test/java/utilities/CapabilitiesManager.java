package utilities;

import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class CapabilitiesManager {
    private static final Logger LOGGER = LogManager.getLogger(CapabilitiesManager.class);

    public DesiredCapabilities getCaps() {
        String deviceName = ReadConfigFiles.getPropertyValues("deviceName");
        String udId = ReadConfigFiles.getPropertyValues("udId");
        String androidAutomationName = ReadConfigFiles.getPropertyValues("androidAutomationName");
        String appPackage = ReadConfigFiles.getPropertyValues("androidAppPackage");
        String appActivity = ReadConfigFiles.getPropertyValues("androidAppActivity");
        String appName = ReadConfigFiles.getPropertyValues("androidAppName");
        String appPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "apps" + File.separator + appName;
        LOGGER.debug("App location is: " + appPath);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.UDID, udId);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, androidAutomationName);
        //capabilities.setCapability(MobileCapabilityType.APP, appPath);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);

        return capabilities;
    }
}
