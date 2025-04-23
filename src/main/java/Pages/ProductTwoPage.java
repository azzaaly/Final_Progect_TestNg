package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductTwoPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductTwoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By addToCartButton = By.cssSelector(".btn.btn-success.btn-lg");

    public void ClickOnAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();

    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    public void waitForAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
    }

}