package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
    WebDriver driver;
    WebDriverWait wait;
    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
        // Locators
        private By usernameBox = By.id("sign-username");
        private By passwordBox = By.id("sign-password");
        private By signupButton = By.cssSelector("button[onclick='register()']");
    // Actions
    public void insertUsername(String fakeUsername) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameBox)).sendKeys(fakeUsername);
    }

    public void insertPassword(String fakerPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordBox)).sendKeys(fakerPassword);
    }

    public void clickOnSignupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton)).click();
    }
    public void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public String getAlertText() {
        waitForAlert(); //
        return driver.switchTo().alert().getText();
    }
    public void acceptAlert() {
        waitForAlert(); //
        driver.switchTo().alert().accept();
    }
}


