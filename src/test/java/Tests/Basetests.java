package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Basetests {
    public static WebDriver driver;

    public static final Logger logger = LogManager.getLogger(LoginTest.class);

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("Browser launched and maximized");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.saucedemo.com/");
        logger.info("Navigated to saucedemo login page");
    }

}
