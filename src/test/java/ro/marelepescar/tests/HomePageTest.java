package ro.marelepescar.tests;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import ro.marelepescar.pages.HomePage;
import ro.marelepescar.utils.ReportManager;

public class HomePageTest {

    private WebDriver driver;
    private HomePage homePage;

    // Variabile ExtentReports
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setUp() {
        // Inițializezi raportul
        extent = ReportManager.getExtentReports();

        System.setProperty("webdriver.chrome.driver", "C:\\calea\\catre\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://adresa-ta.com");
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void startTest(Method method) {
        // Crează un test nou în raport pentru fiecare test case
        test = extent.createTest(method.getName());
    }

    @Test
    public void loginButtonIsDisplayed() {
        boolean isDisplayed = homePage.isLoginButtonDisplayed();

        // Loghează în raport
        if (isDisplayed) {
            test.pass("Login button is displayed");
        } else {
            test.fail("Login button is NOT displayed");
        }

        // Assert clasic
        Assert.assertTrue(isDisplayed, "Login button should be visible on home page");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        // Scrie raportul în fișier
        if (extent != null) {
            extent.flush();
        }
    }
}
