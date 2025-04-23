package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    public CartPage(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //locators
    private By cartRows=By.cssSelector("#tbodyid>tr");
    private By totalPrice=By.id("totalp");
    private By placeOrderButton=By.xpath("//button[text()='Place Order']");
    private By nameBox= By.id("name");
    private By countyBox=By.id("country");
    private By cityBox=By.id("city");
    private By cardBox=By.id("card");
    private By monthBox=By.id("month");
    private By yearBox=By.id("year");
    private By textMessage=By.xpath("//*[contains(text(),'Thank you')]");
    private By purchaseButton=By.cssSelector("button[onclick='purchaseOrder()']");

    //actions
    public List<String>getProductNames(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartRows));
        List<String> names=new ArrayList<>();
        List<WebElement> rows=driver.findElements(cartRows);
        for (WebElement row:rows){
            names.add(row.findElements(By.tagName("td")).get(1).getText());

        }
        return names;
    }
    public List<String>getPrices(){

        List<String> prices=new ArrayList<>();
        List<WebElement> rows=driver.findElements(cartRows);
        for (WebElement row:rows){
            prices.add(row.findElements(By.tagName("td")).get(2).getText());
        }
        return prices;
    }
    public int getTotalPrices(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));
        return Integer.parseInt(driver.findElement(totalPrice).getText());
    }
    public void clickPlaceOrderButton(){

        // Wait for the modal to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("orderModal")));

        // Then wait for the button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
     driver.findElement(placeOrderButton).click();
    }

    public void insertName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameBox));
        driver.findElement(nameBox).sendKeys(name);
    }
    public void insertCountry(String country){
        wait.until(ExpectedConditions.visibilityOfElementLocated(countyBox));
        driver.findElement(countyBox).sendKeys(country);
    }
    public void insertCity(String city){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityBox));
        driver.findElement(cityBox).sendKeys(city);
    }
    public void insertCard(String card){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardBox));
        driver.findElement(cardBox).sendKeys(card);
    }
    public void insertMonth(String month){
        wait.until(ExpectedConditions.visibilityOfElementLocated(monthBox));
        driver.findElement(monthBox).sendKeys(month);
    }
    public void insertYear(String year){
        wait.until(ExpectedConditions.visibilityOfElementLocated(yearBox));
        driver.findElement(yearBox).sendKeys(year);
    }
    public String ValidateMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(textMessage));
        return driver.findElement(textMessage).getText();
    }
    public void ClickOnPurchaseBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(purchaseButton)).click();
    }
    public int countProductOccurrences(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartRows));
        int count = 0;
        List<WebElement> rows = driver.findElements(cartRows);
        for (WebElement row : rows) {
            String name = row.findElements(By.tagName("td")).get(1).getText();
            if (name.equalsIgnoreCase(productName)) {
                count++;
            }
        }
        return count;
    }

}



