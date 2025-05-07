package Tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import Pages.LoginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginTest extends Basetests {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    Faker faker =new Faker();
    @Feature("Login Feature")
    @Story("Successfull Login Story")
    @Test
    public void loginTest() {

        String username1 =faker.name().username();
        logger.info("Starting valid login test");
        LoginPage login = new LoginPage(driver);
        login.login(username1, "secret_sauce");

        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        logger.debug("Page title after login: {}", actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle, "Valid login failed!");
        logger.info("Valid login test passed");
    }

    @Story("Successfull Login Story")
    @Test
    public void invalidLogin() {
        logger.info("Starting invalid login test");
        LoginPage login = new LoginPage(driver);
        login.login("standard_user1", "secret_sauce");

        boolean isErrorDisplayed = driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
        logger.debug("Error message displayed: {}", isErrorDisplayed);

        Assert.assertTrue(isErrorDisplayed, "Expected error message not displayed!");
        logger.info("Invalid login test passed (error message appeared)");
    }



    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed and test ended");
        }
    }
}
