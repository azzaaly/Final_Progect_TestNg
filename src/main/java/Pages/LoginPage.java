package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //locators
    private By usernameLoginBox= By.xpath("//input[@id='loginusername']");
    private By passwordLoginBox=By.cssSelector("#loginpassword");
    private By loginButton=By.cssSelector("button[onclick='logIn()']");
    private By verifynameuser=By.id("nameofuser");
   // private By homeButtonLink=By.partialLinkText("Home");

    //actions
    public void enterUserName(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLoginBox));
        driver.findElement(usernameLoginBox).sendKeys(username);

    }
    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLoginBox));
        driver.findElement(passwordLoginBox).sendKeys(password);
    }
    public void clickOnLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        driver.findElement(loginButton).click();
    }
    public String validateusername(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(verifynameuser));
        String successmsg=driver.findElement(verifynameuser).getText();
        return successmsg;
    }

    public void waitForAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
    }
    public String getMessageAlert(){
        String message= driver.switchTo().alert().getText();
        return message;
    }

}
