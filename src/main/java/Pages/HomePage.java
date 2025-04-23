package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locators
    private By signUpButtonLink = By.linkText("Sign up");
    private By loginButtonLink = By.partialLinkText("Log in");
    private By productOne=By.linkText("Nexus 6");
    private By productTwo=By.linkText("Iphone 6 32gb");
    private By cartLink=By.partialLinkText("Cart");

    //Actions
    public SignupPage clickOnSignUpButtonLink() {
      // wait.until(ExpectedConditions.elementToBeClickable(signUpButtonLink));
        driver.findElement(signUpButtonLink).click();
        return new SignupPage(driver);

    }

    public LoginPage clickOnLoginPageLink() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonLink)).click();
        return new LoginPage(driver);
    }
  public ProductOnePage clickOnProductOne(){
      wait.until(ExpectedConditions.elementToBeClickable(productOne)).click();
        return new ProductOnePage(driver);
    }
    public ProductTwoPage clickToAddProductTwo(){
        wait.until(ExpectedConditions.elementToBeClickable(productTwo)).click();
        return new ProductTwoPage(driver);
    }
public CartPage ClickOnCartPage(){
   wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
        return new CartPage(driver);

}

}