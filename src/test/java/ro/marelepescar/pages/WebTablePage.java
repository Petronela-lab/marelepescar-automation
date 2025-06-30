package ro.marelepescar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTablePage {
    private final WebDriver driver;

    private final By tableLocator = By.cssSelector("selector-pentru-tabel"); // pune selectorul corect

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTableDisplayed() {
        return driver.findElement(tableLocator).isDisplayed();
    }
}

