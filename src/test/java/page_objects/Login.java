package page_objects;

import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class Login {
    private static final Logger LOGGER = LogManager.getLogger(Login.class);

    private static final String UserNameLocator = "test-Username";
    private static final String PasswordLocator = "test-Password";
    private static final String LoginLocator = "test-LOGIN";
    private static final String ErrTxtLocator = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView";
    private static final String ProductsHeaderLocator = "//android.view.ViewGroup[@content-desc='test-Cart drop zone']/android.view.ViewGroup/android.widget.TextView";

    private AppiumDriver driver;

    public Login(AppiumDriver driver) {
        this.driver = driver;
    }

    public Login enterUserName(String value) {
        driver.findElementByAccessibilityId(UserNameLocator).clear();
        driver.findElementByAccessibilityId(UserNameLocator).sendKeys(value);
        LOGGER.debug("Entered user name is: " + value);
        return this;
    }

    public Login enterPassword(String value) {
        driver.findElementByAccessibilityId(PasswordLocator).clear();
        driver.findElementByAccessibilityId(PasswordLocator).sendKeys(value);
        LOGGER.debug("Entered password is: " + value);
        return this;
    }

    public Login clickOnLoginButton() {
        driver.findElementByAccessibilityId(LoginLocator).click();
        LOGGER.debug("Clicked on Login button");
        return this;
    }

    public Login unsuccessfulLoginError(String expectedErrorText) {
        String actualErrText = driver.findElementByXPath(ErrTxtLocator).getText();
        LOGGER.debug("Validating login attempt is unsuccessful using invalid credentials");
        Assert.assertEquals(expectedErrorText, actualErrText);
        return this;
    }

    public Login loginIsSuccessful(String expectedTitle) {
        String actualErrText = driver.findElementByXPath(ProductsHeaderLocator).getText();
        LOGGER.debug("Validating login is successful using valid credentials");
        Assert.assertEquals(expectedTitle, actualErrText);
        return this;
    }

}
