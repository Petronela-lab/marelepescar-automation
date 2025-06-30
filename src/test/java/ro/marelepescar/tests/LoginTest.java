package ro.marelepescar.tests;

import org.testng.annotations.Test;
import ro.marelepescar.base.BaseTest;
import ro.marelepescar.pages.HomePage;
import ro.marelepescar.pages.LoginPage;
import ro.marelepescar.utils.PropertyUtility;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);

        PropertyUtility data = new PropertyUtility("loginData");
        String email = data.getProperty("email");
        String password = data.getProperty("password");

        loginPage.login(email, password);
    }
}

