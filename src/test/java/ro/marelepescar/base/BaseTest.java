package ro.marelepescar.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ro.marelepescar.driver.DriverManager;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get("https://marelepescar.ro/");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}

