package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoginPage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    WebDriver driver;

    private By Username = By.id("user-name");
    private By Password = By.id("password");
    private By LoginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        logger.info("LoginPage object created");
    }

    public void setUsername(String Name) {

            logger.trace("Trying to find username field");
            driver.findElement(Username).sendKeys(Name);
            logger.debug("Entered username: {}", Name);

    }

    public void setPassword(String Pass) {
        try {
            logger.trace("Trying to find password field");
            driver.findElement(Password).sendKeys(Pass);
            logger.debug("Entered password");
        } catch (Exception e) {
            logger.error("Failed to enter password", e);
        }
    }

    public void clickLoginButton() {
        try {
            logger.trace("Trying to click login button");
            driver.findElement(LoginButton).click();
            logger.info("Clicked on login button");
        } catch (Exception e) {
            logger.error("Failed to click login button", e);
        }
    }

    public void login(String Name, String Pass) {
        logger.info("Starting login process with username: {}", Name);
        setUsername(Name);
        setPassword(Pass);
        clickLoginButton();
        logger.info("Login process completed");
    }
}
