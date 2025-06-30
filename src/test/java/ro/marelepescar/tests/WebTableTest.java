package ro.marelepescar.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ro.marelepescar.pages.HomePage;

public class WebTableTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        // 🔁 Schimbă calea cu cea corectă spre chromedriver de pe PC-ul tău!
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.marelepescar.ro/");  // Site-ul real

        homePage = new HomePage(driver);
    }

    @Test
    public void loginButtonIsDisplayed() {
        Assert.assertTrue(homePage.isLoginButtonDisplayed(), "Login button should be visible on home page");
    }

    @Test
    public void invalidLoginTest() {
        homePage.clickLoginButton();
        homePage.login("invalid@email.com", "wrongpassword");

        // Aici poți adăuga verificări suplimentare, de exemplu, mesajul de eroare
        // Exemplu (doar dacă ai un mesaj de eroare vizibil):
        // WebElement error = driver.findElement(By.cssSelector("div.error-msg"));
        // Assert.assertTrue(error.isDisplayed(), "Error message should be displayed for invalid login");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
