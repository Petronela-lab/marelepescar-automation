package ro.marelepescar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ro.marelepescar.utils.WaitUtils;

public class HomePage {
    private WebDriver driver;
    private WaitUtils waitUtils;

    // Selector pentru butonul Autentificare
    private By loginButtonLocator = By.cssSelector("a[title='Autentificare']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, 10);  // Timeout de 10 secunde
    }

    public boolean isLoginButtonDisplayed() {
        try {
            WebElement loginButton = waitUtils.waitForVisibility(loginButtonLocator);
            return loginButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Dacă vrei să adaugi o metodă pentru click pe butonul de login, folosind waitForClickable:
    public void clickLoginButton() {
        WebElement loginButton = waitUtils.waitForClickable(loginButtonLocator);
        loginButton.click();
    }
}
